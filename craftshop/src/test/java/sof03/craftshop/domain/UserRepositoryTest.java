package sof03.craftshop.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserRepositoryTest {

	@Autowired
	UserRepository userRepository;

	// Testataan uuden käyttäjän (user) luomista
	@Test
	public void createUser() {
		User user = new User("admin", "$2a$10$.XRNY3TCuGMcNxxo9Htz9OkIzvKSGm.9uhS5SzAAhhsilWlaMZZBq", "ADMIN");
		userRepository.save(user);
		assertThat(user.getUserId()).isNotNull();
	}

	// Testataan käyttäjien etsimistä
	@Test
	public void searchForUser() {
		List<User> users = new ArrayList<>();
		User user1 = userRepository.findById(1L).get();
		User user2 = userRepository.findById(2L).get();
		if (user1 != null && user2 != null) {
			users.add(user1);
			users.add(user2);
		}
		assertThat(users).contains(user1, user2);
	}
	
	// Testataan uuden käyttäjän poistoa
	@Test
	public void deleteUser() {
		User user = new User("kayttaja", "$2a$10$N2AdhW8Aty1wBvg8C6romeCUbXPyXT..QqrmsTgLWbV2vNdmgu.1W", "KAYTTAJA");
		userRepository.save(user);
		userRepository.deleteById(user.getUserId());
		assertThat(userRepository.findById(user.getUserId())).isEmpty();
	}
}
