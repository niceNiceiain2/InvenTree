package edu.utsa.cs4593.inventree;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

/*
 * Iain Summerlin - tea587
 *
 *
 */
public class MainPageActivity extends AppCompatActivity {

    TableLayout tableLayout;
    public static int itemSelected;

    @Override
    /*
     * Sets the OnCreate method and takes in the bundle and saved Instance state.
     * OnCreate function makes all the avengers in a button and returns the setOnClicker.
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employeehomepage);



    }
}