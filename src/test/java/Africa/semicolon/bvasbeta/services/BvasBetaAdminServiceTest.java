package Africa.semicolon.bvasbeta.services;

import Africa.semicolon.bvasbeta.dto.request.AdminRegistrationRequest;
import Africa.semicolon.bvasbeta.dto.response.AdminRegistrationResponse;
import Africa.semicolon.bvasbeta.execptions.AdminRegistrationRequestFailedException;
import Africa.semicolon.bvasbeta.models.Admin;
import Africa.semicolon.bvasbeta.models.UserInformation;
import Africa.semicolon.bvasbeta.repositories.AdminRepository;
import Africa.semicolon.bvasbeta.repositories.BvasBetaAdminRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BvasBetaAdminServiceTest {
AdminService adminService = new BvasBetaAdminService();
AdminRegistrationRequest adminRegistrationRequest;
AdminRegistrationRequest adminRegistrationRequest1;
    @BeforeEach
    void setUp() {
        adminRegistrationRequest = adminBuilder();
        adminRegistrationRequest1 = adminBuilder1();
    }

    @Test
    void registerAdmin() {
        try {
            AdminRegistrationResponse savedAdmin = adminService.registerAdmin(adminRegistrationRequest);
            assertNotNull(savedAdmin);
            assertNotNull(savedAdmin.getId());
        } catch (AdminRegistrationRequestFailedException exception){
        System.out.println(exception);
        }


    }
    @Test
    void findAdminById() throws AdminRegistrationRequestFailedException {
        AdminRegistrationResponse savedAdmin = adminService.registerAdmin(adminRegistrationRequest);
        AdminRegistrationResponse newAdmin = adminService.registerAdmin(adminRegistrationRequest1);
        assertNotNull(savedAdmin);
        assertNotNull(newAdmin);

        Admin foundAdmin = adminService.getAdminById(savedAdmin.getId());
        Admin anotherFoundAdmin = adminService.getAdminById(newAdmin.getId());
        assertNotNull(anotherFoundAdmin);
        assertNotNull(foundAdmin);
    }
    @Test
    void getAllAdminTest() throws AdminRegistrationRequestFailedException {
        AdminRegistrationResponse savedAdmin = adminService.registerAdmin(adminRegistrationRequest);
        AdminRegistrationResponse savedAdmin1 = adminService.registerAdmin(adminRegistrationRequest1);
        assertNotNull(savedAdmin);
        assertNotNull(savedAdmin1);
        List<Admin> admins = adminService.adminList();
        assertEquals(2,admins.size());
    }

    @Test
    void deleteAdminByIdTest() throws AdminRegistrationRequestFailedException {
        AdminRegistrationResponse savedAdmin = adminService.registerAdmin(adminRegistrationRequest);
        AdminRegistrationResponse savedAdmin1 = adminService.registerAdmin(adminRegistrationRequest1);
        assertNotNull(savedAdmin);
        assertNotNull(savedAdmin1);
        adminService.deleteAdminById(savedAdmin.getId());
        List<Admin> admins = adminService.adminList();
        assertEquals(1,admins.size());
    }

    private static AdminRegistrationRequest adminBuilder(){
        AdminRegistrationRequest adminRegistrationRequest = new AdminRegistrationRequest();
        UserInformation userInformation = new UserInformation();
        userInformation.setUserName("Admin");
        userInformation.setPassWord("Admin");
        adminRegistrationRequest.setUserInformation(userInformation);
        return adminRegistrationRequest;
    }
    private static AdminRegistrationRequest adminBuilder1(){
        AdminRegistrationRequest adminRegistrationRequest1 = new AdminRegistrationRequest();
        UserInformation userInformation = new UserInformation();
        userInformation.setPassWord("Password");
        userInformation.setUserName("Username");
        adminRegistrationRequest1.setUserInformation(userInformation);
        return adminRegistrationRequest1;
    }
}