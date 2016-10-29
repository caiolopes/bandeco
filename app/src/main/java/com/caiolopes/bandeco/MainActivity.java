package com.caiolopes.bandeco;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openMenuCampus1(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("CAMPUS", 1);
        startActivity(intent);
    }

    public void openMenuCampus2(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("CAMPUS", 2);
        startActivity(intent);
    }
}
