package com.mys.concurrency.section1;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Created by Jerry on 2016/10/16.
 */
public class Calculator1_4 implements Runnable {

    private int number;

    public Calculator1_4(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for(int i=1;i<=10;i++){
            System.out.printf("%s:%d * %d=%d\n",Thread.currentThread().getName(),number,i,i*number);
        }
    }

    public static void main(String[] args) {
//        PrintWriter pw = null;
        /*try{
            FileWriter file = new FileWriter("E:\\idea\\log.txt");
//            file.write("ddddd");
//            file.close();
            pw = new PrintWriter(new BufferedWriter(file));
            pw.printf("test++++++");
            pw.flush();

        }catch (Exception e){
            System.out.printf("exception e"+e);
        }*/
        Thread threads[] = new Thread[10];
        Thread.State status[] = new Thread.State[10];//存放10个线程运行时的状态
        for(int i=0;i<10;i++){
            threads[i] = new Thread(new Calculator1_4(i));
            if(i%2==0){
                threads[i].setPriority(Thread.MAX_PRIORITY);//将序号是偶数的线程，设置优先级最高
            }else{
                threads[i].setPriority(Thread.MIN_PRIORITY);//将序号是奇数的线程，设置优先级最低
            }
            threads[i].setName("Thread"+i);
            /*Calculator1 calculator = new Calculator1(i);
            Thread thread = new Thread(calculator);
            thread.start();*/
       }
        PrintWriter pw = null;
        try{
            FileWriter file = new FileWriter("E:\\idea\\log.txt");
            pw = new PrintWriter(file);
            pw.printf("test++++++%s","aaa");
            for(int i=0;i<10;i++){
                pw.println("Main : Status of Thread "+i+" : "+threads[i].getState());
                status[i] = threads[i].getState();
            }
            pw.flush();
        }catch (Exception e){
            System.out.printf("exception e"+e);
        }
        for(int i=0;i<10;i++){
            threads[i].start();
        }
        boolean finish = false;
        while(!finish){
            for(int i=0;i<10;i++){
                if(threads[i].getState()!=status[i]){
                    writeThreadInfo(pw,threads[i],status[i]);
                    pw.flush();
                    status[i]=threads[i].getState();
                }
            }
            finish = true;
            for (int i=0;i<10;i++){
                finish = finish && (threads[i].getState() == Thread.State.TERMINATED);
            }
        }
    }

    public static void writeThreadInfo(PrintWriter pw,Thread thread,Thread.State state){
        pw.println("Main : Id "+thread.getId()+" -"+thread.getName());
        pw.println("Main : Priority:"+ thread.getPriority());
        pw.println("Main : Old State : " + state);
        pw.println("Main : New State :"+ thread.getState());
        pw.println("Main : ***************************************");

//        System.out.printf("Main : Id %d - %s \n",thread.getId(),thread.getName());
//        System.out.printf("Main : Priority:%d\n",thread.getPriority());
//        System.out.printf("Main : Old State : %s\n",state);
//        System.out.printf("Main : New State :%s\n",thread.getState());
//        System.out.printf("Main : ***************************************\n");
    }
}
