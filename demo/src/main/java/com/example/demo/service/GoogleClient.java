package com.example.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "https://google.com", name = "googleClient")
public interface GoogleClient {

  @GetMapping(path = "/")
  String getMainPage();

}
