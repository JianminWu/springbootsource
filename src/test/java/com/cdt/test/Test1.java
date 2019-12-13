package com.cdt.test;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

/**
 * @Author: wujianmin
 * @Date: 2019/11/13 17:17
 * @Function:
 * @Version 1.0
 */

public class Test1 {


    public void setUp(){
        System.out.println("setup");
    }


    @Test
    public void test1(){
        System.out.println(1);
    }

    @Test
    public void test2(){

        System.out.println(2);
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("---Inside tearDownAll---");
    }
}
