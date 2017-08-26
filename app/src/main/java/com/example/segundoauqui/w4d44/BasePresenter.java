package com.example.segundoauqui.w4d44;

/**
 * Created by segundoauqui on 8/22/17.
 */

public interface BasePresenter <V extends BaseView> {

    void attachView(V view);
    void removeView();

}

