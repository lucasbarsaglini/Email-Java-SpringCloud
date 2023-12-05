package configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabbitmq.client.AMQP.Queue;

@Configuration
public class RabbitMQConfig {
	
	@Value("${broker, queue.email.name}")
	private String queue;

    @Bean
    Queue queue() {
        return new Queue();
    }

}
