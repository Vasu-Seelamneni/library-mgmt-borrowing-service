package com.msp.library.mgmt.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "library-mgmt-user-service")
public interface UserClient {

    @GetMapping("/api/users/exists/{userId}")
    Boolean isUserExists(@PathVariable("userId") Long userId);

}

