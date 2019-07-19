package com.shawn.google.rateLimiter;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.Executors;

/**
 * 参考博客:https://segmentfault.com/a/1190000015967922 <br>
 */
public class RateLimiterTest {
        public static void main(String[] args) {
            ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(100));
            // 指定每秒放1个令牌
            RateLimiter limiter = RateLimiter.create(1);
            for (int i = 1; i < 50; i++) {
                // 请求RateLimiter, 超过permits会被阻塞
                //acquire(int permits)函数主要用于获取permits个令牌，并计算需要等待多长时间，进而挂起等待，并将该值返回
                Double acquire = null;
                if (i == 1) {
                    acquire = limiter.acquire(1);
                } else if (i == 2) {
                    acquire = limiter.acquire(10);
                } else if (i == 3) {
                    acquire = limiter.acquire(2);
                } else if (i == 4) {
                    acquire = limiter.acquire(20);
                } else {
                    acquire = limiter.acquire(2);
                }
                executorService.submit(new Task("获取令牌成功，获取耗：" + acquire + " 第 " + i + " 个任务执行"));
            }
        }
}