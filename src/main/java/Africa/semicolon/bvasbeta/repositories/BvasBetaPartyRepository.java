package Africa.semicolon.bvasbeta.repositories;

import Africa.semicolon.bvasbeta.models.Party;

import java.util.ArrayList;
import java.util.List;

public class BvasBetaPartyRepository implements PartyRepository{
   ArrayList<Party> parties = new ArrayList<>();

    @Override
    public Party save(Party party) {
        boolean IsSaved = party.getId() != null;
        if (IsSaved){
            updateParty(party);
        }
        else
            saveParty(party);

        return party;
    }

    private void saveParty(Party party) {
        party.setId(generatePartyId());
        parties.add(party);
    }

    private String generatePartyId() {
        return Integer.toString(parties.size()+1);
    }
    private void updateParty(Party party) {
        Party savedParty = findById(party.getId());
        parties.remove(savedParty);
        parties.add(party);
    }

    @Override
    public Party findById(String id) {
        for(Party savedParty : parties){if (savedParty.getId().equals(id))return savedParty;}
        return null;
    }

    @Override
    public List<Party> findAll() {
        return null;
    }

    @Override
    public void deleteById(String id) {
        Party foundParty = null;
        for(Party savedParty : parties){if (savedParty.getId().equals(id))foundParty = savedParty;}
        parties.remove(foundParty);

    }

    @Override
    public int getNumberOfRegisteredParty() {
        return parties.size();
    }
}
