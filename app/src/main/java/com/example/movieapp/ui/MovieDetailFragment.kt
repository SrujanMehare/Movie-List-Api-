package com.example.movieapp.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.data.Movie
import com.example.movieapp.data.network.TmdbService
import com.example.movieapp.ui.MovieDetailViewModel
import com.example.movieapp.ui.MovieDetailViewModelFactory
import com.example.networkexample.readableFormat
import kotlinx.android.synthetic.main.fragment_movie_detail.*


/**
 * A simple [Fragment] subclass.
 */
class MovieDetailFragment : Fragment() {
    private lateinit var viewModel: MovieDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val id: Long = MovieDetailFragmentArgs.fromBundle(requireArguments()).id
        val viewModelFactory = MovieDetailViewModelFactory(id, requireActivity().application)

        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(MovieDetailViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_detail, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.movie.observe(viewLifecycleOwner, Observer {
            setData(it)
        })
    }


    private fun setData(movie: Movie) {
        Glide.with(requireActivity())
            .load(TmdbService.POSTER_BASE_URL + movie.Poster)
            .error(R.drawable.ic_launcher_background)
            .into(movie_poster)

        Glide.with(requireActivity())
            .load(TmdbService.BACKDROP_BASE_URL+ movie.Poster)
            .error(R.drawable.ic_launcher_background)
            .into(movie_backdrop)

        movie_title.text = movie.Title
        description.text = movie.Description
        actors.text = movie.Actors
        runtime.text = movie.Runtime
        genre.text = movie.Genre
        director.text = movie.Director
        writer.text = movie.Writer
        language.text = movie.Language
        country.text = movie.Country
        awards.text = movie.Awards
        movie_release_date.text = movie.Released.readableFormat()


        //movie_release_year.text = movie.Year.toString()
    }
}
