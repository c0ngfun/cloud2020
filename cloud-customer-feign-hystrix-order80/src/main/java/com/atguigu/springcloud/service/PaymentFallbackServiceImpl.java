package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author sunxc
 * @version 1.0
 * @date 2020/11/21 16:30
 */
@Component
public class PaymentFallbackServiceImpl implements PaymentHystrixService {

    /**
     * paymentInfoOk
     *
     * @param id id
     * @return java.lang.String
     * @author sunxc50
     * @date 2021/05/20 18:36
     */
    @Override
    public String paymentInfoOk(Integer id) {
        return "PaymentFallbackService paymentInfo_OK,o(╥﹏╥)o";
    }

    /**
     * paymentInfoTimeout
     *
     * @param id id
     * @return java.lang.String
     * @author sunxc50
     * @date 2021/05/20 18:37
     */
    @Override
    public String paymentInfoTimeout(Integer id) {
        return "PaymentFallbackService paymentInfo_Timeout,o(╥﹏╥)o";
    }
}
