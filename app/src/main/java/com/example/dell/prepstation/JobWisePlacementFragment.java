package com.example.dell.prepstation;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link JobWisePlacementFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class JobWisePlacementFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ArrayList<String> titleDataSet = new ArrayList<String>() {{ add("Android\nDeveloper"); add("UI/UX Design"); add("Data Analyst");add("Web Developer"); }};
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;


    public JobWisePlacementFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment JobWisePlacementFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static JobWisePlacementFragment newInstance(String param1, String param2) {
        JobWisePlacementFragment fragment = new JobWisePlacementFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_job_wise_placement, container, false);
        recyclerView=v.findViewById(R.id.jobPlacementRecyclerView);
        setRecyclerViewer(recyclerView);
        return v;
    }

    private void setRecyclerViewer(RecyclerView recyclerView) {
        recyclerView.setHasFixedSize(true);

        layoutManager=new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(layoutManager);

        adapter=new JobPlacementGyanAdapter(titleDataSet);
        recyclerView.setAdapter(adapter);
    }
}
