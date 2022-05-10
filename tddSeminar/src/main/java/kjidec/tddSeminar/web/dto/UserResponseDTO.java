package kjidec.tddSeminar.web.dto;

import kjidec.tddSeminar.domain.User;
import kjidec.tddSeminar.domain.UserType;
import lombok.Getter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
public class UserResponseDTO {
    private String name;

    @Enumerated(EnumType.STRING)
    private UserType type;

    public UserResponseDTO(User entity){
        this.name = entity.getName();
        this.type = entity.getType();
    }
}