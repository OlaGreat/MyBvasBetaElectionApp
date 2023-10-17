package Africa.semicolon.bvasbeta.mappers;

import Africa.semicolon.bvasbeta.dto.request.AdminRegistrationRequest;
import Africa.semicolon.bvasbeta.dto.request.CreateElectionRequest;
import Africa.semicolon.bvasbeta.dto.request.PartyRegistrationRequest;
import Africa.semicolon.bvasbeta.dto.request.VoterRegistrationRequest;
import Africa.semicolon.bvasbeta.models.*;
import Africa.semicolon.bvasbeta.models.Gender.Gender;

import java.time.LocalDate;
import java.util.List;

public class ModelMapper {
    public static Voter votersMapper(VoterRegistrationRequest voterRegistrationRequest){
        Address address = buildAddress(voterRegistrationRequest);
        UserInformation userInformation = buildVoterUserInformation(voterRegistrationRequest);
        Voter voter = buildVoter(voterRegistrationRequest,address,userInformation);

        return voter;
    }
    public static Admin adminMapper(AdminRegistrationRequest adminRegistrationRequest){
        UserInformation userInformation = buildAdminUserInformation(adminRegistrationRequest);
        Admin admin = buildAdmin(adminRegistrationRequest,userInformation);
        return admin;
    }
    public static Party partyMapper(PartyRegistrationRequest partyRegistrationRequest){
        UserInformation userInformation = buildPartyUserInformation(partyRegistrationRequest);
        Party party = partyMapperBuilder(partyRegistrationRequest,userInformation);
        return party;
    }

    private static Party partyMapperBuilder(PartyRegistrationRequest partyRegistrationRequest, UserInformation userInformation) {
       return Party.builder()
               .userInformation(userInformation)
               .name(partyRegistrationRequest.getName())
               .build();
    }

    private static UserInformation buildPartyUserInformation(PartyRegistrationRequest partyRegistrationRequest) {
        UserInformation userInformation = new UserInformation();
        userInformation.setUserName(partyRegistrationRequest.getUserInformation().getUserName());
        userInformation.setPassWord(partyRegistrationRequest.getUserInformation().getPassWord());
        return userInformation;
    }

    private static UserInformation buildAdminUserInformation(AdminRegistrationRequest adminRegistrationRequest) {
        UserInformation userInformation = new UserInformation();
        userInformation.setUserName(adminRegistrationRequest.getUserInformation().getUserName());
        userInformation.setPassWord(adminRegistrationRequest.getUserInformation().getPassWord());
        return userInformation;
    }
    private static Admin buildAdmin(AdminRegistrationRequest adminRegistrationRequest,UserInformation userInformation){
        return Admin.builder()
                .userInformation(userInformation)
                .build();
    }


    public static Election ElectionMapper(CreateElectionRequest createElectionRequest){
        Election election = new Election();
        Category electionCategory = Category.valueOf(createElectionRequest.getElectionCategory().toUpperCase());
        election.setCategory(electionCategory);
        LocalDate electionDate = LocalDate.parse(createElectionRequest.getElectionDate());
        election.setElectionDate(electionDate);
        List<Party> parties = getPoliticalParties(createElectionRequest.getParty());
//        election.setParties();
        return null;
    }
    private static List<Party> getPoliticalParties(List<String> party){
        return null;
    }

    private static Voter buildVoter(VoterRegistrationRequest voterRegistrationRequest, Address address, UserInformation userInformation){
//        Voter voter = new Voter();
//        voter.setName(voterRegistrationRequest.getName());
//        voter.setAge(voterRegistrationRequest.getAge());
//        Gender voterGender = Gender.valueOf(voterRegistrationRequest.getGender().toUpperCase());
//        voter.setGender(voterGender);


        Gender voterGender = Gender.valueOf(voterRegistrationRequest.getGender().toUpperCase());
        return Voter.builder()
                .address(address)
                .gender(voterGender)
                .userInformation(userInformation)
                .age(voterRegistrationRequest.getAge())
                .name(voterRegistrationRequest.getName())
                .build();
    }
    private static UserInformation buildVoterUserInformation(VoterRegistrationRequest voterRegistrationRequest){
//        UserInformation userInformation = new UserInformation();
//        userInformation.setUserName(voterRegistrationRequest.getUserName());
//        userInformation.setPassWord(voterRegistrationRequest.getPassWord());

        UserInformation userInformation = new UserInformation();
        userInformation.setPassWord(voterRegistrationRequest.getPassWord());
        userInformation.setUserName(voterRegistrationRequest.getUserName());
        return userInformation;
    }
    private static Address buildAddress(VoterRegistrationRequest voterRegistrationRequest){
//        Address address = new Address();
//        address.setHouseNumber(voterRegistrationRequest.getHouseNumber());
//        address.setLga(voterRegistrationRequest.getLga());
//        address.setState(voterRegistrationRequest.getState());
//        address.setStreet(voterRegistrationRequest.getStreet());

        Address address = new Address();
        address.setStreet(voterRegistrationRequest.getStreet());
        address.setState(voterRegistrationRequest.getState());
        address.setLga(voterRegistrationRequest.getLga());
        address.setHouseNumber(voterRegistrationRequest.getHouseNumber());
        return address;
    }
}

