package com.example.dell.prepstation;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class PlacementGyanAdapter extends RecyclerView.Adapter<PlacementGyanAdapter.MyPlacementGyanHolder> {
    private ArrayList<String> titleDataSet;

    public PlacementGyanAdapter(ArrayList<String> titleDataSet) {
        this.titleDataSet = titleDataSet;
    }

    @NonNull
    @Override
    public MyPlacementGyanHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_placement_gyan,parent,false);
        PlacementGyanAdapter.MyPlacementGyanHolder holder=new MyPlacementGyanHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyPlacementGyanHolder holder, int position) {
        holder.placementGyanTitleText.setText(titleDataSet.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent companyPlacementIntent=new Intent(v.getContext(),CompanyWisePlacementActivity.class);
                companyPlacementIntent.putExtra("CompanyNamePlacementGyan",holder.placementGyanTitleText.getText().toString());
                v.getContext().startActivity(companyPlacementIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return titleDataSet.size();
    }

    public class MyPlacementGyanHolder extends RecyclerView.ViewHolder {
        public TextView placementGyanTitleText;
        public MyPlacementGyanHolder(View itemView) {
            super(itemView);
            placementGyanTitleText=itemView.findViewById(R.id.placementGyanTitleText);
        }
    }
}
