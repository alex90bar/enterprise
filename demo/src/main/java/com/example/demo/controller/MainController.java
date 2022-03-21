package com.example.demo.controller;

import com.example.demo.service.GoogleClient;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MainController {

  private GoogleClient client;

  @GetMapping(path = "/")
  private String getMainPage(){
    return client.getMainPage();
  }

}
