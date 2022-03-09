package com.origamistudios.boilerplate.di.component;

import android.app.Application;

import com.origamistudios.boilerplate.MvvmApp;
import com.origamistudios.boilerplate.di.builder.ActivityBuilder;
import com.origamistudios.boilerplate.di.module.AppModule;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

import javax.inject.Singleton;

@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class})
public interface AppComponent {

    void inject(MvvmApp app);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
