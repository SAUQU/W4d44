package com.example.segundoauqui.w4d44.Injection;

import com.example.segundoauqui.w4d44.view.mainactivity.MainActivityPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by segundoauqui on 8/22/17.
 */
@Module
public class MainActivityModule {

    @Provides
    MainActivityPresenter providerMainActivityPresenter(){return new MainActivityPresenter();}
}
