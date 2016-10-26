package com.mys.concurrency.section2;

import java.util.Objects;

/**
 * 当去掉同步块，同时增加sleep就能模拟，并发造成的数据不一致
 * Created by ASUS on 2016/10/25.
 */
public class Cinema {
    private long vacanciesCinemal;
    private long vacanciesCinema2;
    private final Object controlCinema1,controlCinema2;

    public Cinema(){
        controlCinema1 = new Object();
        controlCinema2 = new Object();
        vacanciesCinemal = 20;
        vacanciesCinema2 = 20;
    }

    public  boolean sellTickets1(int number){
        synchronized (controlCinema1){
            if(number < vacanciesCinemal){
                vacanciesCinemal-=number;
                /*try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                return true;
            }else{
                return false;
            }
        }
    }
    public  boolean sellTickets2(int number){
        synchronized (controlCinema2){
            if(number < vacanciesCinema2){
                vacanciesCinema2-=number;
               /* try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                return true;
            }else{
                return false;
            }
        }
    }

    public boolean returnTickets1(int number){
        synchronized (controlCinema1){
            vacanciesCinemal += number;
        /*try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return true;
        }
    }

    public boolean returnTickets2(int number){
        synchronized (controlCinema2){
            vacanciesCinema2 += number;
           /* try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            return true;
        }
    }

    public  long getVacanciesCinemal(){
        return  vacanciesCinemal;
    }

    public  long getVacanciesCinema2(){
        return  vacanciesCinema2;
    }

}
