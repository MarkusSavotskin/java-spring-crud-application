package com.example.javaspringcrudapplication;

import com.example.javaspringcrudapplication.user.User;
import com.example.javaspringcrudapplication.user.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {
  @Autowired
  private UserRepository repo;

  @Test
  public void testAddNew() {
    User user = new User();
    user.setEmail("villu@mail.com");
    user.setPassword("12345");
    user.setFirstName("Villu");
    user.setLastName("Vares");

    User savedUser = repo.save(user);

    assertThat(savedUser).isNotNull();
    assertThat(savedUser.getId()).isGreaterThan(0);
  }

  @Test
  public void testListAll() {
    Iterable<User> users = repo.findAll();
    assertThat(users).isNotEmpty();

    for (User user : users) {
      System.out.println(user);
    }
  }

  @Test
  public void testUpdate() {
    Integer userId = 1;
    Optional<User> optionalUser = repo.findById(userId);
    User user = optionalUser.get();
    user.setPassword("4321");
    repo.save(user);

    User updatedUser = repo.findById(userId).get();
    assertThat(updatedUser.getPassword()).isEqualTo("4321");
  }

  @Test
  public void testGet() {
    Integer userId = 2;
    Optional<User> optionalUser = repo.findById(userId);
    assertThat(optionalUser).isPresent();
    System.out.println(optionalUser.get());
  }

  @Test
  public void testDelete() {
    Integer userId = 2;
    repo.deleteById(userId);

    Optional<User> optionalUser = repo.findById(userId);
    assertThat(optionalUser).isNotPresent();
  }
}
