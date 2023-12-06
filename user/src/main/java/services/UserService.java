package services;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import models.UserModel;
import producers.UserProducer;
import repositories.UserRepository;

@Service
public class UserService {
	
	final UserRepository userRepository;
	final UserProducer userProducer;
	
	public UserService(UserRepository userRepository, UserProducer userProducer) {
		this.userRepository = userRepository;
		this.userProducer = userProducer;
	}
	
	@Transactional
	public UserModel save(UserModel userModel) {
		userModel = userRepository.save(userModel);
		userProducer.publishMessageEmail(userModel);
		return userModel;
	}
}
