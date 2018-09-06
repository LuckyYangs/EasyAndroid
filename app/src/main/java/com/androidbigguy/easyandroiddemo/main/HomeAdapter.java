package com.androidbigguy.easyandroiddemo.main;


import com.androidbigguy.easyandroiddemo.R;
import com.androidbigguy.easyandroid.baseadapter.BaseQuickAdapter;
import com.androidbigguy.easyandroid.baseadapter.BaseViewHolder;

import java.util.List;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class HomeAdapter extends BaseQuickAdapter<HomeItem, BaseViewHolder> {
    public HomeAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeItem item) {
        helper.setText(R.id.text, item.getTitle());
        helper.setImageResource(R.id.icon, item.getImageResource());
    }
}
