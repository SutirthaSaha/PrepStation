package com.example.dell.prepstation;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MockTestCategoryAdapter extends RecyclerView.Adapter<MockTestCategoryAdapter.MyTestHolder> {
    private ArrayList<String> titleDataSet;
    private int[] imageDataSet,numberDataSet;

    public MockTestCategoryAdapter(ArrayList<String> titleDataSet, int[] imageDataSet, int[] numberDataSet) {
        this.titleDataSet = titleDataSet;
        this.imageDataSet = imageDataSet;
        this.numberDataSet = numberDataSet;
    }

    @NonNull
    @Override
    public MyTestHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_mock_test_category,parent,false);
        MyTestHolder holder=new MyTestHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyTestHolder holder, int position) {
        holder.testTitle.setText(titleDataSet.get(position));
        holder.testNumber.setText(holder.testNumber.getText()+Integer.toString(numberDataSet[position]));
        holder.testImage.setImageResource(imageDataSet[position]);

    }

    @Override
    public int getItemCount() {
        return titleDataSet.size();
    }

    public class MyTestHolder extends RecyclerView.ViewHolder{

        public TextView testTitle,testNumber;
        public ImageView testImage;
        public MyTestHolder(View itemView) {
            super(itemView);
            testTitle=itemView.findViewById(R.id.testCatCardTitle);
            testImage=itemView.findViewById(R.id.testCatCardImage);
            testNumber=itemView.findViewById(R.id.testCatCardNumber);
        }
    }
}
