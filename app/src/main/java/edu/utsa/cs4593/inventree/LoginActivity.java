//package edu.utsa.cs4593.inventree;
//
//import android.os.Bundle;
//import android.widget.Button;
//import android.widget.EditText;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import edu.utsa.cs4593.inventree.controller.UserAuthentication;
//import edu.utsa.cs4593.inventree.model.UserDatabase;
//
//
//public class LoginActivity extends AppCompatActivity {
//    private EditText usernameEditText;
//    private EditText passwordEditText;
//    private Button signinButton;
//
//
////    public static EditText username, password;
//
//    @Override
//    /*
//     * Sets the OnCreate method and takes in the bundle and saved Instance state.
//     * OnCreate function makes all the avengers in a button and returns the setOnClicker.
//     */
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.loginportal);
//
////        TextView textView = (TextView) findViewById(R.id.textView);
////        TextView usernameText = (TextView) findViewById(R.id.username);
////        TextView passwordText = (TextView) findViewById(R.id.password);
////
////        textView.setTextSize(40);
////        textView.setTextColor(Color.BLUE);
////        textView.setWidth(5);
////
////        usernameText.setTextSize(20);
////        usernameText.setTextColor(Color.BLUE);
////
////        passwordText.setTextSize(20);
////        passwordText.setTextColor(Color.BLUE);
////
////        Button signin = findViewById(R.id.button);
////        username=(EditText)findViewById(R.id.username);
////        password=(EditText)findViewById(R.id.password);
////        signin.setOnClickListener(new UserAuthentication());
//
//        usernameEditText = findViewById(R.id.username);
//        passwordEditText = findViewById(R.id.password);
//        signinButton = findViewById(R.id.button);
//
//        signinButton.setOnClickListener(view -> {
//            UserDatabase.loadUsers(LoginActivity.this);
//            String username = usernameEditText.getText().toString().trim();
//            String password = passwordEditText.getText().toString().trim();
//            new UserAuthentication(this, username, password).authenticate();
//        });
//    }
//}

package edu.utsa.cs4593.inventree;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.cs4593.inventree.controller.LoginPortalController;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameInput;
    private EditText passwordInput;
    private LoginPortalController loginPortalController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginportal); // your XML layout

        usernameInput = findViewById(R.id.username);
        passwordInput = findViewById(R.id.password);
        Button logInButton = findViewById(R.id.logInButton); // or whatever ID you used

        loginPortalController = new LoginPortalController(this);

        logInButton.setOnClickListener(view -> {
            String username = usernameInput.getText().toString();
            String password = passwordInput.getText().toString();
            loginPortalController.login(username, password);
        });
    }
}
