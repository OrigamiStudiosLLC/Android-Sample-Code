package com.origamistudios.boilerplate.ui.about;

import com.origamistudios.boilerplate.data.DataManager;
import com.origamistudios.boilerplate.ui.base.BaseViewModel;
import com.origamistudios.boilerplate.utils.rx.SchedulerProvider;

public class AboutViewModel extends BaseViewModel<AboutNavigator> {

    public AboutViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void onNavBackClick() {
        getNavigator().goBack();
    }
}
