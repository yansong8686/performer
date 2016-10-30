package com.mys.concurrency.section2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 实现一个缓存系统
 * 鉴于用户和数据库中间的一个环节，我们知道用户直接访问数据库的时间是远大于直接访问内存，
 * 所以有了缓存区后用户访问数据时 这样，用户先访问缓存区当缓存区有用户需要的数据时直接拿走，
 * 当缓存区没有这样的数据，访问数据库并把访问所得的数据放在缓存区，
 * 这样当下一个需要这个数据的用户就直接访问内存即可得到。
 * 代码分析：
 * 用第一种方法处理，整个过程比较粗线条，代码比较简单单执行效率很低。这种方法的中心思想是不管你是什么操作，
 * 但凡涉及到公共资源就都给你同步。这么做可以是可以但是并不好。
 * 第二种用读写锁处理显然是对前者的一个优化，对第二种方法做如下几点说明：
 * 关于unlock操作，我们知道只要是上了锁就必须要解锁，但是有这么一种情况就是当你上完锁后在执行解锁操作前程序出现异常，
 * 那这个所可能就一直存在。所以针对这个问题我们一般将unlock操作放在finally代码块中，就可以保证上了的锁一定会被解。
 * 上面的两次if判断，第一个if相信大家很好理解。
 * 但为什么要用第二个if呢？再假设一个场景，现在有十个线程来读这个数据，
 * 而这个数据又不存在与缓存区，那么这十个线程中最先到的线程将执行“rw.writeLock().lock();”而另外九个线程将被阻塞，
 * 当第一个线程读完以后缓存区实际上已经就有了这个数据，但另外九个阻塞在“rw.writeLock().lock();”
 * 如果不加这层if他们会继续访问数据库，由此可见加了这层if对整个过程影响很大。
 * Created by manyansong on 2016/10/30.
 */
public class Main2_6_1 {

    Map<String,Object> map = new HashMap<>();//共享资源
    ReadWriteLock rw = new ReentrantReadWriteLock();

    /**
     * 方法2
     * @param key
     * @return
     */
    public Object getData2(String key){
        rw.readLock().lock();//在读前先上读锁
        Object result = null;
        try{
            result = map.get(key);
            //这个if比较关键，它避免了多余的几次对数据库的读取
            if(result==null){
                //如果内存中没有所要数据
                rw.readLock().unlock();
                rw.writeLock().lock();
                if(result==null){//这个if就比较有意思了
                    try{
                        //我们用这个代替对数据库访问得到数据的步骤
                        result = "new";
                    }finally{
                        rw.writeLock().unlock();
                    }
                    rw.readLock().lock();
                }
            }
        }finally{
            rw.readLock().unlock();
        }
        return result;

    }

    /**
     * 方法1
     * @param key
     * @return
     */
    public synchronized Object getData1(String key){
        Object result = map.get(key);
        if(result ==null){
            result = "new";//用这步代替访问数据库得数据
        }
        return result;

    }
}
