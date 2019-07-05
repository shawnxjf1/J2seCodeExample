package com.shawn.google.rateLimiter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Task implements Runnable {
    String str;
    public Task(String str) {
        this.str = str;
    }
    @Override
    public void run() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        System.out.println(sdf.format(new Date()) + " | " + Thread.currentThread().getName() + str);
    }
}
