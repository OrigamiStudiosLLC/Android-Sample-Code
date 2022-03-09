package com.origamistudios.boilerplate.di.builder;

import com.origamistudios.boilerplate.ui.about.AboutFragmentProvider;
import com.origamistudios.boilerplate.ui.feed.FeedActivity;
import com.origamistudios.boilerplate.ui.feed.FeedActivityModule;
import com.origamistudios.boilerplate.ui.feed.blogs.BlogFragmentProvider;
import com.origamistudios.boilerplate.ui.feed.opensource.OpenSourceFragmentProvider;
import com.origamistudios.boilerplate.ui.login.LoginActivity;
import com.origamistudios.boilerplate.ui.main.MainActivity;
import com.origamistudios.boilerplate.ui.main.rating.RateUsDialogProvider;
import com.origamistudios.boilerplate.ui.splash.SplashActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {
            FeedActivityModule.class,
            BlogFragmentProvider.class,
            OpenSourceFragmentProvider.class})
    abstract FeedActivity bindFeedActivity();

    @ContributesAndroidInjector
    abstract LoginActivity bindLoginActivity();

    @ContributesAndroidInjector(modules = {
            AboutFragmentProvider.class,
            RateUsDialogProvider.class})
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector
    abstract SplashActivity bindSplashActivity();
}
