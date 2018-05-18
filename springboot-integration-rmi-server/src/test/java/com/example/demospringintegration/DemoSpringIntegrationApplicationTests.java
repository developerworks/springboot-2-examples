package com.example.demospringintegration;

import com.example.demospringintegration.service.DnsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureWebTestClient
public class DemoSpringIntegrationApplicationTests {


    @Autowired
    WebTestClient webTestClient;

	@Test
	public void contextLoads() {
	}

//	@Test
//    public void getNameTests() {
//        this.webTestClient
//            .get().uri("/query?ip=192.168.0.1")
//            .exchange()
//            .expectStatus().isOk()
//            .expectHeader().contentType("text/plain;charset=UTF-8")
//            .expectBody(String.class)
//            .isEqualTo("www.yumi.app");
//    }

    @Test
    public void rmiGetNameTests() {
        this.webTestClient
            .get().uri("/rmi/query?ip=192.168.0.1")
            .exchange()
            .expectStatus().isOk()
            .expectHeader().contentType("text/plain;charset=UTF-8")
            .expectBody(String.class)
            .isEqualTo("www.yumi.app");
    }

}
