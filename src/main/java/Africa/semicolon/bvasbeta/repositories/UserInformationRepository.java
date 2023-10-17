package Africa.semicolon.bvasbeta.repositories;

import Africa.semicolon.bvasbeta.models.UserInformation;

import java.util.List;

public interface UserInformationRepository {
    UserInformation findById(String id);
    void deleteById(String id);
    List<UserInformation> findAll();
    UserInformation save(UserInformation userInformation);

}
