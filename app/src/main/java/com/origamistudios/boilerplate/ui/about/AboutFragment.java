package com.origamistudios.boilerplate.ui.about;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.origamistudios.boilerplate.BR;
import com.origamistudios.boilerplate.R;
import com.origamistudios.boilerplate.ViewModelProviderFactory;
import com.origamistudios.boilerplate.databinding.FragmentAboutBinding;
import com.origamistudios.boilerplate.ui.base.BaseFragment;

import javax.inject.Inject;

public class AboutFragment extends BaseFragment<FragmentAboutBinding, AboutViewModel> implements AboutNavigator {

    public static final String TAG = AboutFragment.class.getSimpleName();
    @Inject
    ViewModelProviderFactory factory;
    private AboutViewModel mAboutViewModel;

    public static AboutFragment newInstance() {
        Bundle args = new Bundle();
        AboutFragment fragment = new AboutFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_about;
    }

    @Override
    public AboutViewModel getViewModel() {
        mAboutViewModel = ViewModelProviders.of(this, factory).get(AboutViewModel.class);
        return mAboutViewModel;
    }

    @Override
    public void goBack() {
        getBaseActivity().onFragmentDetached(TAG);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAboutViewModel.setNavigator(this);
    }
}
