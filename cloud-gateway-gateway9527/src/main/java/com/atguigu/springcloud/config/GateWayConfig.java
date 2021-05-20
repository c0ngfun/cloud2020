package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 网关路由配置有两种方式一种是配置文件  一种是硬编码 如下
 *
 * @author sunxc
 * @version 1.0
 * @date 2020/11/21/0021-22:56
 */
@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        /*配置了一个id为path_route_atguigu的路由规则
        解释：如果访问 localhost:9527/guonei   将会被自动转发到http://news.baidu.com/guonei*/
        routes.route("path_route_atguigu",
                r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }
}
