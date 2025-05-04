//package edu.utsa.cs4593.inventree.controller;
//
//import android.content.Context;
//import android.content.Intent;
//import android.view.View;
//
//import edu.utsa.cs4593.inventree.CreateActivity;
//
//public class CreateItemScreenController implements View.OnClickListener {
//
//        /*
//         * Sets the OnClick method and takes in the view.
//         * OnClick function makes all the avengers in a view.
//         */
//        @Override
//        public void onClick(View view) {
//            Context s = view.getContext();
//            //String itemName = CreateActivity.itemName.getText().toString();
//            //String quantity = CreateActivity.quantity.getText().toString();
//
//            /*
//             * Sets the context and gets the Context.
//             * CharSequence has av.toString as all the avengers in a button and returns the duration.
//             */
//            Context context = view.getContext();
//
//            Intent intent = new Intent(context, CreateActivity.class);
//            context.startActivity(intent);
//        }
//}