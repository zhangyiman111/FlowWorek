package com.bawei.myapplication.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.bawei.myapplication.R;
import com.bawei.myapplication.base.BaseActivity;
import com.bawei.myapplication.contract.IHomeContract;
import com.bawei.myapplication.model.Bean;
import com.bawei.myapplication.presenter.HomePresenter;

import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<HomePresenter> implements IHomeContract.IView {


    private RecyclerView recyclerView;

    @Override
    protected void initData() {
        mPresenter.getHome();
    }

    @Override
    protected void initView() {
        recyclerView = findViewById(R.id.rl);
    }

    @Override
    protected HomePresenter ProviderPresenter() {
        return new HomePresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(Bean bean) {
        List<Bean.DataBean> data = bean.getData();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        MyAdapter myAdapter = new MyAdapter(data);
        recyclerView.setAdapter(myAdapter);
        myAdapter.setOnClickItemListeren(new MyAdapter.onClickItemListeren() {
            @Override
            public void onClickItem(int i) {
                Intent intent = new Intent(MainActivity.this,SeacondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onFailure(Throwable throwable) {
        Toast.makeText(this, "11111", Toast.LENGTH_SHORT).show();
    }


}
