package edu.utsa.cs4593.inventree;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//import edu.utsa.cs4593.inventree.controller.CreateItemScreenController;
import edu.utsa.cs4593.inventree.controller.LogoutController;

/*
 * Iain Summerlin - tea587
 *
 *
 */
public class ManagerHomepage extends AppCompatActivity {

    TableLayout tableLayout;
    public static int itemSelected;

    @Override
    /*
     * Sets the OnCreate method and takes in the bundle and saved Instance state.
     * OnCreate function makes all the avengers in a button and returns the setOnClicker.
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.managerhomepage);

        String username = getIntent().getStringExtra("username");
        TextView un = findViewById(R.id.textView37);
        un.setTextSize(20);
        un.setText(username);

        ImageButton logout = findViewById(R.id.imageButton7);
        logout.setOnClickListener(new LogoutController(getApplicationContext()));

//        ImageButton submit = findViewById(R.id.imageButton5);
//        submit.setOnClickListener(new CreateItemScreenController());
    }
}