package com.origamistudios.boilerplate.ui.feed;

import com.origamistudios.boilerplate.data.DataManager;
import com.origamistudios.boilerplate.ui.base.BaseViewModel;
import com.origamistudios.boilerplate.utils.rx.SchedulerProvider;

public class FeedViewModel extends BaseViewModel {

    public FeedViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
}
