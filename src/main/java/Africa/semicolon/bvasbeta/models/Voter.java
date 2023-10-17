package Africa.semicolon.bvasbeta.models;

import Africa.semicolon.bvasbeta.models.Gender.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Voter {
    private UserInformation userInformation;
    private String voterIdentificationNumber;
    private Integer age;
    private Address address;
    private String name;
    private String id;
    private Gender gender;

}
