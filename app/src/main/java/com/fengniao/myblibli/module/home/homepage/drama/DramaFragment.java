package com.fengniao.myblibli.module.home.homepage.drama;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fengniao.myblibli.R;

/**
 * 追番
 * A simple {@link Fragment} subclass.
 */
public class DramaFragment extends Fragment {

    public static DramaFragment newInstance() {

        Bundle args = new Bundle();

        DramaFragment fragment = new DramaFragment();
        fragment.setArguments(args);
        return fragment;
    }


    public DramaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_drama, container, false);
    }

}
