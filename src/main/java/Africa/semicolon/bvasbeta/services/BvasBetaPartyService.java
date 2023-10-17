package Africa.semicolon.bvasbeta.services;

import Africa.semicolon.bvasbeta.dto.request.PartyRegistrationRequest;
import Africa.semicolon.bvasbeta.dto.response.DeletePartyResponse;
import Africa.semicolon.bvasbeta.dto.response.PartyRegistrationResponse;
import Africa.semicolon.bvasbeta.execptions.PartyRegistrationRequestFailedException;
import Africa.semicolon.bvasbeta.mappers.ModelMapper;
import Africa.semicolon.bvasbeta.models.Party;
import Africa.semicolon.bvasbeta.models.UserInformation;
import Africa.semicolon.bvasbeta.repositories.BvasBetaPartyRepository;
import Africa.semicolon.bvasbeta.repositories.PartyRepository;

import java.util.List;
import java.util.UUID;

import static Africa.semicolon.bvasbeta.utils.AppUtils.*;

public class BvasBetaPartyService implements PartyService{
    PartyRepository partyRepository = new BvasBetaPartyRepository();

    @Override
    public PartyRegistrationResponse registerNewParty(PartyRegistrationRequest partyRegistrationRequest) throws PartyRegistrationRequestFailedException {
        Party party = ModelMapper.partyMapper(partyRegistrationRequest);
        String PIN = generatePartyIdentificationNumber();
        party.setPartyRegistrationNumber(PIN);
        Party savedParty = partyRepository.save(party);

        if(savedParty == null) throw new PartyRegistrationRequestFailedException("Your party registration failed");
        PartyRegistrationResponse partyRegistrationResponse = new PartyRegistrationResponse();
        partyRegistrationResponse.setName(savedParty.getName());
        partyRegistrationResponse.setPartyRegistrationNumber(savedParty.getPartyRegistrationNumber());
        partyRegistrationResponse.setMessage("Your Party registration is complete, Say no to corruption");

        return partyRegistrationResponse;
    }

    @Override
    public Party findById(String id) {
        return partyRepository.findById(id);
    }

    @Override
    public DeletePartyResponse deleteById(String id) {
        partyRepository.deleteById(id);
        return DeletePartyResponse.builder().message("Your party has been deleted").build();
    }

    @Override
    public List<Party> getAllParty() {
        return partyRepository.findAll();
    }




    private static String generatePartyIdentificationNumber(){
        String uuid = getUUID();
        String validUUID = stripInvalidCharactersFrom(uuid);
        return buildPartyIdentificationNumberFrom(validUUID);
    }

    private static String stripInvalidCharactersFrom(String randomUUID) {
        String result="";
        for (int index = ZERO; index < randomUUID.length(); index++) {
            char currentCharacters =  randomUUID.charAt(index);
            if(currentCharacters!='-') result+= randomUUID.charAt(index);
        }
        return result;
    }

    private static String buildPartyIdentificationNumberFrom(String validUuid) {
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
