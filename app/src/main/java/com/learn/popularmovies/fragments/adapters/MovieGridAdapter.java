package com.learn.popularmovies.fragments.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.learn.popularmovies.R;
import com.learn.popularmovies.Utils.IConstants;
import com.learn.popularmovies.dto.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Neelam on 11/24/2015.
 */
public class MovieGridAdapter extends BaseAdapter {

    private Context mContext;
    private List<Movie> mMovieData;

    public MovieGridAdapter(Context ctx, List<Movie> movieData){
        mContext = ctx;
        mMovieData = movieData;
    }
    @Override
    public int getCount() {
        return mMovieData.size();
    }

    @Override
    public Object getItem(int position) {
        return mMovieData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder view;
        if(convertView == null){
            LayoutInflater infalter = ((Activity)mContext).getLayoutInflater();
            convertView = infalter.inflate(R.layout.list_item_movie_grid, parent, false);
            view = new ViewHolder();
            view.imgMovie = (ImageView)convertView.findViewById(R.id.img_movie_item);
            convertView.setTag(view);
        } else {
            view = (ViewHolder)convertView.getTag();
        }
        Movie movieObj = mMovieData.get(position);
//        view.imgMovie.setLayoutParams(new GridView.LayoutParams(GridView.LayoutParams.WRAP_CONTENT, GridView.LayoutParams.WRAP_CONTENT));
        if(movieObj!=null){
            if(movieObj.getmMoviePosterURL()!=null){
                Picasso.with(mContext).load(IConstants.IMAGE_THUMB_BASE_URL + IConstants.IMAGE_SIZE_W185 +movieObj.getmMoviePosterURL()).placeholder(android.R.drawable.ic_menu_gallery).into(view.imgMovie);
            }
        }
        return convertView;
    }

    static class ViewHolder{
        ImageView imgMovie;
    }
}
