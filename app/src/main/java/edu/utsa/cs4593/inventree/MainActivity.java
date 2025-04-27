package edu.utsa.cs4593.inventree;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.cs4593.inventree.controller.SigninController;


public class MainActivity extends AppCompatActivity {
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button signinButton;


    public static EditText username, password;

    @Override
    /*
     * Sets the OnCreate method and takes in the bundle and saved Instance state.
     * OnCreate function makes all the avengers in a button and returns the setOnClicker.
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginportal);

        TextView textView = (TextView) findViewById(R.id.textView);
        TextView usernameText = (TextView) findViewById(R.id.username);
        TextView passwordText = (TextView) findViewById(R.id.password);

        textView.setTextSize(40);
        textView.setTextColor(Color.BLUE);
        textView.setWidth(5);

        usernameText.setTextSize(20);
        usernameText.setTextColor(Color.BLUE);

        passwordText.setTextSize(20);
        passwordText.setTextColor(Color.BLUE);

        Button signin = findViewById(R.id.button);
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        signin.setOnClickListener(new SigninController());
    }
}