package co.edu.unal.se1.businessLogic.controller;

import android.content.Context;

import java.util.List;

import co.edu.unal.se1.dataAccess.model.Admin;
import co.edu.unal.se1.dataAccess.repository.AdminRepository;


public class AdminController {

    private AdminRepository adminRepository;

    public AdminController() {

    }

    public void createAdmin(Admin admin, Context context) {
        adminRepository = new AdminRepository(context);
        adminRepository.createAdmin(admin);
    }

    public void updateAdmin(Admin admin, Context context) {
        adminRepository = new AdminRepository(context);
        adminRepository.updateAdmin(admin);
    }

    public boolean Log_In(String username, String password, Context context){
        adminRepository = new AdminRepository(context);
        List<Admin> adminList = adminRepository.getAllAdmins();
        boolean log_In = false;

        for(Admin admin : adminList){
            if(admin.getUsername() == username){
                if(admin.getPassword() == password);
                log_In = true;
                break;
            }
            else{
                log_In = false;
                break;
            }
        }
        return log_In;
    }

}
