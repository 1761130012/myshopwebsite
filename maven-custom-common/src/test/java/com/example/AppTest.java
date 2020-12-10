package com.example;

import org.junit.Test;

import java.io.File;

/**
 * Bounds
 * Unit test for simple App.
 */
public class AppTest {


    // 未柯里化
    static String uncurried(String a, String b) {
        return a + b;
    }

    @Test
    public void test1() {
        /*//柯里化
        Function<String, Function<String, String>> sum = a -> b -> a + b;

        //柯里化
        Function<String, String> hi = sum.apply("hi");
        System.out.println(hi.apply("ho"));

        //未柯里化
        System.out.println(uncurried("hi", "ho"));


        System.out.println(hi.apply("ho"));

        Function<String, String> hup = sum.apply("Hup");
        System.out.println(hup.apply("ho"));
        System.out.println(hup.apply("hey"));*/
    }


    @Test
    public void test2() {
        File file=new File("/C:/Users/LLY/Desktop/%e9%a1%b9%e7%9b%ae/myshopwebsite/maven-custom-common/target/classes/com/example/vo");
        System.out.println(file.listFiles());
    }


}
