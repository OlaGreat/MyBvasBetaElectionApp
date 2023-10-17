package Africa.semicolon.bvasbeta.services;

import Africa.semicolon.bvasbeta.dto.request.PartyRegistrationRequest;
import Africa.semicolon.bvasbeta.dto.response.DeletePartyResponse;
import Africa.semicolon.bvasbeta.dto.response.PartyRegistrationResponse;
import Africa.semicolon.bvasbeta.execptions.PartyRegistrationRequestFailedException;
import Africa.semicolon.bvasbeta.models.Party;

import java.util.List;

public interface PartyService {
    PartyRegistrationResponse registerNewParty(PartyRegistrationRequest partyRegistrationRequest) throws PartyRegistrationRequestFailedException;

    List<Party> getAllParty();
    Party findById(String id);
    DeletePartyResponse deleteById(String id);
}
