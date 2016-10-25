package com.mys.concurrency.section1;

/**
 * Created by Jerry on 2016/10/18.
 */
public class PrimeGenerator extends Thread{

    @Override
    public void run() {
        long number = 1L;
        while (true){
            if(isPrime(number)){
                System.out.printf("Number %d id Prime%n",number);
            }
            if(isInterrupted()){//检查当前线程是否被中断
                System.out.printf("The Prime Generator has been interrupted");
                return;
            }
            number++;
        }
    }

    private boolean isPrime(long number) {
        if(number <=2 ){
            return  true;
        }
        for (long i = 2; i < number; i++) {
            if((number%i)==0){
                return  false;
            }
        }
        return  true;
    }

    public static void main(String[] args) {
        Thread task = new PrimeGenerator();
        task.start();
        try {
            Thread.sleep(38);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        task.interrupt();
    }

}
