package Africa.semicolon.bvasbeta.models;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Data
public class Election {
    private LocalDate electionDate;
    private List<Party> parties;
    private Category category;
    private String id;


}
