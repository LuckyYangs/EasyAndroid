package com.androidbigguy.easyandroiddemo.custview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidbigguy.easyandroiddemo.R;
import com.androidbigguy.easyandroid.view.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class CircleImageViewFragment extends Fragment {

    View view;
    CircleImageView circleImageView1,circleImageView2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=View.inflate(getActivity(),R.layout.fragment_circleimageview, null);
        return view;
    }

}
