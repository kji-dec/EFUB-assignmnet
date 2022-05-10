package kjidec.tddSeminar.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User extends BaseEntity {
    private String name;

    @Enumerated(EnumType.STRING)
    private UserType type;
}
