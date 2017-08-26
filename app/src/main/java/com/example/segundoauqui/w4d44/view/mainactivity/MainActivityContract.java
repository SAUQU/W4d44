package com.example.segundoauqui.w4d44.view.mainactivity;

import android.app.Activity;

import com.example.segundoauqui.w4d44.BasePresenter;
import com.example.segundoauqui.w4d44.BaseView;

/**
 * Created by segundoauqui on 8/26/17.
 */

public interface MainActivityContract {

    interface View extends BaseView{
        void isPersonSaved(boolean isSaved);

    }

    interface Presenter extends BasePresenter<View>{
        void getLocation(String lat, String log);
        void getContext(Activity activity);
    }
}
