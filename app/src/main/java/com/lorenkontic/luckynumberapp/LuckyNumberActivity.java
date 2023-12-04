package com.lorenkontic.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class LuckyNumberActivity extends AppCompatActivity {
    TextView textViewLuckyNumber;
    Button buttonShare;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky_number);

        textViewLuckyNumber = findViewById(R.id.text_view_show_number);
        buttonShare = findViewById(R.id.button_share);

        Intent i = getIntent();
        String userName = i.getStringExtra("name");
        int randomNumber = generateRandomNumber();
        textViewLuckyNumber.setText(""+randomNumber);

        buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(userName, randomNumber);
            }
        });



    }

    public int generateRandomNumber(){
        Random random = new Random();
        int upperLimit = 1000;
        int randomNumberGenerated = random.nextInt(upperLimit);
        return  randomNumberGenerated;
    }

    public void shareData(String userName, int randomNum){

        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        //Additional information
        i.putExtra(Intent.EXTRA_SUBJECT,userName +" got lucky today");
        i.putExtra(Intent.EXTRA_TEXT, "His lucky number is: " + randomNum);
        startActivity(Intent.createChooser(i,"Choose a Platform"));
    }
}