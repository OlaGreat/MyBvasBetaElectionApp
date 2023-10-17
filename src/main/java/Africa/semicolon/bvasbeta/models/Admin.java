package Africa.semicolon.bvasbeta.models;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    private UserInformation userInformation;
    private String id;
}
