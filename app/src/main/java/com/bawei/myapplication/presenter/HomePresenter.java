package com.bawei.myapplication.presenter;

import com.bawei.myapplication.base.BasePresenter;
import com.bawei.myapplication.contract.IHomeContract;
import com.bawei.myapplication.model.Bean;
import com.bawei.myapplication.model.HomeModel;

/*
 *@auther:张奕漫
 *@Date: 2019/12/29
 *@Time:18:59
 *@Description:
 * */
public class HomePresenter extends BasePresenter<IHomeContract.IView>implements IHomeContract.IPresenter {

    private HomeModel homeModel;

    @Override
    protected void initModel() {
        homeModel = new HomeModel();
    }

    @Override
    public void getHome() {
        homeModel.getHome(new IHomeContract.IModel.MyModelCallBack() {
            @Override
            public void onSuccess(Bean bean) {
                view.onSuccess(bean);
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.onFailure(throwable);
            }
        });
    }
}
