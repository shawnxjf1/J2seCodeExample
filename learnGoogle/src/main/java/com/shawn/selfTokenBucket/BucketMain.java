package com.shawn.selfTokenBucket;

public class BucketMain {
    public static void main(String[] args) throws InterruptedException {
        TokenBucket tokenBucket=TokenProducerManager.addTokenAtFixRate("request a",1l,2000);

        Thread.sleep(6000L);
        System.out.println(tokenBucket.getToken());
        System.out.println(tokenBucket.getToken());
        System.out.println(tokenBucket.getToken());
        System.out.println(tokenBucket.getToken());
        System.out.println(tokenBucket.getToken());
        System.out.println(tokenBucket.getToken());
        System.out.println(tokenBucket.getToken());
        System.out.println(tokenBucket.getToken());
        System.out.println(tokenBucket.getToken());
        System.out.println(tokenBucket.getToken());
        System.out.println(tokenBucket.getToken());
    }
}
