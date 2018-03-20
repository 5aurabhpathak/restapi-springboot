package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class Controller {

    @RequestMapping("/post")
    @ResponseBody
    public APIpost post(@RequestBody APIpost postobj) {
    	return postobj;
    }
    
    @GetMapping("/{deviceid}")
    @ResponseBody
    public APIget get(@PathVariable("deviceid") int devId) {
    	return new APIget(123, devId);
    }
}