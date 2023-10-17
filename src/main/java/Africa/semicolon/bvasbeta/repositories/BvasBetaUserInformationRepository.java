package Africa.semicolon.bvasbeta.repositories;

import Africa.semicolon.bvasbeta.models.UserInformation;

import java.util.ArrayList;
import java.util.List;

public class BvasBetaUserInformationRepository implements UserInformationRepository {
    private List<UserInformation> userInformations = new ArrayList<>();
    @Override
    public UserInformation findById(String id) {
        for(UserInformation savedUserInfo : userInformations){if(savedUserInfo.getId().equals(id))return savedUserInfo;}
        return null;
    }

    @Override
    public void deleteById(String id) {
        UserInformation foundUser = findById(id);
        if (foundUser != null) userInformations.remove(foundUser);

    }

    @Override
    public List<UserInformation> findAll() {
        return userInformations;
    }

    @Override
    public UserInformation save(UserInformation userInformation) {
        boolean isNotSaved = userInformation.getId() != null;
        if(isNotSaved)userInformations.add(userInformation);
        return userInformation;
    }

}
