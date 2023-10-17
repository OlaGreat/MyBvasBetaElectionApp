package Africa.semicolon.bvasbeta.repositories;


import Africa.semicolon.bvasbeta.models.Voter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


import static Africa.semicolon.bvasbeta.models.Gender.Gender.MALE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class BvasBetaVoterRepositoryTest {
    private final VoterRepository voterRepository = new BvasBetaVoterRepository();
    private Voter savedVoter;

    @BeforeEach
    void setUp() {
        Voter voter = buildTestVoter();
        savedVoter = voterRepository.save(voter);


    }

    @Test
    void save() {
//        Voter voter = new Voter();
//        Address address = new Address("12","Sabo","yaba","Lagos");
//        voter.setName("FirstName");
//        voter.setAge(18);
//        voter.setAddress(address);
//        voter.setGender(MALE);
//        voter.setVoterIdentificationNumber("12344");
//
//
//        Voter voter2 = new Voter();
//        Address address2 = new Address("12","Sabo","yaba","Lagos");
//        voter2.setName("FirstName");
//        voter2.setAge(18);
//        voter2.setAddress(address2);
//        voter2.setGender(FEMALE);
//        voter2.setVoterIdentificationNumber("12344");
//
//        voterRepository.save(voter);
//        v//oterRepository.save(voter2);
//        assertEquals(2,voterRepository.numbersOfRegisteredVoters());
//        FEMISTEST
        assertNotNull(savedVoter);
        assertNotNull(savedVoter.getId());
    }
    @Test
    void findById() {
//        Voter voter = new Voter();
//        Address address = new Address("12","Sabo","yaba","Lagos");
//        voter.setName("FirstName");
//        voter.setAge(18);
//        voter.setAddress(address);
//        voter.setGender(MALE);
//        voter.setVoterIdentificationNumber("12344");
//
//
//        Voter voter2 = new Voter();
//        Address address2 = new Address("12","Sabo","yaba","Lagos");
//        voter2.setName("FirstName");
//        voter2.setAge(18);
//        voter2.setAddress(address2);
//        voter2.setGender(FEMALE);
//        voter2.setVoterIdentificationNumber("12344");
//
//        voterRepository.save(voter);
//        voterRepository.save(voter2);
//        assertEquals(voter,voterRepository.findById("1"));

        //        FEMi'sTEST
        Voter foundVoter = voterRepository.findById(savedVoter.getId());
        assertNotNull(foundVoter);

    }

    @Test
    void findAll() {
//        MYOWNTEST
//        Voter voter = new Voter();
//        Address address = new Address("12","Sabo","yaba","Lagos");
//        voter.setName("FirstName");
//        voter.setAge(18);
//        voter.setAddress(address);
//        voter.setGender(MALE);
//        voter.setVoterIdentificationNumber("12344");
//
//
//        Voter voter2 = new Voter();
//        Address address2 = new Address("12","Sabo","yaba","Lagos");
//        voter2.setName("FirstName");
//        voter2.setAge(18);
//        voter2.setAddress(address2);
//        voter2.setGender(FEMALE);
//        voter2.setVoterIdentificationNumber("12444");
//
//        voterRepository.save(voter);
//        voterRepository.save(voter2);
//        voterRepository.deleteById("2");


//        FEMi'sTEST
        voterRepository.save(new Voter());
        voterRepository.save(new Voter());
        List<Voter> voters = voterRepository.findAll();
        assertEquals(3, voters.size());
        assertNotNull(voters.get(0));
        assertNotNull(voters.get(1));
        assertNotNull(voters.get(2));



    }
    private Voter buildTestVoter(){
        Voter voter = new Voter();
        voter.setName("Name");
        voter.setAge(20);
        voter.setGender(MALE);
        return voter;

    }



    @Test
    void deleteById() {
//        Voter voter = new Voter();
//        Address address = new Address("12","Sabo","yaba","Lagos");
//        voter.setName("FirstName");
//        voter.setAge(18);
//        voter.setAddress(address);
//        voter.setGender(MALE);
//        voter.setVoterIdentificationNumber("12344");
//
//
//        Voter voter2 = new Voter();
//        Address address2 = new Address("12","Sabo","yaba","Lagos");
//        voter2.setName("FirstName");
//        voter2.setAge(18);
//        voter2.setAddress(address2);
//        voter2.setGender(FEMALE);
//        voter2.setVoterIdentificationNumber("12444");
//
//        voterRepository.save(voter);
//        voterRepository.save(voter2);
//        voterRepository.deleteById("2");
//        assertEquals(1,voterRepository.numbersOfRegisteredVoters());

       Voter anotherVoter = voterRepository.save(new Voter());
        List<Voter> voters = voterRepository.findAll();
        assertEquals(2,voters.size());
        voterRepository.deleteById(anotherVoter.getId());
        voters = voterRepository.findAll();
        assertEquals(1,voters.size());


    }
}