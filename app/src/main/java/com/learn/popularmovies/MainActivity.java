package com.learn.popularmovies;

import android.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.TextView;

import com.learn.popularmovies.fragments.MovieGridFragment;
import com.learn.popularmovies.network.NetworkCallAsync;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        if (manager.findFragmentById(R.id.grid_frame)==null) {
            MovieGridFragment gridFragment = new MovieGridFragment();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.grid_frame, gridFragment);
            transaction.commit();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
