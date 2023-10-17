package Africa.semicolon.bvasbeta.dto.request;

import Africa.semicolon.bvasbeta.models.UserInformation;
import lombok.Data;

@Data
public class PartyRegistrationRequest {
    private UserInformation userInformation;
    private String id;
    private String name;
}
