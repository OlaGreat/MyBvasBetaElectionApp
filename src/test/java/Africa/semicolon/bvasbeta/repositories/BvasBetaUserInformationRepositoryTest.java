package Africa.semicolon.bvasbeta.repositories;

import Africa.semicolon.bvasbeta.models.UserInformation;
import Africa.semicolon.bvasbeta.models.Voter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static Africa.semicolon.bvasbeta.models.Gender.Gender.MALE;
import static org.junit.jupiter.api.Assertions.*;

class BvasBetaUserInformationRepositoryTest {
   private final VoterRepository voterRepository = new BvasBetaVoterRepository();
   private final UserInformationRepository userInformationRepository = new BvasBetaUserInformationRepository();
    private Voter savedVoter;
    private UserInformation savedUserInfo;

    @BeforeEach
    void setUp() {
        Voter voter = buildTestVoter();
        savedVoter = voterRepository.save(voter);
        UserInformation userInformation = buildTestUserInfo();
        savedUserInfo = userInformationRepository.save(userInformation);

    }
    private Voter buildTestVoter(){
        Voter voter = new Voter();
        voter.setName("Name");
        voter.setAge(20);
        voter.setGender(MALE);
        return voter;
    }
    private UserInformation buildTestUserInfo(){
        UserInformation userInformation = new UserInformation();
        userInformation.setUserName(savedVoter.getName());
        userInformation.setPassWord("Password");
        userInformation.setId(savedVoter.getId());
        return userInformation;
    }

    @Test
    void findById() {
        assertNotNull(savedVoter.getId());
        assertNotNull(savedUserInfo.getId());

    }

    @Test
    void deleteById() {
        List<UserInformation> userInformations = userInformationRepository.findAll();
        assertEquals(1,userInformations.size());
        userInformationRepository.deleteById(savedVoter.getId());
        userInformations = userInformationRepository.findAll();
        assertEquals(0,userInformations.size());
    }

    @Test
    void findAll() {
       Voter anotherVoter = voterRepository.save(new Voter());
       Voter anotherVoter2 = voterRepository.save(new Voter());
       UserInformation userInformation = new UserInformation();
       UserInformation userInformation1 = new UserInformation();
       userInformation.setId(anotherVoter.getId());
       userInformation1.setId(anotherVoter2.getId());
       userInformationRepository.save(userInformation);
       userInformationRepository.save(userInformation1);

        List<UserInformation> userInformations = userInformationRepository.findAll();
        assertEquals(3,userInformations.size());
    }

    @Test
    void save() {
        assertNotNull(savedUserInfo);
        assertNotNull(savedUserInfo.getId());
    }
}