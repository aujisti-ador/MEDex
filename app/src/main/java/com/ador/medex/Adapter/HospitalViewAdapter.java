package com.ador.medex.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ador.medex.ModelClass.Hospital;
import com.ador.medex.R;

import java.util.ArrayList;

/**
 * Created by DORBESH on 12/27/2016.
 */

public class HospitalViewAdapter extends RecyclerView.Adapter<HospitalViewAdapter.RecyclerViewHolder>{

    ArrayList<Hospital> arrayList = new ArrayList<>();
    Context ctx;
    public HospitalViewAdapter(ArrayList<Hospital> arrayList, Context ctx){
        this.arrayList = arrayList;
        this.ctx = ctx;

    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_row_layout,parent,false);
        return new RecyclerViewHolder(view,ctx,arrayList);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        holder.h_status.setText(arrayList.get(position).getH_status());
        holder.h_phone.setText(arrayList.get(position).getH_phone());
        holder.h_open.setText(arrayList.get(position).getH_open());
        holder.h_name.setText(arrayList.get(position).getH_name());
        holder.h_img.setImageResource(arrayList.get(position).getH__img());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public static  class RecyclerViewHolder extends RecyclerView.ViewHolder{

        TextView h_name,h_phone,h_status,h_open;
        ImageView h_img;
        ArrayList<Hospital> arrayList;
        CardView cardView;
        Context context;
        public RecyclerViewHolder(View v, final Context context, final ArrayList<Hospital> arrayList) {
            super(v);
            h_img = (ImageView)v.findViewById(R.id.img_id);
            h_name = (TextView)v.findViewById(R.id.name);
            h_open = (TextView)v.findViewById(R.id.open);
            h_phone = (TextView)v.findViewById(R.id.phone);
            h_status = (TextView)v.findViewById(R.id.status);
            this.context = context;
            this.arrayList = arrayList;
            cardView = (CardView) v.findViewById(R.id.cardview);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,"Name:"+arrayList.get(getAdapterPosition()).getH_name()
                                            +"\nPhone:"+arrayList.get(getAdapterPosition()).getH_phone()+
                                            "\nPrivate/public:"+arrayList.get(getAdapterPosition()).getH_status()
                            , Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
