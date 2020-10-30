package com.egorbarinov.springleveltwo.shop.dao;

import com.egorbarinov.springleveltwo.shop.domain.Role;
import com.egorbarinov.springleveltwo.shop.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@SqlGroup({@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:/initUsers.sql")})
class UserRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    void checkFindByName() {
        //have
        User user = new User();
        user.setName("TestUser");
        user.setPassword("password");
        user.setEmail("test-email@mail.ru");

        entityManager.persist(user);

        //execute
        User actualUser = userRepository.findByName("TestUser");

        //check
        Assertions.assertNotNull(actualUser);
        Assertions.assertEquals(user.getName(), actualUser.getName());
        Assertions.assertEquals(user.getPassword(), actualUser.getPassword());
        Assertions.assertEquals(user.getEmail(), actualUser.getEmail());

    }

    @Test
    void checkFindByNameAfterSql() {
        //execute
        User actualUser = userRepository.findFirstByName("petr");

        //check
        Assertions.assertNotNull(actualUser);
        Assertions.assertEquals(1, actualUser.getId());
        Assertions.assertEquals("petr", actualUser.getName());
        Assertions.assertEquals("pass", actualUser.getPassword());
        Assertions.assertEquals("petr@mail.ru", actualUser.getEmail());
        Assertions.assertEquals(Role.CLIENT, actualUser.getRole());

    }
}