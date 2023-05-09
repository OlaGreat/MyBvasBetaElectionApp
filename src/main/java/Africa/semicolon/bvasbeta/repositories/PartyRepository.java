package Africa.semicolon.bvasbeta.repositories;
import Africa.semicolon.bvasbeta.models.Party;

import java.util.List;

public interface PartyRepository {
    Party findById(String id);
    List<Party> findAll();
    Party save(Party party);
    void deleteById(String id);
    int getNumberOfRegisteredParty();

}
