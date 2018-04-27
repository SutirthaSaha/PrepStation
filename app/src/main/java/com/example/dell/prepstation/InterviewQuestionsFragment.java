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
 * Use the {@link InterviewQuestionsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InterviewQuestionsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TabLayout tabLayoutInterview;
    private ViewPager viewPagerInterview;
    private ViewPagerAdapter viewPagerAdapter;

    public InterviewQuestionsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InterviewQuestionsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InterviewQuestionsFragment newInstance(String param1, String param2) {
        InterviewQuestionsFragment fragment = new InterviewQuestionsFragment();
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
        View v=inflater.inflate(R.layout.fragment_interview_questions, container, false);
        tabLayoutInterview=v.findViewById(R.id.tabLayoutInterview);
        viewPagerInterview=v.findViewById(R.id.viewPagerInterview);

        viewPagerAdapter=new ViewPagerAdapter(getChildFragmentManager());

        viewPagerAdapter.addFragments(new InterviewQuesCompanyWiseFragment(),"Company Wise");
        viewPagerAdapter.addFragments(new InterviewQuesJobWiseFragment(),"Topic Wise");
        viewPagerAdapter.addFragments(new InterviewQuesTopicWiseFragment(),"Exam Wise");

        viewPagerInterview.setAdapter(viewPagerAdapter);
        tabLayoutInterview.setupWithViewPager(viewPagerInterview);

        return v;
    }

}
