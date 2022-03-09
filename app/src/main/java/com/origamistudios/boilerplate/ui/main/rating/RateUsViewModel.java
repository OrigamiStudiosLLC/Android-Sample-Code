package com.origamistudios.boilerplate.ui.main.rating;

import com.origamistudios.boilerplate.data.DataManager;
import com.origamistudios.boilerplate.ui.base.BaseViewModel;
import com.origamistudios.boilerplate.utils.rx.SchedulerProvider;

public class RateUsViewModel extends BaseViewModel<RateUsCallback> {

    public RateUsViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void onLaterClick() {
        getNavigator().dismissDialog();
    }

    public void onSubmitClick() {
        getNavigator().dismissDialog();
    }
}
