package Africa.semicolon.bvasbeta.dto.request;

import Africa.semicolon.bvasbeta.models.Address;
import Africa.semicolon.bvasbeta.models.Gender.Gender;
import Africa.semicolon.bvasbeta.models.UserInformation;
import lombok.Data;

@Data
public class VoterRegistrationRequest {
    private Integer age;
    private String name;
    private String id;
    private String gender;
    private String userName;
    private String passWord;
    private String  houseNumber;
    private String street;
    private String lga;
    private String state;
}
