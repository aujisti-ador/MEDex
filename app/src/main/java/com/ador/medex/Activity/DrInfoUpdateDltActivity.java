package com.ador.medex.Activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ador.medex.Database.DrInfoManager;
import com.ador.medex.ModelClass.DrInfo;
import com.ador.medex.R;

public class DrInfoUpdateDltActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_dr_info_update_dlt);

        nameET= (EditText) findViewById(R.id.nameET);
        specialityET= (EditText) findViewById(R.id.specialityET);
        phoneET= (EditText) findViewById(R.id.phoneET);
        addressET= (EditText) findViewById(R.id.addressET);
        button= (Button) findViewById(R.id.updateBtn);

        drInfoManager= new DrInfoManager(this);
        drId=getIntent().getIntExtra("id",0);

        DrInfo drInfo = drInfoManager.getDrInfoById(drId);
        nameET.setText(drInfo.getDrName());
        specialityET.setText(drInfo.getDrSpeciality());
        phoneET.setText(drInfo.getDrPhoneNumber());
        addressET.setText(drInfo.getDrAddress());

    }

    public void updateInfo(View view) {
        String name= nameET.getText().toString();
        String speciality= specialityET.getText().toString();
        String phone= phoneET.getText().toString();
        String address= addressET.getText().toString();

        DrInfo drInfo= new DrInfo(drId,name,speciality,phone,address);

        long insertResult= drInfoManager.updateDrInfo(drInfo); //update

        if (insertResult>0)
        {
            Toast.makeText(this,"Info Updated!!!",Toast.LENGTH_LONG).show();
        }
        Intent intent= new Intent(DrInfoUpdateDltActivity.this,DrInfoListActivity.class);
        startActivity(intent);

    }

    public void deleteInfo(View view) {
        String name= nameET.getText().toString();
        String speciality= specialityET.getText().toString();
        String phone= phoneET.getText().toString();
        String address= addressET.getText().toString();

        DrInfo drInfo= new DrInfo(drId,name,speciality,phone,address);

        long insertResult= drInfoManager.deleteInfo(drInfo); //delete

        if (insertResult>0)
        {
            Toast.makeText(this,"Info Deleted!!!",Toast.LENGTH_LONG).show();
        }

        Intent intent= new Intent(DrInfoUpdateDltActivity.this,DrInfoListActivity.class);
        startActivity(intent);

    }

    public void call(View view) {

        String tPhone =phoneET.getText().toString();

        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + tPhone));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(callIntent);

    }
}
