package kjidec.tddSeminar.web.dto;

import kjidec.tddSeminar.domain.User;
import kjidec.tddSeminar.domain.UserType;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@NoArgsConstructor
public class UserSaveRequestDTO {
    private String name;

    @Enumerated(EnumType.STRING)
    private UserType type;

    @Builder
    public UserSaveRequestDTO(String name, UserType type){
        this.name = name;
        this.type = type;
    }

    public User toEntity(){
        return User.builder()
                .name(name)
                .type(type)
                .build();
    }
}
