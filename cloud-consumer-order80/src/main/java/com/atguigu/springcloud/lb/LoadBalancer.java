package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;
//自旋锁 cas
/*LoadBalancer 来实现 收集 服务器集群上一共有多少台可以提供服务的服务器*/
public interface LoadBalancer {
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
