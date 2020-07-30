package com.example.numbershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number {

        int number;

        public boolean isSquared(){

            double squareRoot = Math.sqrt(number);

            if(squareRoot == Math.floor(squareRoot)){
                return true;
            }else{
                return false;
            }

        }

        public boolean isTriangled(){
            int x = 1;
            int triangularNumber = 1;

            while(triangularNumber < number){
                x++;

                triangularNumber = triangularNumber + x;
            }

            if(triangularNumber == number){
                return true;
            }else{
                return false;
            }

        }
    }

    public void checkNumber(View view) {
        EditText usersNumber = (EditText) findViewById(R.id.userNumber);

        String message = "";

        if (usersNumber.getText().toString().isEmpty()) {
            message = "Please enter number";
        } else {

            Number myNumber = new Number();

            myNumber.number = Integer.parseInt(usersNumber.getText().toString());


            if (myNumber.isSquared()) {
                if (myNumber.isTriangled()) {
                    message = myNumber.number + " is both triangular and square";
                } else {
                    message = myNumber.number + " is square, but not triangular";
                }
            } else {
                if (myNumber.isTriangled()) {
                    message = myNumber.number + " is triangular, but not square";
                } else {
                    message = myNumber.number + " is neither triangular or square";
                }
            }
        }
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}