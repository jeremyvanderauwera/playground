package vda.perso.demo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.retrytopic.RetryTopicConfiguration;
import org.springframework.kafka.retrytopic.RetryTopicConfigurationBuilder;
import vda.perso.demo.producer.OrderEvent;

import java.time.Duration;

@Configuration
public class KafkaConfig {
    @Bean
    RetryTopicConfiguration retryConfig(KafkaTemplate<String, OrderEvent> template) {
        return RetryTopicConfigurationBuilder
                .newInstance()
                .includeTopic("orders")
                .exponentialBackoff(Duration.ofSeconds(5).toMillis(), 2.0, Duration.ofMinutes(1).toMillis())
                .maxAttempts(5)
                .dltSuffix(".dlt")
                .create(template);
    }

    @Bean
    public NewTopic ordersTopic() {
        String sevenDays = "604800000";
        return TopicBuilder.name("orders")
                .partitions(3)
                .replicas(1)
                .config("cleanup.policy", "delete")
                .config("retention.ms", sevenDays) // 7 jours
                .build();
    }

    @Bean
    public NewTopic ordersDltTopic() {
        String fourthienDays = "1209600000";
        return TopicBuilder.name("orders.dlt")
                .partitions(6)
                .replicas(3)
                .config("retention.ms", fourthienDays) // 14 jours
                .build();
    }

}
