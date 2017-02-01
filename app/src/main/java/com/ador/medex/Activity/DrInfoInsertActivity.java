package com.ador.medex.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ador.medex.ModelClass.DrInfo;
import com.ador.medex.Database.DrInfoManager;
import com.ador.medex.R;

public class DrInfoInsertActivity extends AppCompatActivity {
    EditText nameET;
    EditText specialityET;
    EditText phoneET;
    EditText addressET;
    Button button;

    DrInfoManager drInfoManager;
    int drId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dr_info_insert);

        nameET= (EditText) findViewById(R.id.nameET);
        specialityET= (EditText) findViewById(R.id.specialityET);
        phoneET= (EditText) findViewById(R.id.phoneET);
        addressET= (EditText) findViewById(R.id.addressET);
        button= (Button) findViewById(R.id.saveBtn);

        drInfoManager= new DrInfoManager(this);
        drId=getIntent().getIntExtra("id",0);
    }

    public void save(View view) {
        String name= nameET.getText().toString();
        String speciality= specialityET.getText().toString();
        String phone= phoneET.getText().toString();
        String address= addressET.getText().toString();

        DrInfo drInfo= new DrInfo(drId,name,speciality,phone,address);
        //long insertResult= drInfoManager.addDrInfo(drInfo); //insert

        if (name.isEmpty() || phone.isEmpty())
        {
            Toast.makeText(this,"Name & Phone is Required!!!",Toast.LENGTH_LONG).show();
        }
        else {

            drInfoManager.addDrInfo(drInfo);
            Toast.makeText(this,"Data Saved!!!",Toast.LENGTH_LONG).show();
            Intent intent= new Intent(DrInfoInsertActivity.this,DrInfoListActivity.class);
            startActivity(intent);
        }


    }
}
