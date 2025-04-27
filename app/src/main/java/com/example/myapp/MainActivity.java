package com.example.myapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnWebsite, btnCall, btnMap, btnShare, btnViewApp;
    GridLayout gridLayout;
    TextView welcomeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWebsite = findViewById(R.id.btnWebsite);
        btnCall = findViewById(R.id.btnCall);
        btnMap = findViewById(R.id.btnMap);
        btnShare = findViewById(R.id.btnShare);
        btnViewApp = findViewById(R.id.btnViewApp);
        gridLayout = findViewById(R.id.gridLayout);
        welcomeText = findViewById(R.id.welcomeText);

        // Initially hide the GridLayout and show welcome text + view button
        gridLayout.setVisibility(View.GONE);

        btnViewApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                welcomeText.setVisibility(View.GONE);
                btnViewApp.setVisibility(View.GONE);
                gridLayout.setVisibility(View.VISIBLE);
            }
        });

        // Open Website
        btnWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW);
                websiteIntent.setData(Uri.parse("https://www.google.com"));
                startActivity(websiteIntent);
            }
        });

        // Make a Phone Call
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:1234567890"));
                startActivity(callIntent);
            }
        });

        // Open Location in Map
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri location = Uri.parse("geo:28.6139,77.2090?q=New+Delhi");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

        // Share Text
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Sharing via Grid App");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey! Check out this awesome app I made.");
                startActivity(Intent.createChooser(shareIntent, "Share via"));
            }
        });
    }
}
