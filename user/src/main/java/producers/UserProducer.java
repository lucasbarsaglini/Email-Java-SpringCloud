package producers;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import dtos.EmailDto;
import models.UserModel;

@Component
public class UserProducer {

    private final RabbitTemplate rabbitTemplate;

    @Value(value = "${broker.queue.email.name:default_routing_key}")
    private String routingKey;

    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishMessageEmail(UserModel userModel) {
        if (userModel == null) {
            throw new IllegalArgumentException("O usuário não pode ser null");
        }

        if (userModel.getUserId() == null || userModel.getEmail() == null || userModel.getName() == null) {
            throw new IllegalArgumentException("O usuário deve conter id, email e name");
        }

        var emailDto = new EmailDto();
        emailDto.setUserId(userModel.getUserId());
        emailDto.setSubject("Cadastro realizado com sucesso!");
        emailDto.setText(userModel.getName() + ", seja bem vindo()!");

        try {
            rabbitTemplate.convertAndSend("", routingKey, emailDto);
        } catch (AmqpException ex) {
			System.err.println(ex);
		}
    }
}
