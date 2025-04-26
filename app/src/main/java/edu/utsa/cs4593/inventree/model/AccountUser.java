package edu.utsa.cs4593.inventree.model;

import java.util.ArrayList;

public class AccountUser {
        String userName;
        String password;
        String firstName;
        String lastName;
        String employeeID;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public AccountUser(String userName, String password, String firstName, String lastName, String employeeID){
            this.firstName = firstName;
            this.lastName = lastName;
            this.employeeID = employeeID;
            this.userName = userName;
            this.password = password;
        }

        public String toString() {
            String returnString="";

            return returnString;
        }
    }
