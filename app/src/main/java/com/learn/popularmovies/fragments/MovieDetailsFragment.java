package com.learn.popularmovies.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.learn.popularmovies.R;
import com.learn.popularmovies.Utils.IConstants;
import com.learn.popularmovies.dto.Movie;
import com.squareup.picasso.Picasso;

/**
 * Created by Neelam on 11/4/2015.
 */
public class MovieDetailsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_detail, null);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView movieTitle = (TextView)getView().findViewById(R.id.movie_title);
        TextView movieReleaseYear = (TextView)getView().findViewById(R.id.movie_release_year);
        TextView movieDescription = (TextView)getView().findViewById(R.id.movie_description);
        ImageView moviePoster = (ImageView)getView().findViewById(R.id.movie_poster);
        RatingBar movieRating = (RatingBar)getView().findViewById(R.id.movie_rating);

        Movie bundle = (Movie)getArguments().getParcelable("DetailObject");
        if (bundle!=null){
            movieTitle.setText(bundle.getmMovieTitle());
            movieReleaseYear.setText(bundle.getmMovieReleaseYear());
            movieRating.setRating(bundle.getmMovieRating());
            movieDescription.setText(bundle.getmMovieDescription());
            String posterUrl = IConstants.IMAGE_THUMB_BASE_URL+ IConstants.IMAGE_SIZE_W342 + bundle.getmMoviePosterURL();
            if (posterUrl!=null) {
                Picasso.with(getActivity()).load(posterUrl).placeholder(android.R.drawable.ic_menu_gallery).into(moviePoster);
            }
        }
    }
}

