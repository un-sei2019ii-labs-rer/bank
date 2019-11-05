package co.edu.unal.se1.businessLogic.controller;

import android.content.Context;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import co.edu.unal.se1.dataAccess.model.User;
import co.edu.unal.se1.dataAccess.repository.UserRepository;

public class UserController {

    private UserRepository userRepository;
    private UserController userController;

    public UserController() {

    }

    public void createUser(User user, Context context) {
        userRepository = new UserRepository(context);
        userRepository.createUser(user);
    }

    public void updateUser(User user, Context context) {
        userRepository = new UserRepository(context);
        userRepository.updateUser(user);
    }

    public void changePassword(int user_Id, Context context) {
        userRepository = new UserRepository(context);
        final User user = userRepository.getUserById(user_Id);
        Date datePassword = user.getPassword_change();
        Calendar calendarDatePassword = Calendar.getInstance();
        calendarDatePassword.setTime(datePassword);

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;


        int monthDatePassword = (month - calendarDatePassword.get(Calendar.YEAR))*12;
        monthDatePassword += month - calendarDatePassword.get(Calendar.MONTH);

        if (monthDatePassword == 3){
            userController = new UserController();
            userController.updateUser(user, context);
        }
    }

    public boolean Log_In(String username, int password, Context context){
        userRepository = new UserRepository(context);
        List<User> userList = userRepository.getAllUsers();
        boolean log_In = false;

        for(User user : userList){
            if(user.getUsername() == username){
                if(user.getPassword() == password);
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