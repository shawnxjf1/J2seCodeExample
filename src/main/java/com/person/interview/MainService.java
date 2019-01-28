package com.person.interview;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 1.分为定时和实时两种方式，把请求到的结果放到缓存，比如redis里<br>
 * 2.最短时间内获得尽可能多的支付方式列表，这个就采用多线程么？<br>
 * 3.尽早的先测试信赖度比较高/速度相对快的渠道  --- 暂时不考虑这种场景<br>
 */
public class MainService {
    PaymentRemoteService paymentRemoteService;

    Map<String,ConsultResult> channelResultMap ;
    List<Channel> usableChannels;

    Log log = LogFactory.get();

    public  void getUsableChannels()
    {
        CompletableFuture<List<Channel>> channelUsableRs = new CompletableFuture<>();
        CompletableFuture.runAsync(() -> {
            try {
                channelUsableRs.complete(getEnableChannels());
            } catch (Exception e) {
                channelUsableRs.completeExceptionally(e);
            }
        });
    }

    public    List<Channel> getEnableChannels() {
        return Stream.of(Channel.values()).parallel().filter(this::isChannelEnabled)
                .collect(Collectors.toList());
    }

    public   boolean isChannelEnabled(Channel paymentType) {
        ConsultResult result = paymentRemoteService.isEnabled(paymentType.toString());
        if (!result.isEnable()) {
            CompletableFuture.runAsync(() -> {
                log.debug("Payment type " + paymentType + " is disabled with error code " + result.getErrorCode());
            });
        }
        return result.isEnable();
    }

}
