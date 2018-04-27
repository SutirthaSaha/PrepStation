package com.example.dell.prepstation;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PlacementFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlacementFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TabLayout tabLayoutPlacement;
    private ViewPager viewPagerPlacement;
    private ViewPagerAdapter viewPagerAdapter;

    public PlacementFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PlacementFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PlacementFragment newInstance(String param1, String param2) {
        PlacementFragment fragment = new PlacementFragment();
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
        View v= inflater.inflate(R.layout.fragment_placement, container, false);
        tabLayoutPlacement=v.findViewById(R.id.tabLayoutPlacement);
        viewPagerPlacement=v.findViewById(R.id.viewPagerPlacement);

        viewPagerAdapter=new ViewPagerAdapter(getChildFragmentManager());
        viewPagerAdapter.addFragments(new CompanyWisePlacementFragment(),"Company Wise");
        viewPagerAdapter.addFragments(new JobWisePlacementFragment(),"Job Wise");

        viewPagerPlacement.setAdapter(viewPagerAdapter);
        tabLayoutPlacement.setupWithViewPager(viewPagerPlacement);
        return v;
    }

}
