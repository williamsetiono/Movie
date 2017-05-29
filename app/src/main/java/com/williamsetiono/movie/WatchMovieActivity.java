package com.williamsetiono.movie;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.squareup.picasso.Picasso;

/**
 * Created by williamsetiono on 5/28/17.
 */

public class WatchMovieActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.watch_movie);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String description = intent.getStringExtra("description");
        String director = intent.getStringExtra("director");
        int numberOfViews = intent.getIntExtra("numberOfViews", 0);
        String image = intent.getStringExtra("image");
        String url = intent.getStringExtra("url");

        TextView nameTextView = (TextView) findViewById(R.id.nameTextView);
        TextView directorTextView = (TextView) findViewById(R.id.directorTextView);
        TextView descriptionTextView = (TextView) findViewById(R.id.descriptionTextView);
        TextView numberOfViewsTextView = (TextView) findViewById(R.id.numberOfViewsTextView);
        ImageView imageView = (ImageView) findViewById(R.id.movieImage);

        nameTextView.setText(name);
        directorTextView.setText(director);
        descriptionTextView.setText(description);
        numberOfViewsTextView.setText(numberOfViews + " views");
        Picasso.with(this).load(image).into(imageView);

        //Play Video
        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        videoView.setVideoURI(Uri.parse(url));
        videoView.start();

        //Add Controller
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
    }
}
