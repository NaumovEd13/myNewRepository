package ru.rzn.sbt.javaschool.lesson10.cars;

import java.util.concurrent.atomic.AtomicInteger;

public class TrafficController {
    public AtomicInteger leftCar=new AtomicInteger(0);
    public AtomicInteger rightCar=new AtomicInteger(0);
    public synchronized void enterLeft() {
        while(rightCar.get()!=0){
            try {
                Thread.sleep(1);
            }
            catch(Exception e){
                e.getMessage();
            }
        }
        leftCar.incrementAndGet();
    }

    public synchronized void enterRight() {
        while(leftCar.get()!=0){
            try {
                Thread.sleep(1);
            }
            catch(Exception e){
                e.getMessage();
            }
        }
        rightCar.incrementAndGet();

    }

    public void leaveLeft() {
        rightCar.decrementAndGet();
    }

    public void leaveRight() {
        leftCar.decrementAndGet();
    }
}