package Africa.semicolon.bvasbeta.dto.request;

import Africa.semicolon.bvasbeta.models.UserInformation;
import lombok.Data;
@Data

public class AdminRegistrationRequest {
    private UserInformation userInformation;
    private String id;


}
