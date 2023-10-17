package Africa.semicolon.bvasbeta.services;

import Africa.semicolon.bvasbeta.dto.request.VoterRegistrationRequest;
import Africa.semicolon.bvasbeta.dto.response.VoterRegistrationResponse;
import Africa.semicolon.bvasbeta.execptions.VoterRegistrationProccesFailedException;
import Africa.semicolon.bvasbeta.models.Voter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static Africa.semicolon.bvasbeta.utils.AppUtils.ONE;
import static Africa.semicolon.bvasbeta.utils.AppUtils.ZERO;
import static org.junit.jupiter.api.Assertions.*;

class BvasBetaVoterServicesTest {
    VoterService voterService = new BvasBetaVoterServices();
    VoterRegistrationRequest registrationRequest;

    @BeforeEach
    void setUp() {
        registrationRequest = buildsVoter();
    }

    @Test
    void registerTest() {
        try{
            VoterRegistrationResponse registrationResponse = voterService.register(registrationRequest);
            assertNotNull(registrationResponse);
            assertNotNull(registrationResponse.getVoterRegistrationNumber());
        }catch (VoterRegistrationProccesFailedException exception){
            System.out.println(exception);
        }
    }

    @Test
    void getVoterById() throws VoterRegistrationProccesFailedException {
        var registrationResponses = voterService.register((registrationRequest));
        List<Voter> voters = voterService.votersList();
        Voter savedVoters = voters.get(voters.size()-1);
        Voter foundVoter = voterService.getVoterById(savedVoters.getId());
        assertNotNull(foundVoter);
       assertNotNull(registrationResponses);
       
    }

    @Test
    void getAllVoterTest() throws VoterRegistrationProccesFailedException {
        var response = voterService.register(registrationRequest);
        assertNotNull(response);
        List<Voter> voters = voterService.votersList();
        assertEquals(1,voters.size());

    }
    @Test
    void deleteById() throws VoterRegistrationProccesFailedException {
        voterService.register(registrationRequest);
        List<Voter> voters = voterService.votersList();
        Voter savedVoter = voters.get(voters.size()-ONE);
        Voter foundVoters = voterService.getVoterById(savedVoter.getId());
        voterService.deleteById(foundVoters.getId());
        voters = voterService.votersList();
        assertEquals(ZERO,voters.size());

    }

    private static VoterRegistrationRequest buildsVoter() {
        VoterRegistrationRequest registrationRequest = new VoterRegistrationRequest();
        registrationRequest.setAge(10000);
        registrationRequest.setName("Zevas");
        registrationRequest.setLga("TownHall");
        registrationRequest.setUserName("IdanLation@gmail.com");
        registrationRequest.setGender("MALE");
        registrationRequest.setState("Idan Nation");
        registrationRequest.setStreet("Iyana idan");
        registrationRequest.setPassWord("Idangangan");
        registrationRequest.setHouseNumber("333");
        return registrationRequest;
    }
}