package com.example.dell.prepstation;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class CourseAdpater extends RecyclerView.Adapter<CourseAdpater.MyHolder> {
    private ArrayList<String> titleDataSet;
    private int[] imageDataSet,lecnoDataSet;

    public CourseAdpater(ArrayList<String> titleDataSet, int[] imageDataSet, int[] lecnoDataSet) {
        this.titleDataSet = titleDataSet;
        this.imageDataSet = imageDataSet;
        this.lecnoDataSet = lecnoDataSet;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_course,parent,false);
        MyHolder holder=new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.title.setText(titleDataSet.get(position));
        holder.lecno.setText(Integer.toString(lecnoDataSet[position]));
        holder.image.setImageResource(imageDataSet[position]);

    }

    @Override
    public int getItemCount() {
        return titleDataSet.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{

        public TextView title,lecno;
        public ImageView image;
        public MyHolder(View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.courseCardTitle);
            image=itemView.findViewById(R.id.courseCardImage);
            lecno=itemView.findViewById(R.id.courseCardVideoNumber);
        }
    }
}
