package com.example.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderPaidService {
    @Autowired
    private ApplicationEventPublisher publisher;

    @Transactional
    public void pay(String id) {
        publisher.publishEvent(new OrderPaid(id));
    }
}
