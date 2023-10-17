package Africa.semicolon.bvasbeta.repositories;

import Africa.semicolon.bvasbeta.models.Admin;
import Africa.semicolon.bvasbeta.models.UserInformation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BvasBetaAdminRepositoryTest {
    AdminRepository adminRepository;
    @BeforeEach
    void setUp() {
        adminRepository = new BvasBetaAdminRepository();
    }

    @Test
    void save() {
        UserInformation userInformation = new UserInformation("SAYNOTORIGGING","1","NOTOBRIBE");
        Admin admin = new Admin();
        admin.setUserInformation(userInformation);
        adminRepository.save(admin);

        UserInformation userInformation2 = new UserInformation("SAYNOTORIGGING","1","NOTOBRIBE");
        Admin admin2 = new Admin();
        admin2.setUserInformation(userInformation2);
        adminRepository.save(admin2);
        System.out.println(admin2.getId());
        assertEquals(2,adminRepository.getNumberOfAdmin());

    }

    @Test
    void findById() {
        UserInformation userInformation = new UserInformation("SAYNOTORIGGING","1","NOTOBRIBE");
        Admin admin = new Admin();
        admin.setUserInformation(userInformation);
        adminRepository.save(admin);

        UserInformation userInformation2 = new UserInformation("SAYNOTORIGGING","2","NOTOBRIBE");
        Admin admin2 = new Admin();
        admin2.setUserInformation(userInformation2);
        adminRepository.save(admin2);

        assertEquals(admin2,adminRepository.findById("2"));
    }

    @Test
    void findAll() {
    }

    @Test
    void deleteById() {
        UserInformation userInformation = new UserInformation("SAYNOTORIGGING","1","NOTOBRIBE");
        Admin admin = new Admin();
        admin.setUserInformation(userInformation);
        adminRepository.save(admin);

        UserInformation userInformation2 = new UserInformation("SAYNOTORIGGING","2","NOTOBRIBE");
        Admin admin2 = new Admin();
        admin2.setUserInformation(userInformation2);
        adminRepository.save(admin2);
        assertEquals(2,adminRepository.getNumberOfAdmin());

        adminRepository.deleteById(admin2.getId());
        assertEquals(1,adminRepository.getNumberOfAdmin());

    }
}