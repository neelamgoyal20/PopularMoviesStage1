package com.learn.popularmovies.network;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.learn.popularmovies.INetworkCallback;
import com.learn.popularmovies.R;
import com.learn.popularmovies.Utils.IConstants;
import com.learn.popularmovies.Utils.Utility;
import com.learn.popularmovies.dto.Movie;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by Neelam  on 11/22/2015.
 */
public class NetworkCallAsync extends AsyncTask<Void, Void, String> {
    private INetworkCallback mCallback;
    private ProgressDialog mProgressDialog;
    private Context mContext;
    private String mSortByParam;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mProgressDialog = ProgressDialog.show(mContext, null,
                mContext.getString(R.string.msg_fetching_data), true);
    }

    public NetworkCallAsync(INetworkCallback callback, Context ctx, String sortParam) {
        mCallback = callback;
        mContext = ctx;
        mSortByParam = sortParam;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if(mProgressDialog!=null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
        if(result != null) {
            Gson gson = new Gson();
            JsonParser parser = new JsonParser();
            JsonObject obj = parser.parse(result).getAsJsonObject();
            JsonElement arrayStr = obj.get("results");
            Type listType = new TypeToken<List<Movie>>() {
            }.getType();
            List<Movie> posts = (List<Movie>) gson.fromJson(arrayStr, listType);
            Log.d("Network", "PostEx");
            mCallback.getDataFromNetwork(posts);
        } else {
            mCallback.getDataFromNetwork(null);
        }
    }

    @Override
    protected String doInBackground(Void... params) {
        String result = discoverMovies();
        return result;
    }

    private String discoverMovies() {
        String line = null;
        try {
            URL url = new URL(IConstants.MOVIE_BASE_URL+mSortByParam+IConstants.MOVIE_KEY_PARAM+IConstants.API_KEY);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

// read the response
            System.out.println("Response Code: " + conn.getResponseCode());
            if(conn.getResponseCode() == 200) {
                InputStream in = new BufferedInputStream(conn.getInputStream());

                if (in != null) {
                    line = Utility.convertStreamToString(in);
                }
            }

            Log.d("Network", " Result ::: " + line);
        } catch (IOException e) {
            e.printStackTrace();
            if(mProgressDialog!=null && mProgressDialog.isShowing()) {
                mProgressDialog.dismiss();
            }
        }
        return line;
    }


}
