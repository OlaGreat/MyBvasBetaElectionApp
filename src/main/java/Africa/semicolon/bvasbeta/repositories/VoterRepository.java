package Africa.semicolon.bvasbeta.repositories;
import Africa.semicolon.bvasbeta.models.Voter;

import java.util.List;

public interface VoterRepository {
    Voter findById(String id);
    List<Voter> findAll();
    Voter save(Voter voter);

    int numbersOfRegisteredVoters();

    void deleteById(String id);

}
