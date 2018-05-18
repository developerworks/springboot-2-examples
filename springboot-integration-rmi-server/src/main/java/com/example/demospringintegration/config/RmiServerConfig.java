package com.example.demospringintegration.config;

import com.example.demospringintegration.service.DnsService;
import com.example.demospringintegration.service.impl.DnsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

@Configuration
public class RmiServerConfig {

    @Bean
    RmiServiceExporter exporter(DnsService implementation) {
        Class<DnsService> serviceInterface = DnsService.class;
        RmiServiceExporter exporter = new RmiServiceExporter();
        // 接口
        exporter.setServiceInterface(serviceInterface);
        // 实现
        exporter.setService(implementation);
        // 服务名称
        exporter.setServiceName(serviceInterface.getSimpleName());
//        exporter.setRegistryHost("127.0.0.1");
        // 端口
        exporter.setRegistryPort(1099);
        return exporter;
    }
}
