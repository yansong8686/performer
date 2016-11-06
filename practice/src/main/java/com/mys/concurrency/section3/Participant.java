package com.mys.concurrency.section3;

import java.util.concurrent.TimeUnit;

/**
 * 与会者类
 * Created by manyansong on 2016/11/6.
 */
public class Participant implements Runnable{
    private Videoconference conference;//声明视频会议对象
    private String name;

    public Participant(Videoconference conference, String name) {
        this.conference = conference;
        this.name = name;
    }

    @Override
    public void run() {
        long duration = (long)(Math.random()*10);
        try {
            TimeUnit.SECONDS.sleep(duration);
            conference.arrive(name);//一个与会者到达会场
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
