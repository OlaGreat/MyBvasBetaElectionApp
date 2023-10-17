package Africa.semicolon.bvasbeta.services;

import Africa.semicolon.bvasbeta.dto.request.VoterRegistrationRequest;
import Africa.semicolon.bvasbeta.dto.response.DeleteVoterResponse;
import Africa.semicolon.bvasbeta.dto.response.VoterRegistrationResponse;
import Africa.semicolon.bvasbeta.execptions.VoterRegistrationProccesFailedException;
import Africa.semicolon.bvasbeta.models.Voter;

import java.util.List;

public interface VoterService {
   VoterRegistrationResponse register(VoterRegistrationRequest request) throws VoterRegistrationProccesFailedException;
   Voter getVoterById(String id);

   List<Voter> votersList();

   DeleteVoterResponse deleteById(String id);
}
