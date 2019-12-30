package com.bawei.myapplication.model;

import com.bawei.myapplication.contract.IHomeContract;
import com.bawei.myapplication.util.NetUtil;
import com.google.gson.Gson;

/*
 *@auther:张奕漫
 *@Date: 2019/12/29
 *@Time:18:59
 *@Description:
 * */
public class HomeModel implements IHomeContract.IModel {
    @Override
    public void getHome(MyModelCallBack myModelCallBack) {
        String Http = "http://blog.zhaoliang5156.cn/api/shop/fulishe1.json";
        NetUtil.getInstance().getUtilGet(Http, new NetUtil.MyCallBack() {
            @Override
            public void getJson(String json) {
                Bean bean = new Gson().fromJson(json, Bean.class);
                myModelCallBack.onSuccess(bean);
            }

            @Override
            public void onError(Throwable throwable) {
                myModelCallBack.onFailure(throwable);
            }
        });
    }
}
