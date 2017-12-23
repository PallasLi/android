package cn.pallasli.pmqchat.fragment;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import cn.pallasli.pmqchat.R;
import cn.pallasli.pmqchat.UserFunTabActivity;
import cn.pallasli.pmqchat.fragment.dummy.DummyContent;
import cn.pallasli.layout.NoScrollViewPager;

public class LinkmanFragment extends Fragment  {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private NoScrollViewPager mViewPager;
    private OnFragmentInteractionListener mListener;
    private LinkmanFragment.SectionsPagerAdapter mSectionsPagerAdapter;


    private Button organizationsBtn ;
    private  Button groupsBtn  ;
    private Button friendsBtn ;
    private  Button myDevicesBtn ;
    private  Button nearbyBtn ;

    int selectColor= Color.parseColor("#ffcccccc");
    int unSelectColor=Color.parseColor("#00000000");
    private void clearTabTileColor(){
        organizationsBtn.setBackgroundColor(unSelectColor);
        groupsBtn.setBackgroundColor(unSelectColor);
        friendsBtn.setBackgroundColor(unSelectColor);
        myDevicesBtn.setBackgroundColor(unSelectColor);
        nearbyBtn.setBackgroundColor(unSelectColor);
    }
    public LinkmanFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LinkmanFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LinkmanFragment newInstance(String param1, String param2) {
        LinkmanFragment fragment = new LinkmanFragment();
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
        View rootView=inflater.inflate(R.layout.fragment_linkman, container, false);

        mSectionsPagerAdapter = new LinkmanFragment.SectionsPagerAdapter(getChildFragmentManager());
        mViewPager = (NoScrollViewPager) rootView.findViewById(R.id.container2);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setNoScroll(true);


          organizationsBtn=rootView.findViewById(R.id.organizations);
          groupsBtn=rootView.findViewById(R.id.groups);
          friendsBtn=rootView.findViewById(R.id.friends);
          myDevicesBtn=rootView.findViewById(R.id.myDevices);
          nearbyBtn=rootView.findViewById(R.id.nearby);
        organizationsBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(0);
            }
        });
        groupsBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(1);
            }
        });
        friendsBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(2);
            }
        });
        myDevicesBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(3);
            }
        });
        nearbyBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(4);
            }
        });
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==0){
                    clearTabTileColor();
                    organizationsBtn.setBackgroundColor(selectColor);
                    mViewPager.setCurrentItem(0);
                }else
                if(position==1){
                    clearTabTileColor();
                    groupsBtn.setBackgroundColor(selectColor);
                    mViewPager.setCurrentItem(1);
                }else
                if(position==2){
                    clearTabTileColor();
                    friendsBtn.setBackgroundColor(selectColor);
                    mViewPager.setCurrentItem(2);
                }else
                if(position==3){
                    clearTabTileColor();
                    myDevicesBtn.setBackgroundColor(selectColor);
                    mViewPager.setCurrentItem(3);
                }else
                if(position==4){
                    clearTabTileColor();
                    nearbyBtn.setBackgroundColor(selectColor);
                    mViewPager.setCurrentItem(4);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mViewPager.setCurrentItem(0);
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }




    public class SectionsPagerAdapter extends FragmentPagerAdapter {


        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            if(position==0){
                return OrganizationsFragment.newInstance("","");
            }else
            if(position==1){
                return GroupsFragment.newInstance(1);
            }else
            if(position==2){
                return   FriendsFragment.newInstance(1);
            }else
            if(position==3){
                return MyDevicesFragment.newInstance("","");
            }else
            if(position==4){
                return NearByPeopleFragment.newInstance("","");
            }
            return null;
        }

        @Override
        public int getCount() {
            return 5;
        }


    }
}
