package com.moringaschool.student;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {
    @Test
    public void test_main_method (){
        System.out.println("Main");
        String response = "Main";
        Assertions.assertEquals("Main",response);
    }

    @Test
    public void test_false_method (){
        System.out.println("False");

        boolean response=true;
        Assertions.assertFalse(false, String.valueOf(response));
    }

    @Test
    public void test_true_method (){
        System.out.println("True");
        boolean response=false;
        Assertions.assertTrue(true, String.valueOf(response));
    }
}
