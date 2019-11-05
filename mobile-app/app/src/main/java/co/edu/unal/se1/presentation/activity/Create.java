package co.edu.unal.se1.presentation.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

import co.edu.unal.se1.R;
import co.edu.unal.se1.businessLogic.controller.UserController;
import co.edu.unal.se1.dataAccess.model.User;

public class Create extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create);

        final TextInputEditText idInput = findViewById(R.id.id);
        final TextInputEditText nameInput = findViewById(R.id.email);
        final TextInputEditText emailInput = findViewById(R.id.email);
        final TextInputEditText balanceInput = findViewById(R.id.username);

        Button createButton = findViewById(R.id.createButton);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User user = new User();
                user.setUser_Id(Integer.parseInt(idInput.getText().toString()));
                user.setName(nameInput.getText().toString());
                user.setEmail(emailInput.getText().toString());


                userController = new UserController();
                userController.createUser(user, getApplicationContext());
            }
        });

    }


}
