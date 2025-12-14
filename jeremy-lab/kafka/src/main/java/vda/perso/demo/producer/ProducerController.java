package vda.perso.demo.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public ProducerController(KafkaTemplate<String, OrderEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/send-multiple-messages/{id}")
    public void sendMultipleMessages(@PathVariable int id) {
        OrderEvent orderEvent = new OrderEvent(id);
        kafkaTemplate.send("orders", String.valueOf(orderEvent.id()), orderEvent);
    }
}
