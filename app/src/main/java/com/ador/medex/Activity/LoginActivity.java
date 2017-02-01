package com.ador.medex.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ador.medex.R;

public class LoginActivity extends AppCompatActivity {
    EditText pinET;
    Button enterBtn;

    //This is my login page


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        pinET= (EditText) findViewById(R.id.pinET);
        enterBtn= (Button) findViewById(R.id.enterBtn);
    }

    public void enter(View view) {
        if (pinET.getText().toString().equals("12345"))
        {
            Toast.makeText(getApplicationContext(),"Pin Is Correct!!!",Toast.LENGTH_LONG).show();
            Intent intent= new Intent(LoginActivity.this,HomeActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(getApplicationContext(),"Pin Is Incorrect!!!,Try Again",Toast.LENGTH_LONG).show();
        }
    }

}
