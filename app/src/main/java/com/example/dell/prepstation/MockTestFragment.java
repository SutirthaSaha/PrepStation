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
 * Use the {@link MockTestFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MockTestFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TabLayout tabLayoutMock;
    private ViewPager viewPagerMock;
    private ViewPagerAdapter viewPagerAdapter;


    public MockTestFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MockTestFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MockTestFragment newInstance(String param1, String param2) {
        MockTestFragment fragment = new MockTestFragment();
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
        View v=inflater.inflate(R.layout.fragment_mock_test, container, false);
        tabLayoutMock=v.findViewById(R.id.tabLayoutMock);
        viewPagerMock=v.findViewById(R.id.viewPagerMock);

        viewPagerAdapter=new ViewPagerAdapter(getChildFragmentManager());
        viewPagerAdapter.addFragments(new WeeklyTestFragment(),"Weekly Tests");
        viewPagerAdapter.addFragments(new CompanyWiseMockFragment(),"Company Wise");
        viewPagerAdapter.addFragments(new TopicWiseMockFragment(),"Topic Wise");
        viewPagerAdapter.addFragments(new ExamWiseMockFragment(),"Exam Wise");

        viewPagerMock.setAdapter(viewPagerAdapter);
        tabLayoutMock.setupWithViewPager(viewPagerMock);
        return v;
    }

}
