package com.example.demo;

import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class Controller {
	
	@PatchMapping("/devices/{deviceid}")
    @ResponseBody
    public ResponseEntity<?> patch(@PathVariable("deviceid") int devId, @Valid @RequestBody API patchobj) {
    	try {
	    	Device device = DeviceList.deviceList.get(devId);
	    	int regId = patchobj.getRegisterId();
	    	HashMap<Integer, Integer> registers = device.Registers();
        	if (registers.containsKey(regId)) registers.put(regId, patchobj.getValue());
        	else throw new NullPointerException();
	    	return new ResponseEntity<Device>(device, HttpStatus.OK);
	    }
    	catch (NullPointerException e) {
    		return new ResponseEntity<Status>(new Status("Failed"), HttpStatus.NOT_FOUND);
    	}
    }
    
    @PostMapping("/devices/{deviceid}/{register}")
    @ResponseBody
    public ResponseEntity<Status> post(@PathVariable("deviceid") int devId, @PathVariable("register") int regId, @Valid @RequestBody API postobj) {
    	try {
    		Device device = DeviceList.deviceList.get(devId);
    		HashMap<Integer, Integer> registers = device.Registers();
        	if (registers.containsKey(regId)) registers.put(regId, postobj.getValue());
        	else throw new NullPointerException();
        	return new ResponseEntity<Status>(new Status("Success"), HttpStatus.OK); 
    	}
    	catch (NullPointerException e) {
    		return new ResponseEntity<Status>(new Status("Failed"), HttpStatus.NOT_FOUND);
    	}
    }
    
    @GetMapping("/devices/{deviceid}")
    @ResponseBody
    public ResponseEntity<?> get(@PathVariable("deviceid") int devId) {
    	try {
    		if (!DeviceList.deviceList.containsKey(devId)) throw new NullPointerException();
    		return new ResponseEntity<Device>(DeviceList.deviceList.get(devId), HttpStatus.OK);
    	}
    	catch (NullPointerException e) {
    		return new ResponseEntity<Status>(new Status("Device not found"), HttpStatus.NOT_FOUND);
    	}
    }
    
    @DeleteMapping("/devices/{deviceid}")
    @ResponseBody
    public ResponseEntity<Status> del(@PathVariable("deviceid") int devId) {
    	try {
			DeviceList.deviceList.remove(devId);
        	return new ResponseEntity<Status>(new Status("Success"), HttpStatus.OK);
    	}
    	catch (NullPointerException e) {
    		return new ResponseEntity<Status>(new Status("Failed: Device already not present"), HttpStatus.NOT_FOUND);
    	}
    }
    
    @GetMapping("/devices")
    @ResponseBody
    public ResponseEntity<DeviceList> get() {
    	return new ResponseEntity<DeviceList>(new DeviceList(), HttpStatus.OK);
    }
    
    @PutMapping("/devices")
    @ResponseBody
    public ResponseEntity<Status> put(@Valid @RequestBody Device deviceobj) {
		DeviceList.deviceList.put(deviceobj.getId(), deviceobj);
        return new ResponseEntity<Status>(new Status("Success"), HttpStatus.OK);
    }
}