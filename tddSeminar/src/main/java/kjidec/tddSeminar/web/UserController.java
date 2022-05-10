package kjidec.tddSeminar.web;

import kjidec.tddSeminar.domain.User;
import kjidec.tddSeminar.domain.UserType;
import kjidec.tddSeminar.service.UserService;
import kjidec.tddSeminar.web.dto.UserResponseDTO;
import kjidec.tddSeminar.web.dto.UserSaveRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/test/{name}")
    private User save(@PathVariable String name){
        UserSaveRequestDTO requestDTO = UserSaveRequestDTO.builder()
                .name(name)
                .type(UserType.NORMAL)
                .build();
        return userService.save(requestDTO);
    }

    @GetMapping("/test/{id}")
    private UserResponseDTO findById(@PathVariable Long id){
        return userService.findById(id);
    }
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void userNotFoundHandler(IllegalArgumentException e){}
}

