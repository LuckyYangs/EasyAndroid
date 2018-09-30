package com.androidbigguy.easyandroiddemo.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidbigguy.easyandroiddemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class VedioFragment extends Fragment {


    public VedioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout_demo for this fragment
        return inflater.inflate(R.layout.fragment_vedio, container, false);
    }

}
