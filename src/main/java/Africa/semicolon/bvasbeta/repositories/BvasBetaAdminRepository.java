package Africa.semicolon.bvasbeta.repositories;

import Africa.semicolon.bvasbeta.models.Admin;

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
        admin.setId(generateId());
        adminsList.add(admin);
    }

    private String generateId() {
        return Integer.toString(adminsList.size()+1);
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
        return null;
    }



    @Override
    public void deleteById(String id) {
        Admin foundAdmin = null;
        for(Admin savedAdmin : adminsList){if(savedAdmin.getId().equals(id))foundAdmin = savedAdmin;}
        adminsList.remove(foundAdmin);
    }

    @Override
    public int getNumberOfAdmin() {
        return adminsList.size();
    }
}
