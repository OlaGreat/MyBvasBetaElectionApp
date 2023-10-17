package Africa.semicolon.bvasbeta.services;

import Africa.semicolon.bvasbeta.dto.request.VoterRegistrationRequest;
import Africa.semicolon.bvasbeta.dto.response.DeleteVoterResponse;
import Africa.semicolon.bvasbeta.dto.response.VoterRegistrationResponse;
import Africa.semicolon.bvasbeta.execptions.VoterRegistrationProccesFailedException;
import Africa.semicolon.bvasbeta.mappers.ModelMapper;
import Africa.semicolon.bvasbeta.models.Voter;
import Africa.semicolon.bvasbeta.repositories.BvasBetaVoterRepository;
import Africa.semicolon.bvasbeta.repositories.VoterRepository;

import java.util.List;
import java.util.UUID;

import static Africa.semicolon.bvasbeta.utils.AppUtils.*;

public class BvasBetaVoterServices implements VoterService{
    VoterRepository voterRepository = new BvasBetaVoterRepository();
    @Override
    public VoterRegistrationResponse register(VoterRegistrationRequest voterRegistrationRequest) throws VoterRegistrationProccesFailedException {
        Voter voter = ModelMapper.votersMapper(voterRegistrationRequest);
        String VIN = generateVoterIdentificationNumber();
        voter.setVoterIdentificationNumber(VIN);
        Voter savedVoter = voterRepository.save(voter);


        if (savedVoter == null) throw new VoterRegistrationProccesFailedException("Voter registration Failed");
        VoterRegistrationResponse voterRegistrationResponse = new VoterRegistrationResponse();
        voterRegistrationResponse.setMessage("Registration successful may vote count");
        voterRegistrationResponse.setVoterRegistrationNumber(savedVoter.getVoterIdentificationNumber());


        return voterRegistrationResponse;
    }


    @Override
    public Voter getVoterById(String id) {
        return voterRepository.findById(id);
    }


    @Override
    public List<Voter> votersList() {
        return voterRepository.findAll();
    }

    @Override
    public DeleteVoterResponse deleteById(String id) {
        voterRepository.deleteById(id);
        return DeleteVoterResponse.builder().message("Your details as been deleted").build();
    }


    private static String generateVoterIdentificationNumber(){
        String uuid = getUUID();
        String validUUID = stripInvalidCharactersFrom(uuid);
        return buildVoterIdentificationNumberFrom(validUUID);
    }

    private static String stripInvalidCharactersFrom(String randomUUID) {
        String result="";
        for (int index = ZERO; index < randomUUID.length(); index++) {
         char currentCharacters =  randomUUID.charAt(index);
            if(currentCharacters!='-') result+= randomUUID.charAt(index);
        }
        return result;
    }

    private static String buildVoterIdentificationNumberFrom(String validUuid) {
        String result = "";
        for (int index = ZERO; index < validUuid.length(); index++){
            if(index%FIVE==ZERO) result+=" ";
            else result+= validUuid.charAt(index);
        }
        return result.substring(ZERO, result.length() - EIGHT).strip();
    }

    private static String getUUID() {
        UUID randomUuid = UUID.randomUUID();
        return randomUuid.toString().toUpperCase();
    }
}
