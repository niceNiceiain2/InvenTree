package edu.utsa.cs4593.inventree.model;

import android.content.Context;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
public class UserDatabase {
    private static List<User> users = new ArrayList<>();

    public static void loadUsers(Context context){
        try{
            InputStream input = context.getAssets().open("user_database.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            String line;
            while((line = reader.readLine()) != null){
                String[] fields = line.split(",");
                if(fields.length >= 7){
                    users.add(new User(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5], fields[6]));
                }
            }
            reader.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static boolean isValidUser(String username, String password){
        for (User user: users){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public static String getRole(String username){
        for(User user: users){
            if(user.getUsername().equals(username)){
                return user.getRole();
            }
        }
        return null;
    }

//    public static User findUser(String username, String password){
//        for(User user: users){
//            if(user.getUsername().trim().equals(username) && user.getPassword().trim().equals(password)){
//                return user;
//            }
//        }
//        return null;
//    }
}
