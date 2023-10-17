package Africa.semicolon.bvasbeta.repositories;

import Africa.semicolon.bvasbeta.models.Party;
import Africa.semicolon.bvasbeta.models.UserInformation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BvasBetaPartyRepositoryTest {
    PartyRepository partyRepository;
    Party party;


    @BeforeEach
    void setUp() {
        partyRepository = new BvasBetaPartyRepository();
        party = new Party();}

    @Test
    void findById() {
        UserInformation userInformation = new UserInformation("Labour Party","1","Lp");
        party.setUserInformation(userInformation);
        partyRepository.save(party);


        Party partyLp = new Party();
        UserInformation userInformation2 = new UserInformation("Lp","3","Lp");
        partyLp.setUserInformation(userInformation2);
        partyRepository.save(partyLp);

        assertEquals(partyLp,partyRepository.findById("2"));
    }

    @Test
    void findAll() {
    }

    @Test
    void save() {
        UserInformation userInformation = new UserInformation("Labour Party","1","Lp");
        party.setUserInformation(userInformation);
        partyRepository.save(party);


         Party partyLp = new Party();
        UserInformation userInformation2 = new UserInformation("Lp","3","Lp");
        partyLp.setUserInformation(userInformation2);
        partyRepository.save(partyLp);

         assertEquals(2,partyRepository.getNumberOfRegisteredParty());

    }

    @Test
    void deleteById() {
        UserInformation userInformation = new UserInformation("Labour Party","1","Lp");
        party.setUserInformation(userInformation);
        partyRepository.save(party);

        Party partyLp = new Party();
        UserInformation userInformation2 = new UserInformation("Lp","3","Lp");
        partyLp.setUserInformation(userInformation2);
        partyRepository.save(partyLp);
        assertEquals(2,partyRepository.getNumberOfRegisteredParty());

        partyRepository.deleteById(party.getId());
        assertEquals(1,partyRepository.getNumberOfRegisteredParty());
    }

}