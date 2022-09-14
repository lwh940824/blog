package com.cos.blog.test;

public class People {
    private int hugryState = 50; // 100

    public void eat() {
        hugryState += 10;
    }

    public static void main(String[] args) {
        People p = new People();
//        p.hugryState = 100; // 객체지향 X
        p.eat();
    }
}
