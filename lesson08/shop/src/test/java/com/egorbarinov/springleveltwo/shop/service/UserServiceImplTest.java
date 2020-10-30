package com.egorbarinov.springleveltwo.shop.service;

import com.egorbarinov.springleveltwo.shop.dao.UserRepository;
import com.egorbarinov.springleveltwo.shop.domain.User;
import com.egorbarinov.springleveltwo.shop.dto.UserDto;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
@Disabled
class UserServiceImplTest {
    private UserServiceImpl userService;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before All tests");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Before each test");
        userRepository = Mockito.mock(UserRepository.class);
        passwordEncoder = Mockito.mock(PasswordEncoder.class);

        userService = new UserServiceImpl(userRepository, passwordEncoder);

    }

    @Test
    void checkSave() {
        // have
        UserDto userDto = UserDto.builder()
                .username("Egor")
                .email("egorb@mail.ru")
                .password("password")
                .matchingPassword("password")
                .build();

        Mockito.when(passwordEncoder.encode(Mockito.anyString())).thenReturn("password");

        //execute
        boolean result = userService.save(userDto);

        //check
        Assertions.assertTrue(result);
        Mockito.verify(passwordEncoder).encode(Mockito.anyString());
        Mockito.verify(userRepository).save(Mockito.any());
    }

    @Test
    @Disabled
    void checkFindByName() {

        //have
        String name = "admin";
        User expectedUser = User.builder().id(1L).name(name).build();
        Mockito.when(userRepository.findByName(Mockito.eq(name))).thenReturn(expectedUser);
        //execute
        User actualUser = userService.findByName(name);

        //check
        Assertions.assertNotNull(actualUser);
        Assertions.assertEquals(expectedUser, actualUser);

    }

    @Test
    void checkSaveIncorrectPassword(){
        //have
        UserDto userDto =UserDto.builder()
                .password("password")
                .matchingPassword("another")
                .build();
        //execute
        Assertions.assertThrows(RuntimeException.class, new Executable() {

            @Override
            public void execute() throws Throwable {
                userService.save(userDto);
            }
        });

    }
}