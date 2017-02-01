package com.ador.medex.Adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ador.medex.ModelClass.DrInfo;
import com.ador.medex.R;

import java.util.ArrayList;
import java.util.List;

public class DrInfoAdapter extends ArrayAdapter<DrInfo> {

    ArrayList<DrInfo>drInfos;
    Context context;

    public DrInfoAdapter(Context context, ArrayList<DrInfo> drInfos) {
        super(context, R.layout.doctorlist_layout, drInfos);
        this.context=context;
        this.drInfos=drInfos;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DrInfo drInfo= drInfos.get(position);
        convertView= LayoutInflater.from(context).inflate(R.layout.doctorlist_layout,parent,false);

        TextView nameText= (TextView) convertView.findViewById(R.id.nameTV);
        TextView specialistText= (TextView) convertView.findViewById(R.id.specialityTV);
        TextView phoneText= (TextView) convertView.findViewById(R.id.phoneTV);
        TextView addressText= (TextView) convertView.findViewById(R.id.addressTV);

        nameText.setText(drInfo.getDrName());
        specialistText.setText(drInfo.getDrSpeciality());
        phoneText.setText(drInfo.getDrPhoneNumber());
        addressText.setText(drInfo.getDrAddress());

        return convertView;
    }
}
