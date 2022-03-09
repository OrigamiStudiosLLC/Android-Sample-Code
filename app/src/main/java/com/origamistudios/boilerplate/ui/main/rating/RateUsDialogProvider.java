package com.origamistudios.boilerplate.ui.main.rating;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class RateUsDialogProvider {

    @ContributesAndroidInjector
    abstract RateUsDialog provideRateUsDialogFactory();
}
