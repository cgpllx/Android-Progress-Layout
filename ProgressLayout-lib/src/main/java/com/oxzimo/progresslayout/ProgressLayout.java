package com.oxzimo.progresslayout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;


public class ProgressLayout extends FrameLayout {
    private View mMainView;
    private View mProgressView;
    private View mErrorView;

    public ProgressLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.progress_layout, this, true);
        TypedArray attributes = context.obtainStyledAttributes(attrs,
                R.styleable.ProgressLayout);

        int progressLayoutRef = attributes.getResourceId(R.styleable.ProgressLayout_progressLayout, R.layout.progress_default);
        View progressView = inflater.inflate(progressLayoutRef, this, false);
        this.addView(progressView);

        int errorLayoutRef = attributes.getResourceId(R.styleable.ProgressLayout_errorLayout, R.layout.error_default);
        View errorView = inflater.inflate(errorLayoutRef, this, false);
        this.addView(errorView);

        attributes.recycle();
    }

    public void init() {
        mProgressView = getChildAt(0);
        mErrorView = getChildAt(1);
        mMainView = getChildAt(2);
    }

    /**
     * Shows the progress UI and hides the container form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    public void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mMainView.setVisibility(show ? View.GONE : View.VISIBLE);
            mMainView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mMainView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });

            mErrorView.setVisibility(View.GONE);
            mErrorView.animate().setDuration(shortAnimTime).alpha(0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mErrorView.setVisibility(View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mMainView.setVisibility(show ? View.GONE : View.VISIBLE);
            mErrorView.setVisibility(View.GONE);
        }
    }

    /**
     * Shows the Error UI and hides all.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    public void showError() {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mMainView.setVisibility(View.GONE);
            mMainView.animate().setDuration(shortAnimTime).alpha(
                    0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mMainView.setVisibility(View.GONE);
                }
            });

            mProgressView.setVisibility(View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(View.GONE);
                }
            });

            mErrorView.setVisibility(View.VISIBLE);
            mErrorView.animate().setDuration(shortAnimTime).alpha(
                    1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mErrorView.setVisibility(View.VISIBLE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(View.GONE);
            mMainView.setVisibility(View.GONE);
            mErrorView.setVisibility(View.VISIBLE);

        }
    }

}
