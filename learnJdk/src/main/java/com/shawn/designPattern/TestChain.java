package com.person.designPattern;

import org.junit.Test;

import java.util.List;



/**
 * 以供两个接口，filter，filterChain，在调用filterchain时候能够触发 fiter的调用且可以指针往下移。
 * FIXME  待完善。
 * Created by xujf on 2017/10/31.
 */
public class TestChain {

    List<Chain>  chainList;

    @Test
    public void testChains()
    {
     //   Chain2 chan2 = new Chain2(null);
       // Chain1 chan1 = new Chain1(chan2);

    }

    public interface  Chain{
        public Chain getNextChain();

        public void doSomeThing(Chain chain);

    }

    public class Chain1 implements Chain
    {
        private Chain nextChain;

        Chain1(Chain nextChain)
        {
            this.nextChain = nextChain;
        }

        @Override
        public Chain getNextChain() {
            return null;
        }

        @Override
        public void doSomeThing(Chain chain) {
            //
            //如何变到下一个呢？
            Chain nextChain = chain.getNextChain();
            if (nextChain != null)
            {
                chain.doSomeThing(nextChain);
            }

        }
    }

//    public class Chain2 implements  Chain{
//
//        private Chain nextChain;
//
//        Chain2(Chain nextChain)
//        {
//            this.nextChain = nextChain;
//        }
//
//        @Override
//        public Chain getNextChain() {
//            return null;
//        }
//
//        @Override
//        public void doSomeThing() {
//
//        }
//    }
}
