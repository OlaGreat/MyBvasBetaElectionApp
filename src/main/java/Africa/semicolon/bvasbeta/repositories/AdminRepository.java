package Africa.semicolon.bvasbeta.repositories;
import Africa.semicolon.bvasbeta.models.Admin;

import java.util.List;

public interface AdminRepository {
    Admin findById(String id);
    List<Admin> findAll();
    Admin save(Admin admin);
    void deleteById(String id);
    int getNumberOfAdmin();
}
