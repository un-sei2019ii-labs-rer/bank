package co.edu.unal.se1.businessLogic.controller;

import android.content.Context;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import co.edu.unal.se1.dataAccess.model.User;
@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    User user = new User();
    @Mock
    Context mockContext;

    @Test
    public void createUser() {
        User user = new User();
        user.setName("Prueba");
        user.setUser_Id(100000000);
        user.setEmail("prueba@outlook.com");
        user.setPassword(100000);
        UserController controller= new UserController();
        controller.createUser(user,mockContext);

    }

    @Test
    public void updateUser() {
        User user = new User();
        UserController controller= new UserController();
        controller.updateUser(user,mockContext);
    }
}