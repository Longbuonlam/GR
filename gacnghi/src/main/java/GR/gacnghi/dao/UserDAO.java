package GR.gacnghi.dao;

import GR.gacnghi.entity.User;
import java.util.List;

public interface UserDAO {

    //Saving a java object with JPA
    void save(User user);

    //Reading object with JPA
    User findById(Integer id);

    //Querying object with JPA
    List<User> findAll();

    //Updating object with JPA
    void update(User user);

    //Deleting object with JPA
    void delete(Integer id);
}
