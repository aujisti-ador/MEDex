package com.ador.medex.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ador.medex.Adapter.DrInfoAdapter;
import com.ador.medex.Database.DrInfoManager;
import com.ador.medex.ModelClass.DrInfo;
import com.ador.medex.R;

import java.util.ArrayList;

public class DrInfoListActivity extends AppCompatActivity {
    ListView drInfoLV;
    DrInfoAdapter drInfoAdapter;
    DrInfoManager drInfoManager;
    ArrayList<DrInfo>drInfos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dr_info_list);

        drInfoLV= (ListView) findViewById(R.id.drInfoLV);
        drInfoManager= new DrInfoManager(this);
        drInfos= drInfoManager.getAllDrInfo();
        drInfoAdapter= new DrInfoAdapter(this,drInfos);
        drInfoLV.setAdapter(drInfoAdapter);

        drInfoLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int drId= drInfos.get(position).getId();
                Intent intent= new Intent(DrInfoListActivity.this,DrInfoUpdateDltActivity.class);
                intent.putExtra("id",drId);
                startActivity(intent);

            }
        });

    }

    public void moveToInsertPage(View view) {
        Intent intent= new Intent(DrInfoListActivity.this,DrInfoInsertActivity.class);
        startActivity(intent);
    }

    public void home(View view) {
        Intent intent= new Intent(DrInfoListActivity.this,HomeActivity.class);
        startActivity(intent);
    }
}
