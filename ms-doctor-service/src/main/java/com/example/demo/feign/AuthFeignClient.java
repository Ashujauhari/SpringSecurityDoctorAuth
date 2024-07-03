package com.example.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.payload.LoginDto;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@FeignClient(name = "auth-service", url = "${AUTH_SERVICE_URL:http://localhost:9192}")
public interface AuthFeignClient {

    @PostMapping("/doctorapi/auth/signin")
    ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto);
}