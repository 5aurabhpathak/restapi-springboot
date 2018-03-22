package com.example.demo;

import java.util.Random;
import java.util.HashMap;

public class Device {
	private int id;
	private HashMap<Integer, Integer> registers; //registerid, registervalue
	
	public Device() {}
	
	public Device(int id) {
		this.id = id;
		MyRandom rnd = new MyRandom();
		registers = new HashMap<>();
		for (int i = 0; i < 5; ++i) registers.put(rnd.nextNonNegative(), rnd.nextNonNegative());
	}

	public int getId() {
		return id;
	}

	public API[] getRegisters() {
		API[] regs = new API[registers.size()];
		int i = 0;
		for(Integer id : registers.keySet()) regs[i++] = new API(id, registers.get(id));
		return regs;
	}
	
	public void setRegisters(API[] registers) {
		this.registers = new HashMap<>();
		for (int i = 0; i < registers.length; ++i)
			this.registers.put(registers[i].getRegisterId(), registers[i].getValue());
	}
	
	public HashMap<Integer, Integer> Registers() {
		return registers;
	}
}

@SuppressWarnings("serial")
class MyRandom extends Random {

    public int nextNonNegative() {
        return next(Integer.SIZE - 1);
    }
}