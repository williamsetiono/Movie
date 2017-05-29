package com.williamsetiono.movie;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ArrayList<Movie> movieArrayList;
    MovieAdapter adapter;

    Movie[] movies = new Movie[] {
            new Movie(
                    "Zootopia",
                    "The modern mammal metropolis of Zootopia is a city like no other bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla ",
                    "Byron Howard",
                    974,
                    "https://trailers.apple.com/trailers/disney/zootopia/images/poster.jpg",
                    "http://movietrailers.apple.com/movies/disney/zootopia/zootopia-tlr2_i320.m4v"
            ),
            new Movie(
                    "Passengers",
                    "The film tells a story about",
                    "Steve Bob",
                    975,
                    "https://trailers.apple.com/trailers/sony_pictures/passengers/images/poster.jpg",
                    "http://movietrailers.apple.com/movies/sony_pictures/passengers/passengers-clip-i-woke-up-too-soon_i320.m4v"
            ),
            new Movie(
                    "Transformers",
                    "New robot has join forces with Transformer bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla ",
                    "Alex Good",
                    977,
                    "https://trailers.apple.com/trailers/paramount/transformersdarkofthemoon/images/poster.jpg",
                    "http://movietrailers.apple.com/movies/paramount/transformers3/transformers-clip1_i320.m4v"
            ),
            new Movie(
                    "Wonderwoman",
                    "Wonderwoman is once an Amazon girl",
                    "Susy Cjoen",
                    978,
                    "https://trailers.apple.com/trailers/wb/wonderwoman/images/poster.jpg",
                    "http://movietrailers.apple.com/movies/wb/wonderwoman/wonder-woman-trailer-5_i320.m4v"
            ),
            new Movie(
                    "Spiderman",
                    "Geek boy who is bitten by spider",
                    "Jane Henr",
                    979,
                    "https://trailers.apple.com/trailers/sony_pictures/spider-man-homecoming/images/poster.jpg",
                    "http://movietrailers.apple.com/movies/sony_pictures/spiderman-homecoming/spider-man-homecoming-trailer-3_i320.m4v"
            ),
            new Movie(
                    "Logan",
                    "The coolest mutant in X Man is coming back",
                    "Malesc Alton",
                    980,
                    "https://trailers.apple.com/trailers/fox/logan/images/poster.jpg",
                    "http://movietrailers.apple.com/movies/fox/logan/logan-clip-you-know-the-drill_i320.m4v"
            ),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieArrayList = new ArrayList<>(Arrays.asList(movies));
        adapter = new MovieAdapter(this, movieArrayList);

        ListView movieListView = (ListView) findViewById(R.id.movieListView);
        movieListView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.app_bar_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d("SEARCH", newText);

                movieArrayList.clear();

                if(newText.equals(""))
                {
                    movieArrayList.addAll(Arrays.asList(movies));
                } else {
                    for (Movie movie : movies)
                    {
                        if(movie.getName().toLowerCase().contains(newText.toLowerCase())){
                            movieArrayList.add(movie);
                        }

                    }

                }

                adapter.notifyDataSetChanged();

                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}
