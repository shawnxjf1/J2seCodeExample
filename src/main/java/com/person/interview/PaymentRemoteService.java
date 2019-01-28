package com.person.interview;

/**
 * 用户有多种支付方式（余额、红包、优惠券，代金券等），假如每种支付方式需要通过实时调用远程服务获取可用性。
 * 在外部资源环境不变情况下，请设计程序以最短响应时间获得尽可能多的可用支付方式列表。<br>
 * 假定支付方式可用性咨询接口定义：PaymentRemoteSerivce
 * 接口方法：ConsultResult isEnabled(String paymentType);
 * 返回结果：
 *
 public class ConsultResult {
 public ConsultResult (boolean isEnable,String  errorCode){
 this.isEnable = isEnable;
 this.errorCode= errorCode;
 }
 */

public interface PaymentRemoteService {
    ConsultResult isEnabled(String paymentType);
}
