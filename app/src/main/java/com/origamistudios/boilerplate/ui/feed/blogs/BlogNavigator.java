package com.origamistudios.boilerplate.ui.feed.blogs;

import com.origamistudios.boilerplate.data.model.api.BlogResponse;
import java.util.List;

public interface BlogNavigator {

    void handleError(Throwable throwable);

    void updateBlog(List<BlogResponse.Blog> blogList);
}
