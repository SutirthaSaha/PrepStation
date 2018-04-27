package com.example.dell.prepstation;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class JobPlacementGyanAdapter extends RecyclerView.Adapter<JobPlacementGyanAdapter.MyJobPlacementGyanHolder> {
    private ArrayList<String> titleDataSet;

    public JobPlacementGyanAdapter(ArrayList<String> titleDataSet) {
        this.titleDataSet = titleDataSet;
    }

    @NonNull
    @Override
    public MyJobPlacementGyanHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_placement_gyan,parent,false);
        JobPlacementGyanAdapter.MyJobPlacementGyanHolder holder=new JobPlacementGyanAdapter.MyJobPlacementGyanHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyJobPlacementGyanHolder holder, int position) {
        holder.jobPlacementGyanTitleText.setText(titleDataSet.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jobPlacementIntent=new Intent(v.getContext(),JobWisePlacementActivity.class);
                jobPlacementIntent.putExtra("JobNamePlacementGyan",holder.jobPlacementGyanTitleText.getText().toString());
                v.getContext().startActivity(jobPlacementIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return titleDataSet.size();
    }


    public class MyJobPlacementGyanHolder extends RecyclerView.ViewHolder{
        public TextView jobPlacementGyanTitleText;
        public MyJobPlacementGyanHolder(View itemView) {
            super(itemView);
            jobPlacementGyanTitleText=itemView.findViewById(R.id.placementGyanTitleText);
        }
    }
}
