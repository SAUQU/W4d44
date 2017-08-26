package com.example.segundoauqui.w4d44.Injection;

import com.example.segundoauqui.w4d44.view.mainactivity.MainActivity;

import dagger.Component;

/**
 * Created by segundoauqui on 8/22/17.
 */
@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {

    void inject(MainActivity mainActivity);

}
