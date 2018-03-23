package com.kokoroguruma.musicsitefragmenthotta;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kokoroguruma.musicsitefragmenthotta.listPlayCenterList.ListPlayCenterListAdapter;

// TODO: ViewPagerの実装

/**
 * ログイン後のデフォルト表示画面
 * ここでは
 * 上部にPlayPlayingViewFragmentと
 * それ以下にViewPagerで
 * 　PlayCenterPlaying、PlayLeftDLList、PlayRightCommentListを表示。
 * 　デフォルトはPlayCenterPlaying
 * A simple {@link Fragment} subclass.
 */
public class PlayFragment extends Fragment {

    MyApplication application;

    public PlayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        application = (MyApplication) getActivity().getApplication();

        application.getMainActivity().setMenuVisibllityFlag(true);
        application.getMainActivity().invalidateOptionsMenu();


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_play, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {


        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public void onResume() {
        Log.d("PlayFragment: ","onResume()");
        this.setFragmentsInViewPager();
        super.onResume();
    }

    // ここからViewPager
    private void setFragmentsInViewPager() {
        Log.d("PlayFragment: ","setFragmentsInViewPager(): ");
        ViewPager viewPager = getActivity().findViewById(R.id.playViewPager);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        PlayFragmentPagerAdapter adapter = new PlayFragmentPagerAdapter(fragmentManager);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(1);
        Log.d("PlayFragment: ","setFragmentsInViewPager(): "+ viewPager.getAdapter());
    }

    private void updateFragmentInViewPager() {
        ViewPager viewPager = getActivity().findViewById(R.id.playViewPager);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        PlayFragmentPagerAdapter adapter = new PlayFragmentPagerAdapter(fragmentManager);
        adapter.notifyDataSetChanged();
    }


    // 更新対策にStateを利用。これを使うことで毎回新規作成する？
    // FragmentPagerAdapter → FragmentStatePagerAdapter
    private class PlayFragmentPagerAdapter extends FragmentStatePagerAdapter {
        public PlayFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Log.d("PlayFragment: ","PagerAdapter: getItem: " + position);
            Fragment fragment = null;
            switch (position) {
                case 0:
                    fragment = new PlayLeftDLListFragment();
                    break;
                case 2:
                    fragment = new PlayRightCommentListFragment();
                    break;
                case 1:
                default:
                    fragment = new PlayCenterPlayingListFragment();
            }

            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }




}
