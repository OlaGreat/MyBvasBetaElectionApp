package Africa.semicolon.bvasbeta.repositories;

import Africa.semicolon.bvasbeta.models.Voter;

import java.util.ArrayList;
import java.util.List;

public class BvasBetaVoterRepository implements VoterRepository{
    List<Voter> voters = new ArrayList<>();

    @Override
    public List<Voter> findAll() {
        return voters;
    }

    @Override
    public Voter save(Voter voter) {
        boolean IsSaved = voter.getId()!= null;
        if(IsSaved){
            updateUser(voter);
        }
        else
            saveNewUser(voter);


        return voter;
    }

    private void saveNewUser(Voter voter) {
        voter.setId(generateId());
        voters.add(voter);
    }

    private String generateId() {
        return Integer.toString(voters.size()+1);
    }


    private void updateUser(Voter voter){
        Voter savedVoter = findById(voter.getId());
        voters.remove(savedVoter);
        voters.add(voter);
    }
    @Override
    public Voter findById(String id) {
        Voter foundVoter = null;
        for (Voter savedVoter : voters){
            if(savedVoter.getId().equals(id)){
                foundVoter = savedVoter;
            }
        }
        return foundVoter;
    }

    @Override
    public void deleteById(String id) {
        Voter foundVoter = findById(id);
        if (foundVoter!= null)voters.remove(foundVoter);
    }
    @Override
    public int numbersOfRegisteredVoters(){
        return voters.size();
    }
}

