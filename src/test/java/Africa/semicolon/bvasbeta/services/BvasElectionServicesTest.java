package Africa.semicolon.bvasbeta.services;

import Africa.semicolon.bvasbeta.dto.request.CreateElectionRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BvasElectionServicesTest {
    ElectionService electionService = new BvasElectionServices();

    @BeforeEach
    void setUp() {
    }

    @Test
    void createElection() {
        CreateElectionRequest createElectionRequest = new CreateElectionRequest();
        createElectionRequest.setElectionCategory("GUBERNATORIAL");
        createElectionRequest.setElectionDate("2023-05-11");
        List<String> parties = getParties();
        createElectionRequest.setParty(parties);
        List<String> states = getState();
        createElectionRequest.setElection(states);
        electionService.createElection(createElectionRequest);

    }

    private static List<String> getParties() {
        List<String> parties = new ArrayList<>();
        parties.add("LP");
        parties.add("APC");
        parties.add("PDP");
        return parties;
    }

    private static List<String> getState() {
        List<String> states = new ArrayList<>();
        states.add("Lagos");
        states.add("Lagos");
        states.add("Lagos");
        return states;
    }
}