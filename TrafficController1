package ru.rzn.sbt.javaschool.lesson10.cars;


import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TrafficController {
    public Lock lock=new ReentrantLock();
    public  void enterLeft() {
        lock.lock();
    }

    public  void enterRight() {
        lock.lock();

    }

    public void leaveLeft() {
        lock.unlock();
    }

    public void leaveRight() {
        lock.unlock();
    }
}
