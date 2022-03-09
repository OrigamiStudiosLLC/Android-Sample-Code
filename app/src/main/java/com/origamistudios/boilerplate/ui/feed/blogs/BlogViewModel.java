package com.origamistudios.boilerplate.ui.feed.blogs;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.origamistudios.boilerplate.data.DataManager;
import com.origamistudios.boilerplate.data.model.api.BlogResponse;
import com.origamistudios.boilerplate.ui.base.BaseViewModel;
import com.origamistudios.boilerplate.utils.rx.SchedulerProvider;
import java.util.List;

public class BlogViewModel extends BaseViewModel<BlogNavigator> {

    private final MutableLiveData<List<BlogResponse.Blog>> blogListLiveData;

    public BlogViewModel(DataManager dataManager,
                         SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        blogListLiveData = new MutableLiveData<>();
        fetchBlogs();
    }

    public void fetchBlogs() {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .getBlogApiCall()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(blogResponse -> {
                    if (blogResponse != null && blogResponse.getData() != null) {
                        blogListLiveData.setValue(blogResponse.getData());
                    }
                    setIsLoading(false);
                }, throwable -> {
                    setIsLoading(false);
                    getNavigator().handleError(throwable);
                }));
    }

    public LiveData<List<BlogResponse.Blog>> getBlogListLiveData() {
        return blogListLiveData;
    }
}
