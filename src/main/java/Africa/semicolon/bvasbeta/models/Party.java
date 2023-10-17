package Africa.semicolon.bvasbeta.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Party {
    private UserInformation userInformation;
    private String id;
    private String name;
    private String partyRegistrationNumber;

}
