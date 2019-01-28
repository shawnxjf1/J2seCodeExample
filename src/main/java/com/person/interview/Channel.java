package com.person.interview;

public enum Channel {
    //余额、红包、优惠券，代金券
    BALANCE_PAY("balance_pay"),    // pay with balance
    COUPON_PAY("coupon_pay"),     // pay with coupon discount
    VOUCHER_PAY("voucher_pay"),    // pay with something like gift card
    LAISEE_PAY("laisee_pay");     // pay with red pocket, so called 红包 in Chinese

    Channel(String url) {
        this.url = url;
    }
    private String url;
}