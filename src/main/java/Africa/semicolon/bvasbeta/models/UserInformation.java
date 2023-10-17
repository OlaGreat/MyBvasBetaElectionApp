package Africa.semicolon.bvasbeta.models;

import Africa.semicolon.bvasbeta.repositories.AddressRepository;
import Africa.semicolon.bvasbeta.repositories.BvasBetaAddressRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInformation {
    private String userName;
    private String id;
    private String passWord;
}
