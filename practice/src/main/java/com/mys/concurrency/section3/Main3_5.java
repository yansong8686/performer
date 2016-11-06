package com.mys.concurrency.section3;

import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier实例
 * Created by manyansong on 2016/11/6.
 */
public class Main3_5 {
    public static void main(String[] args) {
        final int ROWS = 10000;
        final int NUMBERS = 1000;
        final int SEARCH = 5;
        final int PARTICIPANTS = 5;
        final int LINES_PARTICIPANT=2000;

        MatrixMock mock = new MatrixMock(ROWS, NUMBERS, SEARCH);
        Results results = new Results(ROWS);

        Grouper grouper = new Grouper(results);
        CyclicBarrier barrier = new CyclicBarrier(PARTICIPANTS,grouper);
        Searcher searcher[] = new Searcher[PARTICIPANTS];
        for (int i = 0; i < PARTICIPANTS; i++) {
            searcher[i] = new Searcher(i*LINES_PARTICIPANT,(i*LINES_PARTICIPANT)+LINES_PARTICIPANT,
                    mock, results, 5, barrier);
            Thread thread = new Thread(searcher[i]);
            thread.start();
        }
        System.out.printf("Main:The main thread has finished.\n");
    }
}
