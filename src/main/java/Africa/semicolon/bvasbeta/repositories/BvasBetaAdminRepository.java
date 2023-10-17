package Africa.semicolon.bvasbeta.repositories;

import Africa.semicolon.bvasbeta.models.Admin;
import Africa.semicolon.bvasbeta.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;

public class BvasBetaAdminRepository implements AdminRepository{
    List<Admin> adminsList = new ArrayList<>();

    @Override
    public Admin save(Admin admin) {
        boolean IsSaved = admin.getId() != null;
        if (IsSaved){
            updateAdmin(admin);
        }
        else
            saveAdmin(admin);
        return admin;
    }

    private void saveAdmin(Admin admin) {
        admin.setId(AppUtils.generatedId());
        adminsList.add(admin);
    }

    private void updateAdmin(Admin admin) {
        Admin savedAdmin = findById(admin.getId());
        adminsList.remove(savedAdmin);
        adminsList.add(admin);
    }

    @Override
    public Admin findById(String id) {
        for(Admin savedAdmin : adminsList){if(savedAdmin.getId().equals(id))return savedAdmin;}
        return null;
    }

    @Override
    public List<Admin> findAll() {
        return adminsList;
    }



    @Override
    public void deleteById(String id) {
        Admin foundAdmin = findById(id);
        if (foundAdmin!=null)adminsList.remove(foundAdmin);
    }

    @Override
    public int getNumberOfAdmin() {
        return adminsList.size();
    }
}
