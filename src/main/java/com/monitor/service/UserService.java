package com.monitor.service;

import com.monitor.model.User;
import com.monitor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User getUserById(Integer userId){
    return userRepository.findOne(userId);
  }

  public void saveUser(User user){
    userRepository.save(user);
  }

  public User getUserByUserName(String userName){
    return userRepository.findByUserName(userName);
  }

}
