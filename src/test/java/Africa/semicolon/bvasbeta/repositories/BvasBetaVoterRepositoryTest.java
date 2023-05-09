package Africa.semicolon.bvasbeta.repositories;

import Africa.semicolon.bvasbeta.models.Address;
import Africa.semicolon.bvasbeta.models.Gender.Gender;
import Africa.semicolon.bvasbeta.models.Voter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static Africa.semicolon.bvasbeta.models.Gender.Gender.FEMALE;
import static Africa.semicolon.bvasbeta.models.Gender.Gender.MALE;
import static org.junit.jupiter.api.Assertions.assertEquals;


class BvasBetaVoterRepositoryTest {
    VoterRepository voterRepository;

    @BeforeEach
    void setUp() {
        voterRepository =new BvasBetaVoterRepository();
    }

    @Test
    void save() {
        Voter voter = new Voter();
        Address address = new Address("12","Sabo","yaba","Lagos");
        voter.setName("FirstName");
        voter.setAge(18);
        voter.setAddress(address);
        voter.setGender(MALE);
        voter.setVoterIdentificationNumber("12344");


        Voter voter2 = new Voter();
        Address address2 = new Address("12","Sabo","yaba","Lagos");
        voter2.setName("FirstName");
        voter2.setAge(18);
        voter2.setAddress(address2);
        voter2.setGender(FEMALE);
        voter2.setVoterIdentificationNumber("12344");

        voterRepository.save(voter);
        voterRepository.save(voter2);
        assertEquals(2,voterRepository.numbersOfRegisteredVoters());
    }
    @Test
    void findById() {
        Voter voter = new Voter();
        Address address = new Address("12","Sabo","yaba","Lagos");
        voter.setName("FirstName");
        voter.setAge(18);
        voter.setAddress(address);
        voter.setGender(MALE);
        voter.setVoterIdentificationNumber("12344");


        Voter voter2 = new Voter();
        Address address2 = new Address("12","Sabo","yaba","Lagos");
        voter2.setName("FirstName");
        voter2.setAge(18);
        voter2.setAddress(address2);
        voter2.setGender(FEMALE);
        voter2.setVoterIdentificationNumber("12344");

        voterRepository.save(voter);
        voterRepository.save(voter2);
        assertEquals(voter,voterRepository.findById("1"));

    }

    @Test
    void findAll() {
        Voter voter = new Voter();
        Address address = new Address("12","Sabo","yaba","Lagos");
        voter.setName("FirstName");
        voter.setAge(18);
        voter.setAddress(address);
        voter.setGender(MALE);
        voter.setVoterIdentificationNumber("12344");


        Voter voter2 = new Voter();
        Address address2 = new Address("12","Sabo","yaba","Lagos");
        voter2.setName("FirstName");
        voter2.setAge(18);
        voter2.setAddress(address2);
        voter2.setGender(FEMALE);
        voter2.setVoterIdentificationNumber("12444");

        voterRepository.save(voter);
        voterRepository.save(voter2);
        voterRepository.deleteById("2");

    }



    @Test
    void deleteById() {
        Voter voter = new Voter();
        Address address = new Address("12","Sabo","yaba","Lagos");
        voter.setName("FirstName");
        voter.setAge(18);
        voter.setAddress(address);
        voter.setGender(MALE);
        voter.setVoterIdentificationNumber("12344");


        Voter voter2 = new Voter();
        Address address2 = new Address("12","Sabo","yaba","Lagos");
        voter2.setName("FirstName");
        voter2.setAge(18);
        voter2.setAddress(address2);
        voter2.setGender(FEMALE);
        voter2.setVoterIdentificationNumber("12444");

        voterRepository.save(voter);
        voterRepository.save(voter2);
        voterRepository.deleteById("2");
        assertEquals(1,voterRepository.numbersOfRegisteredVoters());

    }
}