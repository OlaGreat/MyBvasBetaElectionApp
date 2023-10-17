package Africa.semicolon.bvasbeta.services;

import Africa.semicolon.bvasbeta.dto.request.CreateElectionRequest;
import Africa.semicolon.bvasbeta.dto.response.CreateElectionResponse;

public interface ElectionService {
    CreateElectionResponse createElection(CreateElectionRequest electionRequest);
}
