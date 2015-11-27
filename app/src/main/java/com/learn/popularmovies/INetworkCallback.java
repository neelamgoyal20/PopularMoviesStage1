package com.learn.popularmovies;

import com.learn.popularmovies.dto.Movie;

import java.util.List;

/**
 * Created by Neelam on 11/25/2015.
 */
public interface INetworkCallback {
    void getDataFromNetwork(List<Movie> mMovieList);
}
