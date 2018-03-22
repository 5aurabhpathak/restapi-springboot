package com.example.demo;

class API {

    private int registerId, value;
    
    public API() {}
    
    public API(int register, int value) {
    	this.setRegisterId(register);
    	this.setValue(value);
    }
    
    public int getRegisterId() {
    	return registerId;
    }
    
    public int getValue() {
    	return value;
    }

	public void setRegisterId(int registerId) {
		this.registerId = registerId;
	}

	public void setValue(int value) {
		this.value = value;
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