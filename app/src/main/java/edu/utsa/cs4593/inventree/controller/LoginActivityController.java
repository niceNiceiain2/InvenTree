package edu.utsa.cs4593.inventree.controller;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.cs4593.inventree.LoginPortal;
import edu.utsa.cs4593.inventree.R;

public class LoginActivityController extends AppCompatActivity {

    private EditText usernameInput;
    private EditText passwordInput;
    public LoginPortal loginActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_portal);

        usernameInput = findViewById(R.id.username);
        passwordInput = findViewById(R.id.password);
        Button logInButton = findViewById(R.id.logInButton);

        loginActivity = new LoginPortal(this);

        logInButton.setOnClickListener(view -> {
            String username = usernameInput.getText().toString();
            String password = passwordInput.getText().toString();
            loginActivity.login(username, password);
        });
    }
}
