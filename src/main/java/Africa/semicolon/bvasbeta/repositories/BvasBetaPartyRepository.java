package Africa.semicolon.bvasbeta.repositories;

import Africa.semicolon.bvasbeta.models.Party;
import Africa.semicolon.bvasbeta.models.UserInformation;
import Africa.semicolon.bvasbeta.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;

public class BvasBetaPartyRepository implements PartyRepository{
   ArrayList<Party> parties = new ArrayList<>();
   UserInformationRepository userInformationRepository = new BvasBetaUserInformationRepository();

    @Override
    public Party save(Party party) {
        boolean isPartyWithUserInfo = party.getUserInformation()!=null;
        if(isPartyWithUserInfo){saveUserInformation(party);}
        saveParty(party);
//        boolean IsSaved = party.getId() != null;
//        if (IsSaved){
//            updateParty(party);
//        }
//        else
//            saveParty(party);

        return party;
    }

    private void saveUserInformation(Party party) {
        UserInformation savedUserInformation = userInformationRepository.save(party.getUserInformation());
        String partyId = party.getId();
        String savedUserInformationId = savedUserInformation.getId();
        AppUtils.linkUserToUseInformation(partyId,savedUserInformationId);
    }


    private void saveParty(Party party) {
        party.setId(generatePartyId());
        parties.add(party);
    }

    private String generatePartyId() {
        return AppUtils.generatedId();
    }
    private void updateParty(Party party) {
        Party savedParty = findById(party.getId());
        parties.remove(savedParty);
        parties.add(party);
    }

    @Override
    public Party findById(String id) {
        Party foundParty = null;
        for(Party savedParty : parties){
            if (savedParty.getId().equals(id))foundParty = savedParty;}
        if(foundParty != null){
            String userInformationid = AppUtils.getUserInformationId(foundParty.getId());
            UserInformation userInformation = userInformationRepository.findById((userInformationid));
            foundParty.setUserInformation(userInformation);
        }
        return foundParty;
    }

    @Override
    public List<Party> findAll() {
        List<Party> politicalParty = new ArrayList<>();
        for (Party party : parties){
           String userInformationId = AppUtils.getUserInformationId(party.getId());
           UserInformation userInformation = userInformationRepository.findById(userInformationId);
           party.setUserInformation(userInformation);
            politicalParty.add(party);
        }
        return politicalParty;
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
