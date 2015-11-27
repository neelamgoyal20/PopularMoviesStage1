package com.learn.popularmovies;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.learn.popularmovies.fragments.MovieDetailsFragment;
import com.learn.popularmovies.fragments.MovieGridFragment;

/**
 * Created by Neelam on 11/4/2015.
 */
public class MovieDetailActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.detail_page_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle bundle = getIntent().getExtras();

        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        if (manager.findFragmentById(R.id.detail_frame)==null) {
            MovieDetailsFragment gridDetailFragment = new MovieDetailsFragment();
            gridDetailFragment.setArguments(bundle);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.detail_frame, gridDetailFragment);
            transaction.commit();
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            MovieDetailActivity.this.finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
