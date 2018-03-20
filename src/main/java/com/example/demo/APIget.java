package com.example.demo;

public class APIget {

    private final int register;
    private final int id;
    
    public APIget(int register, int id) {
        this.register = register;
        this.id = id;
    }

    public int getRegister() {
        return register;
    }
}