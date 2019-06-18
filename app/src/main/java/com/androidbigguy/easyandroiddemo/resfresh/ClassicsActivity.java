package com.androidbigguy.easyandroiddemo.resfresh;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.androidbigguy.easyandroid.baseadapter.BaseQuickAdapter;
import com.androidbigguy.easyandroid.refreshlayout.layout.EasyRefreshLayout;
import com.androidbigguy.easyandroid.refreshlayout.layout.api.RefreshLayout;
import com.androidbigguy.easyandroid.refreshlayout.layout.listener.OnLoadMoreListener;
import com.androidbigguy.easyandroid.refreshlayout.layout.listener.OnRefreshListener;
import com.androidbigguy.easyandroid.utils.ActivityUtil;
import com.androidbigguy.easyandroid.utils.ToastUtil;
import com.androidbigguy.easyandroiddemo.BaseActivity;
import com.androidbigguy.easyandroiddemo.R;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ClassicsActivity extends BaseActivity {
    ShimmerRecyclerView lv;
    TextView tilte;
    Toolbar toolbar;
    BaseresfresAdapter adapter;
    private EasyRefreshLayout refreshLayout;
    List<StringEntity> data =new ArrayList();

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_classics);
    }

    @Override
    protected void initView() {
        toolbar =findViewById(R.id.toolbara);
        tilte=findViewById(R.id.title);
        lv=findViewById(R.id.shimmer_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        lv.setLayoutManager(layoutManager);
        lv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        tilte.setText("经典模式");
        refreshLayout=findViewById(R.id.refreshLayout);
        refreshLayout.setEnableFooterFollowWhenLoadFinished(true);
        refreshLayout.setEnableAutoLoadMore(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtil.startAty(getApplicationContext(),ResFreshActivity.class);
                finish();
            }
        });

        adapter=new BaseresfresAdapter(this,R.layout.item,data);
        //        设置加载动画
        adapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
//        动画只第一次加载
        adapter.isFirstOnly(true);
        lv.setAdapter(adapter);
        lv.showShimmerAdapter();
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtil.show(getApplicationContext(),"This is "+position+"数据");
            }
        });
    }

    @Override
    protected void initData() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                /**
                 * 延时执行的代码
                 */
                intdata();
            }
        },3000); // 延时1秒


        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                if(data.size()<20) {
                    adddata();
                    adapter.notifyDataSetChanged();
                    refreshLayout.finishLoadMore();
                }else {
                    refreshLayout.finishLoadMore();
                    refreshLayout.finishLoadMoreWithNoMoreData();
                    refreshLayout.setNoMoreData(true);
                }
            }
        });
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.setNoMoreData(false);
                intdata();
                adapter.notifyDataSetChanged();
                refreshLayout.finishRefresh();
            }
        });
    }

    @Override
    public void onClick(View v) {

    }


    private  void adddata() {
        for (int j=0;j<5;j++){
            StringEntity stringEntity=new StringEntity();
            stringEntity.setContent("第"+j+"条数据");
            data.add(stringEntity);
        }
    }
    private  void intdata() {
        data.clear();
        for (int i=0;i<15;i++){
            StringEntity stringEntity=new StringEntity();
            stringEntity.setContent("第"+i+"条数据");
            data.add(stringEntity);
        }
        lv.hideShimmerAdapter();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ActivityUtil.startAty(this,ResFreshActivity.class);
        finish();
    }
}
