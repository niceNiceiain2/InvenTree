//package edu.utsa.cs4593.inventree;
//
//import android.os.Bundle;
//import android.widget.ImageButton;
//import android.widget.TableLayout;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import edu.utsa.cs4593.inventree.controller.LogoutController;
//import edu.utsa.cs4593.inventree.controller.SearchItemScreenController;
//
///*
// * Iain Summerlin - tea587
// *
// *
// */
//public class EmployeeHomepage extends AppCompatActivity {
//
//    TableLayout tableLayout;
//    public static int itemSelected;
//
//    @Override
//    /*
//     * Sets the OnCreate method and takes in the bundle and saved Instance state.
//     * OnCreate function makes all the avengers in a button and returns the setOnClicker.
//     */
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.employeehomepage);
//
//        String username = getIntent().getStringExtra("username");
//        TextView un = findViewById(R.id.textView38);
//        un.setTextSize(20);
//        un.setText(username);
//
//        ImageButton search = findViewById(R.id.searchButton);
//        search.setOnClickListener(new SearchItemScreenController(getApplicationContext()));
//
//        ImageButton logout = findViewById(R.id.imageButton8);
//        logout.setOnClickListener(new LogoutController(getApplicationContext()));
//
//    }
//}