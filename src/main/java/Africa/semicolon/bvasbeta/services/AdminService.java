package Africa.semicolon.bvasbeta.services;

import Africa.semicolon.bvasbeta.dto.request.AdminRegistrationRequest;
import Africa.semicolon.bvasbeta.dto.response.AdminRegistrationResponse;
import Africa.semicolon.bvasbeta.dto.response.DeleteAdminResponse;
import Africa.semicolon.bvasbeta.execptions.AdminRegistrationRequestFailedException;
import Africa.semicolon.bvasbeta.models.Admin;

import java.util.List;

public interface AdminService {
    AdminRegistrationResponse registerAdmin(AdminRegistrationRequest adminRegistrationRequest) throws AdminRegistrationRequestFailedException;

    Admin getAdminById(String id);

    List<Admin> adminList();

    DeleteAdminResponse deleteAdminById(String id);

}
