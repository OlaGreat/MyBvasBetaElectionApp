package Africa.semicolon.bvasbeta.services;

import Africa.semicolon.bvasbeta.dto.request.AdminRegistrationRequest;
import Africa.semicolon.bvasbeta.dto.response.AdminRegistrationResponse;
import Africa.semicolon.bvasbeta.dto.response.DeleteAdminResponse;
import Africa.semicolon.bvasbeta.execptions.AdminRegistrationRequestFailedException;
import Africa.semicolon.bvasbeta.mappers.ModelMapper;
import Africa.semicolon.bvasbeta.models.Admin;
import Africa.semicolon.bvasbeta.repositories.AdminRepository;
import Africa.semicolon.bvasbeta.repositories.BvasBetaAdminRepository;

import java.util.List;


public class BvasBetaAdminService implements AdminService {
    AdminRepository adminRepository = new BvasBetaAdminRepository();

    @Override
    public AdminRegistrationResponse registerAdmin(AdminRegistrationRequest adminRegistrationRequest) throws AdminRegistrationRequestFailedException {
        Admin admin = ModelMapper.adminMapper(adminRegistrationRequest);
        Admin savedAdmin = adminRepository.save(admin);


        if (savedAdmin == null)throw new AdminRegistrationRequestFailedException("Admin registration process failed");

        AdminRegistrationResponse adminRegistrationResponse = new AdminRegistrationResponse();
        adminRegistrationResponse.setMessage("You have been registered as an admin pls say no to bribe");
        adminRegistrationResponse.setId(savedAdmin.getId());

        return adminRegistrationResponse;
    }

    @Override
    public Admin getAdminById(String id) {
        return adminRepository.findById(id);
    }

    @Override
    public List<Admin> adminList() {
        return adminRepository.findAll();
    }

    @Override
    public DeleteAdminResponse deleteAdminById(String id) {
        adminRepository.deleteById(id);
        return DeleteAdminResponse.builder().message("You have been deleted as an Admin").build();
    }
}

