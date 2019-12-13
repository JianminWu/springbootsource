package com.cdt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UsingTestAnnotation {
    @BeforeAll
    static void initAll() {
        System.out.println("---Inside initAll---");
    }
    @Test
    @DisplayName("Multiplication Test")
    void multiplyTest() {
    	System.out.println("---Inside multiplyTest---");
    }
    @AfterAll
    static void tearDownAll() {
    	System.out.println("---Inside tearDownAll---");
    }
} 