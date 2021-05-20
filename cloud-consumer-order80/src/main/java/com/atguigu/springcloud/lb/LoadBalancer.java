package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 自旋锁 cas  LoadBalancer 来实现 收集 服务器集群上一共有多少台可以提供服务的服务器
 *
 * @author sunxc
 * @date 2020/11/18 17:20
 */

public interface LoadBalancer {
    /**
     * instance
     *
     * @param serviceInstances serviceInstances
     * @return org.springframework.cloud.client.ServiceInstance
     * @author sunxc50
     * @date 2021/05/20 16:33
     */
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
