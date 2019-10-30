/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.shawn.javautil;
import java.util.HashMap;
import java.util.Map;

/**
 * 由于web容器使用线程池，那么线程可能会被复用（用完会丢回线程池threadLocal信息保留了）<br>
 * 会出现的问题：两个请求复用一个线程情况下后面的请求会使用前一个请求中在threadLocal中保留的信息，如何解决这种问题每次用完在threadLocal remove掉或者每次请求使用时候先put(覆盖以前的)</>
 */
@Slf4j
public abstract class ThreadLocalUtils {

    private static final ThreadLocal<Map<String, Object>> RESOURCES = new ThreadLocal<>();

    public static Map<String, Object> getResources() {
        return RESOURCES != null ? new HashMap<String, Object>(RESOURCES.get()) : null;
    }

    private static Object getValue(String key) {
        return RESOURCES.get().get(key);
    }

    public static Object get(String key) {
        Object value = getValue(key);
        log.info("Retrieved value of type [{}] for key [{}] bound to thread [{}].", value.getClass().getName(), key, Thread.currentThread().getName());
        return value;
    }

    /**
     * 注意一定要在继承 org.springframework.web.servlet.HandlerInterceptor的post或者complete方法中调用该方法在请求结束把keyremove掉<br>
     *
     * @param key
     * @return
     */
    public static Object remove(String key) {
        Object value = RESOURCES.get().remove(key);
        log.info("Removed value of type [{}] for key [{}] from thread [{}].", value.getClass().getName(), key, Thread.currentThread().getName());
        return value;
    }

    public static void put(String key, Object value) {
        if (null == key) {
            log.info("key is null,so not put into threadLocal");
            return;
        }

        if (null == RESOURCES.get()) {
            //这个很主要，第一次必须设置进去，每个线程是一个单独的map<br>
            RESOURCES.set(new HashMap<String, Object>());
        }

        //这里会覆盖以前的key和value<br>
        RESOURCES.get().put(key, value);
        log.info("Bound value of type [{}] for key [{}] to thread [{}].", value.getClass().getName(), key, Thread.currentThread().getName());
    }

    public static void remove() {
        RESOURCES.remove();
    }
}