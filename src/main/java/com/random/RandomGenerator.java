package com.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
/**
 * 1. 多线程并发调用随机数生成函数，并在主线程中判断子线程返回的随机数是否真的“随机”。
 * 提示： 主线程创建N个子线程，再每个子线程中分别生成M个随机数并分别返回给主线程，
 * 主线程merge所有结果后，使用一定的策略算法判断是否随机；
 *   a).随机算法如何产生，
 *   方法一，可以每个线程在一个数据区间内产生随机数（计算机算法产生的都是伪随机数），然后把这些随机序列再随机合并。
 *   方法二，子线程共用一个 共享存储空间，有一个捡数的指针随机的从其中挑随机数（如果该随机数用过则挑下一个），这种情况下就是需要对并发进行控制。
 *   本代码采用方法一，每个子线程产生不重叠区间的随机数，然后把这些子线程返回的结果*随机*组合成一个随机数组。
 *   如何随机组合，一次从N子线程结果中随机选一个结果序列。
 *   选一个随机数分两步：先数子数目即去哪个子数组挑选，比如random1,random2,random3...randomN,假设第一次随机选了radom2。
 *   再再从random2中*按顺序（不用随机挑是减少算法复杂度且可以保证大致随机挑）*挑选一个随机数把它放入最终结果，依次从0的位置挑。同时记录每个random子数组选取的进度。
 *   接着选第二个随机数，步骤与前面类似，只是要对选出的随机数位置判断map(randomx_y)是否为1，如果是继续随机挑选。（这有待改进）。
 *
 *   b).使用策略算法判断随机。
 *   本算法只根据方法一制定出随机策略检测算法，有两种方式。
 *   1).方法1：检测随机挑选的过程，比如不能3个连续都是在random1中挑选，（由于random1中已经满足伪随机，所以从random1第几个挑选随意）。
 *   2).方法2：检测结果，比如计算每个数据的检测是否均匀分布，是否是递增。
 *   不严格的做法非用数学相关理论的话（随机算法方法一的缺点），检测生成的结果是否具有前M个是否大体小于后M个随机数，如果是就是非随机的。
 */
public class RandomGenerator {
    private static final int RANDOM_NUM = 1000;
    private static final int THREADS_N = 2;

    public static void main(String[] args) {
        System.out.println("Shared Random");
        new RandomGenerator().generateRandom(THREADS_N, RANDOM_NUM);
    }

    class RandomCallable implements Callable<int []>
    {
        int threadNum;
        int randomCountM;
        Random rnd = new Random();
        //member 成员变量<br>

        private RandomCallable(int threadNum,int randomCountM) {
            this.threadNum = threadNum;
            this.randomCountM = randomCountM;
        }

        @Override
        public int[] call() throws Exception {
            int[] threadGeneRs = new int[randomCountM];
            for (int j = 0; j < randomCountM; ++j) {
                //每个线程随机数不重叠那么需要加上 threadNum*randomCountM（前面的数据有前面的线程生成）
                int  rs = rnd.nextInt(randomCountM) + threadNum*randomCountM;
                threadGeneRs[j]= rs;
            }
            return threadGeneRs;
        }
    }

    public void generateRandom(final int threads, final long cnt) {
        ExecutorService exec= Executors.newFixedThreadPool(threads);

        int []threadPickProcess = new int[threads];

        List<Future<int []>> fuList=new ArrayList<Future<int []>>();
        for (int i = 0; i < threads; ++i) {
            fuList.add(exec.submit(new RandomCallable(i,RANDOM_NUM)));
        }

        int totalNum = threads * RANDOM_NUM;
        int [] totalRandomRs = new int [totalNum];
        Random r = new Random();

        while(true) {
            int totalIndexProcess = 0;
            int randomThreadNum = r.nextInt(threads);
            try {
                int[] fArray = (int[]) fuList.get(randomThreadNum).get();
                int curProcessIndex = threadPickProcess[randomThreadNum];
                if (curProcessIndex >= RANDOM_NUM) {
                    //log.info("thread1 随机数已经取完了")
                }
                totalRandomRs[totalIndexProcess] = fArray[curProcessIndex];
                //log.info("在子线程队列:{}取第:{}个数")

                //FIXME 记录取数过程，便于后面分析<br>

                //取数进度加1<br>
                threadPickProcess[randomThreadNum]++;
            } catch (Exception e) {
                //打印log日志<br>
            }
        }
    }

    /**
     * 通过取数过程校验是否随机<br>
     */
    public void validateWithPickProcess()
    {

    }

    /**
     * 通过取数结果进行校验是否随机<br>
     */
    public void validateWithResult()
    {

    }

}