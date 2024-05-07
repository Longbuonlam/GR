package GR.gacnghi;

import GR.gacnghi.dao.UserDAO;
import GR.gacnghi.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class GacnghiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GacnghiApplication.class, args);
	}

}
	/*
	@Bean
	public CommandLineRunner commandLineRunner(UserDAO userDAO) {

		return runner -> {
			creatUser(userDAO);
		};
	}
	private void creatUser(UserDAO userDAO) {

		//create the user object
		System.out.println("Create new user object");
		User tempUser = new User("User1","example1@gmail.com","example1");

		//save the user object
		userDAO.save(tempUser);

		//retrieve user based on the id and display the saved user
		User myUser = userDAO.findById(tempUser.getId());
		System.out.println("Save user to database : " + myUser);

		//get a list of user
		List<User> userList = userDAO.findAll();

		//display list of users
		for(User user : userList){
			System.out.println(user);
		}

		//update the user object
		tempUser.setName("User2");
		userDAO.update(tempUser);

		//delete the user object
		int Id = 1;
		userDAO.delete(1);
	}

} */