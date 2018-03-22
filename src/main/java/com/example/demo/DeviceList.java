package com.example.demo;

import java.util.HashMap;

final class DeviceList {
	public static HashMap<Integer, Device> deviceList;
	
	public static void populate() {
		deviceList = new HashMap<>();
		for (int i = 0; i < 10; ++i) deviceList.put(i, new Device(i));
	}
	
	public Integer[] getDevices() {
		return deviceList.keySet().toArray(new Integer[deviceList.size()]);
	}
}