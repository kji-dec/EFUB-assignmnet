package kjidec.tddSeminar.web;

import kjidec.tddSeminar.domain.User;
import kjidec.tddSeminar.domain.UserType;
import kjidec.tddSeminar.service.UserService;
import kjidec.tddSeminar.web.dto.UserResponseDTO;
import kjidec.tddSeminar.web.dto.UserSaveRequestDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
class UserControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private UserService userService;

    @Test
    public void createUser() throws Exception{
        // given - 준비과정
        String testName="test_name";
        given(userService.save(any(UserSaveRequestDTO.class))).willReturn(User.builder().name(testName).type(UserType.NORMAL).build());

        // then - 검증과정
        mvc.perform(MockMvcRequestBuilders.post("/test/"+testName))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value(testName));

    }

    @Test
    public void getUser() throws Exception{
        //given
        User entity=User.builder()
                .name("test_name")
                .type(UserType.NORMAL)
                .build();
        given(userService.findById(anyLong())).willReturn(new UserResponseDTO(entity));

        //fineById가 호출이 되면 UserResponseDTO를 반환
        mvc.perform(MockMvcRequestBuilders.get("/test/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("test_name"));
    }

    @Test
    public void userNotFoundException() throws Exception{
        //given
        given(userService.findById(anyLong())).willThrow(new IllegalArgumentException());

        //then
        mvc.perform(MockMvcRequestBuilders.get("/test/1"))
                .andExpect(status().isNotFound());
    }

}