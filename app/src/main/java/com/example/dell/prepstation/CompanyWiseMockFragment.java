package com.example.dell.prepstation;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CompanyWiseMockFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CompanyWiseMockFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private int[] imageDataSet={R.drawable.ic_computer_black,R.drawable.ic_computer_black,R.drawable.ic_computer_black,R.drawable.ic_computer_black,R.drawable.ic_computer_black,R.drawable.ic_computer_black,R.drawable.ic_computer_black,R.drawable.ic_computer_black,R.drawable.ic_computer_black,R.drawable.ic_computer_black};
    private int[] noDataSet={2,2,2,2,2,2,2,2,2,2};
    private ArrayList<String> titleDataSet = new ArrayList<String>() {{ add("Cognizant"); add("TCS"); add("Capegemini");add("ITC"); add("Genpact"); add("MuSigma"); add("Bosch");add("Accenture"); add("Cisco"); add("Oracle");}};

    private RecyclerView mockRecyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public CompanyWiseMockFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CompanyWiseMockFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CompanyWiseMockFragment newInstance(String param1, String param2) {
        CompanyWiseMockFragment fragment = new CompanyWiseMockFragment();
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
        View v= inflater.inflate(R.layout.fragment_company_wise_mock, container, false);
        mockRecyclerView=v.findViewById(R.id.mockTestCompanyRecyclerView);
        setRecyclerViewer(mockRecyclerView);
        return v;
    }


    private void setRecyclerViewer(RecyclerView recyclerView) {
        recyclerView.setHasFixedSize(true);

        layoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        adapter=new MockTestCategoryAdapter(titleDataSet,imageDataSet,noDataSet);
        recyclerView.setAdapter(adapter);
    }
}
