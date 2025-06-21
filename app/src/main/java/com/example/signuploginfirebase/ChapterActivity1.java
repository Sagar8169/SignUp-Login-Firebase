package com.example.signuploginfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ChapterActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter1);

        // Find the button by its ID
        Button chap1sub1Button = findViewById(R.id.chap1sub1);
        Button chap1sub2Button = findViewById(R.id.chap1sub2);
        Button chap1sub3Button = findViewById(R.id.chap1sub3);// New button
        Button chap1sub4Button = findViewById(R.id.chap1sub4);
        Button chap1sub5Button = findViewById(R.id.chap1sub5);
        Button chap1sub6Button = findViewById(R.id.chap1sub6);
        Button chap1sub7Button = findViewById(R.id.chap1sub7);
        Button chap1sub8Button = findViewById(R.id.chap1sub8);
        Button chap1sub9Button = findViewById(R.id.chap1sub9);
        Button chap1sub10Button = findViewById(R.id.chap1sub10);
        Button chap1sub11Button = findViewById(R.id.chap1sub11);
        Button chap1sub12Button = findViewById(R.id.chap1sub12);
        Button chap1sub13Button = findViewById(R.id.chap1sub13);
        Button chap1sub14Button = findViewById(R.id.chap1sub14);
        Button chap1sub15Button = findViewById(R.id.chap1sub15);
        Button chap1sub16Button = findViewById(R.id.chap1sub16);
        Button chap1sub17Button = findViewById(R.id.chap1sub17);
        Button chap1sub18Button = findViewById(R.id.chap1sub18);
        Button chap1sub19Button = findViewById(R.id.chap1sub19);
        Button chap1sub20Button = findViewById(R.id.chap1sub20);
        Button chap1sub21Button = findViewById(R.id.chap1sub21);
        Button chap1sub22Button = findViewById(R.id.chap1sub22);
        Button chap1sub23Button = findViewById(R.id.chap1sub23);
        Button chap1sub24Button = findViewById(R.id.chap1sub24);
        Button chap1sub25Button = findViewById(R.id.chap1sub25);
        Button chap1sub26Button = findViewById(R.id.chap1sub26);
        Button chap1sub27Button = findViewById(R.id.chap1sub27);
        Button chap1sub28Button = findViewById(R.id.chap1sub28);
        Button chap1sub29Button = findViewById(R.id.chap1sub29);
        Button chap1sub30Button = findViewById(R.id.chap1sub30);
        Button chap1sub31Button = findViewById(R.id.chap1sub31);
        Button chap1sub32Button = findViewById(R.id.chap1sub32);
        Button chap1sub33Button = findViewById(R.id.chap1sub33);
        Button chap1sub34Button = findViewById(R.id.chap1sub34);







        // Set an OnClickListener on the first button
        chap1sub1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to Sub1Chap1 activity
                Intent intent = new Intent(ChapterActivity1.this, Sub1Chap1.class);
                startActivity(intent);
            }
        });

        // Set an OnClickListener on the second button
        chap1sub2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to Sub1Chap2 activity
                Intent intent = new Intent(ChapterActivity1.this, Sub1Chap2.class);
                startActivity(intent);
            }
        });

        chap1sub3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to Sub1Chap1 activity
                Intent intent = new Intent(ChapterActivity1.this, Sub1Chap3.class);
                startActivity(intent);
            }
        });

        chap1sub4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to Sub1Chap1 activity
                Intent intent = new Intent(ChapterActivity1.this, Sub1Chap4.class);
                startActivity(intent);
            }
        });

        chap1sub5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to Sub1Chap1 activity
                Intent intent = new Intent(ChapterActivity1.this, Sub1Chap5.class);
                startActivity(intent);
            }
        });


    }
}


