package com.origamistudios.boilerplate.ui.feed.blogs;

public class BlogEmptyItemViewModel {

    private BlogEmptyItemViewModelListener mListener;

    public BlogEmptyItemViewModel(BlogEmptyItemViewModelListener listener) {
        this.mListener = listener;
    }

    public void onRetryClick() {
        mListener.onRetryClick();
    }

    public interface BlogEmptyItemViewModelListener {

        void onRetryClick();
    }
}
