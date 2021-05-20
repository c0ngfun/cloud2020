package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义负载均衡 算法
 *
 * @author sunxc
 * @version 1.0
 * @date 2020/11/20  23:55
 */
@Component
public class MyLoadBalance implements LoadBalancer {

    private final AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * getAndIncrement
     *
     * @return int
     * @author sunxc50
     * @date 2021/05/20 18:01
     */
    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("*************第几次访问，次数*next:" + next);
        return next;
    }

    /**
     * 这个方法告诉我们
     * 负载均衡算法：: rest接口第几次请求数%服务器集群总数量=实际调用服务器位置下标，
     * 每次服务重启动后rest接口计数从1开始。
     */
    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
