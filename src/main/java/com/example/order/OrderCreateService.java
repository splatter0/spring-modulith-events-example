package com.example.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderCreateService {
    @Autowired
    private ApplicationEventPublisher publisher;

    @Transactional
    public void create(String id) {
        publisher.publishEvent(new OrderCreated(id));
    }
}
