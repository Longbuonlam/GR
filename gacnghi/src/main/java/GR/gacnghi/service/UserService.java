package GR.gacnghi.service;

import GR.gacnghi.entity.User;
import org.springframework.stereotype.Service;


@Service
public interface UserService {

    //save user to the database
    void save(User user);

}
