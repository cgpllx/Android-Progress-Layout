package com.oxzimo.progresslayoutapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.oxzimo.progresslayout.ProgressLayout;


public class MainActivity extends ActionBarActivity {
    ProgressLayout progressLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressLayout = (ProgressLayout) findViewById(R.id.progress_layout);
        progressLayout.init();
        new Task().execute();
    }

    public class Task extends AsyncTask<Void, Void, Boolean> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressLayout.showProgress(true);
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            try {
                // Simulate network access.
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return false;
            }
            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            progressLayout.showProgress(false);
        }

        @Override
        protected void onCancelled() {
            progressLayout.showProgress(false);
        }
    }
}
