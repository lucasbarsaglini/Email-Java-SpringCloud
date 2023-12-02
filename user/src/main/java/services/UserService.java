package services;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import models.UserModel;
import repositories.UserRepository;

@Service
public class UserService {
	
	final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Transactional
	public UserModel save(UserModel userModel) {
		return userRepository.save(userModel);
	}
}
