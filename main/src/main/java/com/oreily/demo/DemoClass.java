package com.oreily.demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class DemoClass {
    public static void main(String[] args) {
        CompletableFuture<String> completableFuture =
                CompletableFuture.supplyAsync(()->{
                    return "test";
                });

        String result = "";

        try {
            result = completableFuture.get(1000, TimeUnit.MILLISECONDS);
        }catch (Exception ex){
            System.out.println("test");
        }


        System.out.println(result);

    }
}
