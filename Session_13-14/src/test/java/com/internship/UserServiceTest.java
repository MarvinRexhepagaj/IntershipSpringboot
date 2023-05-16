package com.internship;

import com.internship.model.dto.UserDTO;
import com.internship.model.entity.User;
import com.internship.repository.BookingRepository;
import com.internship.repository.UserRepository;
import com.internship.service.UserService;
import com.internship.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
public class UserServiceTest {

    private UserService userService;

    @Mock
    private UserRepository userRepository;
    @Mock
    private BookingRepository bookingRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        userService = new UserServiceImpl(userRepository,bookingRepository);
    }

    @Test
    public void loadByIdTest() throws ChangeSetPersister.NotFoundException {

        Long id = 1L;
        User user = new User();
        user.setId(id);

        Optional<User> optionalUser = Optional.of(user);

        when(userRepository.findById(id)).thenReturn(optionalUser);
        UserDTO userDTO = userService.loadById(id);


        assertEquals(userDTO.getId(), user.getId());
    }
    @Test
    public void loadAllTest() {

        User user1 = new User();
        user1.setId(1L);
        user1.setUsername("user1");

        User user2 = new User();
        user2.setId(2L);
        user2.setUsername("user2");

        List<User> userList = Arrays.asList(user1, user2);


        when(userRepository.findAll()).thenReturn(userList);
        List<UserDTO> userDTOList = userService.loadAll();


        assertEquals(userDTOList.size(), userList.size());

        for (int i = 0; i < userList.size(); i++) {
            UserDTO userDTO = userDTOList.get(i);
            User user = userList.get(i);

            assertEquals(userDTO.getId(), user.getId());
            assertEquals(userDTO.getUsername(), user.getUsername());
        }
    }
}
