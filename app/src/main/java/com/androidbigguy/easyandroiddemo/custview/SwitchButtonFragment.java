package com.androidbigguy.easyandroiddemo.custview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidbigguy.easyandroiddemo.R;
import com.androidbigguy.easyandroid.view.SwitchButton;

/**
 * A simple {@link Fragment} subclass.
 */
public class SwitchButtonFragment extends Fragment {


    View view;
    SwitchButton switchButton1,switchButton2,switchButton3;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=View.inflate(getActivity(),R.layout.fragment_switchbutton, null);
        return view;
    }

}
