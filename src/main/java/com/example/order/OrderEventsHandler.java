package com.example.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.modulith.ApplicationModuleListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
public class OrderEventsHandler {

    @Autowired
    private OrderPaidService orderPaidService;


    @Transactional
    @TransactionalEventListener
    public void onOrderCreated(OrderCreated event) {
        log.info("order created {}", event.getId());
        orderPaidService.pay(event.getId());
    }


    @ApplicationModuleListener
    public void onOrderPaid(OrderPaid event) {
        log.info("order paid {}", event.getId());
    }
}
