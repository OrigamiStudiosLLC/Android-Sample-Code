package com.origamistudios.boilerplate.ui.main.rating;

import androidx.lifecycle.ViewModelProviders;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.origamistudios.boilerplate.R;
import com.origamistudios.boilerplate.ViewModelProviderFactory;
import com.origamistudios.boilerplate.databinding.DialogRateUsBinding;
import com.origamistudios.boilerplate.ui.base.BaseDialog;
import dagger.android.support.AndroidSupportInjection;
import javax.inject.Inject;

public class RateUsDialog extends BaseDialog implements RateUsCallback {

    private static final String TAG = RateUsDialog.class.getSimpleName();
    @Inject
    ViewModelProviderFactory factory;
    private RateUsViewModel mRateUsViewModel;

    public static RateUsDialog newInstance() {
        RateUsDialog fragment = new RateUsDialog();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void dismissDialog() {
        dismissDialog(TAG);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        DialogRateUsBinding binding = DataBindingUtil.inflate(inflater, R.layout.dialog_rate_us, container, false);
        View view = binding.getRoot();

        AndroidSupportInjection.inject(this);
        mRateUsViewModel = ViewModelProviders.of(this,factory).get(RateUsViewModel.class);
        binding.setViewModel(mRateUsViewModel);

        mRateUsViewModel.setNavigator(this);

        return view;
    }

    public void show(FragmentManager fragmentManager) {
        super.show(fragmentManager, TAG);
    }
}
