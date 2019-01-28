package com.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import java.lang.Object;

/**
 * Created by xujf on 2017/7/20.
 */
//@slf4j

    //FIXME  拦截器 advice还没写呢
public class ApiExceptionInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        try {
            return invocation.proceed();
        } catch (Exception ebe) {
            //FIXME 完善 log日志
            //log.error("api error,serviceName:{},arg:{},errorCode:{},exception", invocation.getMethod(), ArgumentUtil.transfer(invocation.getArguments()), ebe.getErrorCode(), ebe);
        }
        //可以完善成 纷享里的Result.newSucces里来处理。
        return null;
    }
}
