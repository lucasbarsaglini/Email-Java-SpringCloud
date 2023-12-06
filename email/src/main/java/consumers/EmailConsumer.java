package consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import dtos.EmailRecordDto;
import models.EmailModel;

@Component
public class EmailConsumer {
	
	@RabbitListener(queues = "${broker.queue.email.name}")
	public void listenEmailQueue(@Payload EmailRecordDto emailRecordDto) {
		var emailModel= new EmailModel();
		BeanUtils.copyProperties(emailRecordDto, emailModel);
	}
}
