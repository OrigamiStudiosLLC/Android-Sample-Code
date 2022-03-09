package com.origamistudios.boilerplate.ui.feed;

import dagger.Module;
import dagger.Provides;

@Module
public class FeedActivityModule {

    @Provides
    FeedPagerAdapter provideFeedPagerAdapter(FeedActivity activity) {
        return new FeedPagerAdapter(activity.getSupportFragmentManager());
    }

}
