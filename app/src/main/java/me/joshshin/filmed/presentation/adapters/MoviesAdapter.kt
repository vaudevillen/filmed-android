package me.joshshin.filmed.presentation.adapters

import android.content.Context
import android.support.transition.ChangeBounds
import android.support.transition.ChangeImageTransform
import android.support.transition.TransitionManager
import android.support.transition.TransitionSet
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_info_item.view.*
import me.joshshin.filmed.R
import me.joshshin.filmed.presentation.adapters.MoviesAdapter.MoviesViewHolder
import me.joshshin.domain.dataProvider.DataCallback
import me.joshshin.domain.dataProvider.DataCallbackException
import kotlinx.android.synthetic.main.movie_item.view.*
import me.joshshin.datalayer.network.FilmedApiConstants.BASE_IMAGE_URL
import me.joshshin.domain.models.FilmedMovie
import me.joshshin.filmed.FilmedConfig
import android.widget.ImageView.ScaleType.CENTER_CROP
import android.widget.ImageView.ScaleType.FIT_CENTER
import me.joshshin.filmed.utils.*

/**
 * Created by Josh Shin on 4/15/18
 */

class MoviesAdapter(private val context: Context) : RecyclerView.Adapter<MoviesViewHolder>() {
    private var movies: List<FilmedMovie> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return MoviesViewHolder(view)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = movies[position]
        //TODO change image path i/r/t image size depending on screen density
        with(holder) {
            title.text = movie.title
            overview.text = movie.overview
            Picasso.get().load(BASE_IMAGE_URL + movie.backdropPath).into(image)
            itemView.setOnClickListener {
                infoContainer.toggleVisibility()
                expandImage(image, itemView, infoContainer.isVisible())
                TransitionManager.beginDelayedTransition(itemView.parent as ViewGroup)
            }
        }
    }

    private fun expandImage(image: ImageView, root: View, shouldExpand: Boolean) {
        val parent = root.parent as ViewGroup
        TransitionManager.beginDelayedTransition(parent, TransitionSet()
                .addTransition(ChangeBounds())
                .addTransition(ChangeImageTransform()))
        val params: ViewGroup.LayoutParams = image.layoutParams
        if (shouldExpand) {
            params.height = (image.height * 1.2f).toInt()
            params.width = (MATCH_PARENT * 1.2f).toInt()
            image.setPadding(0, 0, 0 , 0)
            image.adjustViewBounds = false
        } else {
            val paddingSmall = context.resources.getDimension(R.dimen.margin_small).toInt()
            val paddingRegular = context.resources.getDimension(R.dimen.margin_regular).toInt()
            image.adjustViewBounds = true
            params.width = MATCH_PARENT
            params.height = WRAP_CONTENT
            image.setPadding(paddingRegular, paddingSmall, paddingRegular, paddingSmall)
        }
        image.layoutParams = params
        image.scaleType = if (shouldExpand) CENTER_CROP else FIT_CENTER


    }
    private fun generateMoviesCallback(): DataCallback<FilmedMovie> {
        return object : DataCallback<FilmedMovie> {
            override fun onComplete(data: List<FilmedMovie>) {
                movies = data
                runOnUiThread { notifyDataSetChanged() }
            }
            override fun onError(error: DataCallbackException) {
                Toast.makeText(context, "Error downloading movies", Toast.LENGTH_LONG).show()
                Logger.e(this, "${error.message}")
            }
        }
    }

    private fun fetchMovies() {
        FilmedConfig.moviesProvider.provideData(generateMoviesCallback())
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        fetchMovies()
    }

    class MoviesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val infoContainer = view.info_container
        val overview = view.overview
        val title = view.title
        val image = view.backdrop_image
    }
}