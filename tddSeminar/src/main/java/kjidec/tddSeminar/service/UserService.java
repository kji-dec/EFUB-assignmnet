package kjidec.tddSeminar.service;

import kjidec.tddSeminar.domain.User;
import kjidec.tddSeminar.domain.UserRepository;
import kjidec.tddSeminar.web.dto.UserResponseDTO;
import kjidec.tddSeminar.web.dto.UserSaveRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserResponseDTO findById(Long id){
        //User entity = userRepository.findById(id).orElseThrow(() -> new
        //        IllegalArgumentException("해당 사용자가 없습니다. id = "+id));
        User entity = userRepository.getById(id);
        return new UserResponseDTO(entity);
    }

    public User save(UserSaveRequestDTO requestDTO){
        return userRepository.save(requestDTO.toEntity());
    }
}
