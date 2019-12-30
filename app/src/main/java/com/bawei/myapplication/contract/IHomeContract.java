package com.bawei.myapplication.contract;

import com.bawei.myapplication.model.Bean;

/*
 *@auther:张奕漫
 *@Date: 2019/12/29
 *@Time:18:59
 *@Description:
 * */
public interface IHomeContract {
    interface IView{
        void onSuccess(Bean bean);
        void onFailure(Throwable throwable);
    }

    interface IPresenter{
        void getHome();
    }

    interface IModel{
        void getHome(MyModelCallBack myModelCallBack);
        interface MyModelCallBack{
            void onSuccess(Bean bean);
            void onFailure(Throwable throwable);
        }
    }


}
