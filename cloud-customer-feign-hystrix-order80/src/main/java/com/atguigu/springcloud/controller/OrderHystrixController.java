package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * //@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod") 全局默认的fallback方案
 *
 * @author sunxc
 * @version 1.0
 * @date 2020/11/21 15:06
 */
@RestController
@Slf4j

@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    /**
     * paymentInfoOk
     *
     * @param id id
     * @return java.lang.String
     * @author sunxc50
     * @date 2021/05/20 18:14
     */
    @GetMapping("/consumer/payment/hystrix/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfoOk(id);
    }

/*    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id")Integer id){
        return paymentHystrixService.paymentInfo_Timeout(id);
    }*/

    /*
     * 超时访问的方法
     */
/*    @HystrixCommand(fallbackMethod = "paymentinfo_TimeoutHandler" , commandProperties = {
            //设置峰值，超过 1.5（1500"）秒，就会调用兜底方法,三秒以内走正常的方法                         每个方法都配置一个兜底的方法就会造成代码冗余,这样的类似自定义的
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",  value= "1500")
    })*/

    /**
     * paymentInfoTimeout  //加@HystrixCommand  会采用默认全局的兜底方法，因为没有指定 fallbackMethod
     *
     * @param id id
     * @return java.lang.String
     * @author sunxc50
     * @date 2021/05/20 18:30
     */
    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfoTimeout(@PathVariable("id") Integer id) {

        return paymentHystrixService.paymentInfoTimeout(id);
    }

    //兜底方法，根据上述配置，程序内发生异常、或者运行超时，都会执行该兜底方法
  /*  public String paymentinfo_TimeoutHandler(@PathVariable("id") Integer id){
        return "我是80，对方系统忙或者自己运行错误o(╥﹏╥)o";
    }*/


    /**
     * 目的是通用的和独享的各自分开
     * 这个是全局的fallback方法
     *
     * @return java.lang.String
     * @author sunxc50
     * @date 2021/05/20 18:32
     */
    public String paymentGlobalFallbackMethod() {
        return "系统异常，请稍后再试~~";
    }
}
