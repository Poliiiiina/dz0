package com.company;

public class NumberThread extends PrintThread {
    public NumberThread(int divider, int max, String message) {
        super(divider, max, message);
    }
    public void print() {
        System.out.println(current);
    }
}



