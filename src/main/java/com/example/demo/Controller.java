package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class Controller {
	
	private APIpost p;

    @PostMapping("/post")
    public void post(@RequestBody APIpost postobj) {
    	p = postobj;
    	System.out.println("Register:" + p.register);
    	System.out.println("Value:" + p.value);
    }
    
    @PatchMapping("/post")
    @ResponseBody
    public ResponseEntity patch(@RequestBody APIpost patchobj) {
    	try {
	    	p.register = (patchobj.register != p.register && patchobj.register != 0) ? patchobj.register : p.register;
	    	p.value = (patchobj.value != p.value && patchobj.value != 0) ? patchobj.value : p.value;
	    	System.out.println("Register:" + p.register);
	    	System.out.println("Value:" + p.value);
	    	return new ResponseEntity<APIpost>(p, HttpStatus.OK);
    	}
    	catch (NullPointerException e) {
    		return new ResponseEntity<Status>(new Status("Error: Nothing to Patch!"), HttpStatus.NOT_FOUND);
    	}
    }
    
    @GetMapping("/{deviceid}")
    @ResponseBody
    public APIget get(@PathVariable("deviceid") int devId) {
    	return new APIget(123, devId);
    }
}

class Status {
	private String msg;
	
	Status(String msg) {
		this.msg = msg;
	}
	
	public String getStatus( ) {
		return msg;
	}
}