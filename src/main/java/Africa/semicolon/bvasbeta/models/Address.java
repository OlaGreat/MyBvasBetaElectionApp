package Africa.semicolon.bvasbeta.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {
    private String  houseNumber;
    private String street;
    private String lga;
    private String state;
}
