package Africa.semicolon.bvasbeta.dto.request;

import Africa.semicolon.bvasbeta.models.Party;
import lombok.Data;

import java.util.List;

@Data
public class CreateElectionRequest {
    private String electionDate;
    private String electionCategory;
    private List<String> state;
    private List<String> localGovernment;
    private List<String> election;
    private List<String>  party;
}
