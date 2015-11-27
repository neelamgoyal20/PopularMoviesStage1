package com.learn.popularmovies.dto;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Neelam on 11/4/2015.
 */
public class Movie implements Parcelable{
    @SerializedName("title")
    private String mMovieTitle;
    @SerializedName("release_date")
    private String mMovieReleaseYear;
    @SerializedName("overview")
    private String mMovieDescription;
    @SerializedName("vote_average")
    private float mMovieRating;
    @SerializedName("poster_path")
    private String mMoviePosterURL;

    public String getmMovieTitle() {
        return mMovieTitle;
    }

    public void setmMovieTitle(String mMovieTitle) {
        this.mMovieTitle = mMovieTitle;
    }

    public String getmMovieReleaseYear() {
        return mMovieReleaseYear;
    }

    public void setmMovieReleaseYear(String mMovieReleaseYear) {
        this.mMovieReleaseYear = mMovieReleaseYear;
    }

    public String getmMovieDescription() {
        return mMovieDescription;
    }

    public void setmMovieDescription(String mMovieDescription) {
        this.mMovieDescription = mMovieDescription;
    }

    public float getmMovieRating() {
        return mMovieRating/2;
    }

    public void setmMovieRating(float mMovieRating) {
        this.mMovieRating = mMovieRating;
    }

    public String getmMoviePosterURL() {
        return mMoviePosterURL;
    }

    public void setmMoviePosterURL(String mMoviePosterURL) {
        this.mMoviePosterURL = mMoviePosterURL;
    }

    public Movie(){

    }

    private Movie(Parcel in){
        this.mMovieTitle = in.readString();
        this.mMovieReleaseYear = in.readString();
        this.mMovieDescription = in.readString();
        this.mMovieRating = in.readFloat();
        this.mMoviePosterURL = in.readString();
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mMovieTitle);
        dest.writeString(mMovieReleaseYear);
        dest.writeString(mMovieDescription);
        dest.writeFloat(mMovieRating);
        dest.writeString(mMoviePosterURL);
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>(){
        @Override
        public Movie createFromParcel(Parcel source){
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size){
            return new Movie[size];
        }
    };
}
