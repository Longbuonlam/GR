package GR.gacnghi.service;

import GR.gacnghi.repository.UserRepository;
import GR.gacnghi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository theUserRepository) {
        userRepository = theUserRepository;
    }
    public void save(User theUser) {
        userRepository.save(theUser);
    }
    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    public User getUserById(int id) {
        return userRepository.findById(id).get();
    }
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    public User login(String name, String password){
        User userlogin = userRepository.findByNameAndPassword(name, password);
        return userlogin;
    }

}
