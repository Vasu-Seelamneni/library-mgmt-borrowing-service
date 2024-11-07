package com.msp.library.mgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableFeignClients(basePackages = "com.msp.library.mgmt.client")
public class LibraryMgmtBorrowingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryMgmtBorrowingServiceApplication.class, args);
    }

}
