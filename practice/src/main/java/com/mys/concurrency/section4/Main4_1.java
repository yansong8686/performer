package com.mys.concurrency.section4;

/**
 * Created by ASUS on 2016/11/6.
 */
public class Main4_1 {
    public static void main(String[] args) {
        Server server = new Server();
        for (int i = 0; i < 100; i++) {
            Task task = new Task("Task "+i);
            server.executeTask(task);
        }
        server.endServer();
    }
}
