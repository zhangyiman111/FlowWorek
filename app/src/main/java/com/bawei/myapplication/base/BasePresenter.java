package com.bawei.myapplication.base;

/*
 *@auther:张奕漫
 *@Date: 2019/12/29
 *@Time:18:59
 *@Description:
 * */
public abstract class BasePresenter<V> {
    protected V view;

    public void attach(V view) {
        this.view = view;
    }

    public void detach(){
        view = null;
    }

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();
}
