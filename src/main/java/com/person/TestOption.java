package com.person;


import org.junit.Test;

import java.util.Optional;

/**
 * Created by xujf on 2017/11/3.
 */
public class TestOption {

    class Competition{
        User u ;

        public User getU() {
            return u;
        }

        public void setU(User u) {
            this.u = u;
        }
    }

    class User
    {
        /**
         * 必填
         */
        String userId;
        /**
         * 必填
         */
        String userName;
        /**
         * 可选
         */
        String address;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public Optional<String> getAddress() {
            // of 如果是空的话就抛出空指针，所以肯定是不为空的。
            // 如果我们返回参数是可空的话，则使用Optional返回。
            //return Optional.of(this.address);
            return Optional.ofNullable(this.address);
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }

    /**
     * 1.这是一个可以为null的容器对象。如果值存在则isPresent()方法会返回true，调用get()方法会返回该对象。<br>
     */
    @Test
    public void testSafeCallWithOptionalNull()
    {
        User u = new User();
        u.setUserId("123");
        u.setUserName("userName");

        Competition c = new Competition();
        c.setU(u);

        Optional<Competition> com = Optional.ofNullable(c);
        //return com.map(c1 -> c1.getU()).map(u1 -> u1.getAddress()).orElse(() -> throw new NullPointerException("123"));
        Optional<String> optionalReturn =  com.map(c1 -> c1.getU()).map(u1 -> u1.getAddress()).orElseThrow(()->new NumberFormatException("123"));
        System.out.println("optionalReturn=" + optionalReturn);
    }

    @Test
    public void testSafeCallWithOptionalNull1()
    {


        Competition c = new Competition();
        c.setU(null);

        Optional<Competition> com = Optional.ofNullable(c);
        //return com.map(c1 -> c1.getU()).map(u1 -> u1.getAddress()).orElse(() -> throw new NullPointerException("123"));
        Optional<String> optionalReturn =  com.map(c1 -> c1.getU()).map(u1 -> u1.getAddress()).orElseThrow(()->new NumberFormatException("123"));
        System.out.println("optionalReturn=" + optionalReturn);
    }

}
