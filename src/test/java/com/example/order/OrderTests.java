package com.example.order;

import com.example.Application;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Application.class)
public class OrderTests {
    @Autowired
    private OrderCreateService orderCreateService;
    @Test
    public void orderCreated() throws InterruptedException {
        orderCreateService.create("order1");

        Thread.sleep(5000L);
    }
}
