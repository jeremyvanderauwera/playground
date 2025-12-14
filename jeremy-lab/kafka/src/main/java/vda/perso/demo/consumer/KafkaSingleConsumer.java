package vda.perso.demo.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import vda.perso.demo.producer.OrderEvent;

@Service
public class KafkaSingleConsumer {

    @KafkaListener(topics = "orders", groupId = "orders-consumers")
    public void onMessage(OrderEvent e) {
        if (e.id() % 2 == 0) {
            throw new RuntimeException();
        }
        System.out.println(e);
    }

}
