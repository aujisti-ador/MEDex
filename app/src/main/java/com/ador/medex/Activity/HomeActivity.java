package com.ador.medex.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ador.medex.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void hospitalList(View view) {
        Intent intent= new Intent(HomeActivity.this,HospitalActivity.class);
        startActivity(intent);


    }

    public void drList(View view) {
        Intent intent= new Intent(HomeActivity.this,DrInfoListActivity.class);
        startActivity(intent);
    }
}
