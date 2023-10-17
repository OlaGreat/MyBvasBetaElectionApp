package Africa.semicolon.bvasbeta.services;

import Africa.semicolon.bvasbeta.dto.request.PartyRegistrationRequest;
import Africa.semicolon.bvasbeta.dto.response.PartyRegistrationResponse;
import Africa.semicolon.bvasbeta.execptions.PartyRegistrationRequestFailedException;
import Africa.semicolon.bvasbeta.models.Party;
import Africa.semicolon.bvasbeta.models.UserInformation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static Africa.semicolon.bvasbeta.utils.AppUtils.*;
import static org.junit.jupiter.api.Assertions.*;

class BvasBetaPartyServiceTest {
    PartyService partyService = new BvasBetaPartyService();

    PartyRegistrationRequest partyRegistrationRequest;
    PartyRegistrationRequest partyRegistrationRequest1;

    @BeforeEach
    void setUp() {
        partyRegistrationRequest = buildParty();
        partyRegistrationRequest1 = buildAnotherParty();
    }

    @Test
    void registerNewParty() throws PartyRegistrationRequestFailedException {
        PartyRegistrationResponse savedParty = partyService.registerNewParty(partyRegistrationRequest);
        PartyRegistrationResponse anotherSavedParty = partyService.registerNewParty(partyRegistrationRequest);
        assertNotNull(savedParty);
        assertNotNull(anotherSavedParty);
        List<Party> registeredParty = partyService.getAllParty();
        assertEquals(2,registeredParty.size());

    }

    @Test
    void findPartyById() throws PartyRegistrationRequestFailedException {
        PartyRegistrationResponse savedParty = partyService.registerNewParty(partyRegistrationRequest);
        PartyRegistrationResponse anotherSavedParty = partyService.registerNewParty(partyRegistrationRequest);
        assertNotNull(savedParty);
        assertNotNull(anotherSavedParty);
        List<Party> partyList = partyService.getAllParty();
        Party foundParty = partyList.get(partyList.size()-2);
        assertNotNull(foundParty);

    }
    @Test
    void getAllPartyTest() throws PartyRegistrationRequestFailedException {
        PartyRegistrationResponse savedParty = partyService.registerNewParty(partyRegistrationRequest);
        PartyRegistrationResponse anotherSavedParty = partyService.registerNewParty(partyRegistrationRequest);
        assertNotNull(savedParty);
        assertNotNull(anotherSavedParty);
        List<Party> partyList = partyService.getAllParty();
        assertEquals(2, partyList.size());

    }
    @Test
    void deletePartyById() throws PartyRegistrationRequestFailedException {
        PartyRegistrationResponse savedParty = partyService.registerNewParty(partyRegistrationRequest);
        PartyRegistrationResponse anotherSavedParty = partyService.registerNewParty(partyRegistrationRequest);
        assertNotNull(savedParty);
        assertNotNull(anotherSavedParty);
        List<Party> partyList = partyService.getAllParty();
        Party foundParty = partyList.get(partyList.size()-TWO);
        assertNotNull(foundParty);
        partyService.deleteById(foundParty.getId());
        assertNotNull(foundParty);
        assertEquals(1,partyService.getAllParty().size());

    }


    private static PartyRegistrationRequest buildParty() {
        PartyRegistrationRequest partyRegistrationRequest = new PartyRegistrationRequest();
        UserInformation userInformation = new UserInformation();
        userInformation.setPassWord("Labour");
        userInformation.setUserName("UserName");
        partyRegistrationRequest.setName("Lp");
        partyRegistrationRequest.setUserInformation(userInformation);

        return partyRegistrationRequest;
    }
    private static PartyRegistrationRequest buildAnotherParty() {
        PartyRegistrationRequest partyRegistrationRequest1 = new PartyRegistrationRequest();
        UserInformation userInformation = new UserInformation();
        userInformation.setPassWord("Labour");
        userInformation.setUserName("UserName");
        partyRegistrationRequest1.setName("Lp");
        partyRegistrationRequest1.setUserInformation(userInformation);

        return partyRegistrationRequest1;
    }
}