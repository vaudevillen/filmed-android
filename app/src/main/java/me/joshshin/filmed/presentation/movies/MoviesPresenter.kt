package me.joshshin.filmed.presentation.movies

import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_info_item.view.*
import kotlinx.android.synthetic.main.movie_item.view.*
import me.joshshin.datalayer.network.FilmedApiConstants.BASE_IMAGE_URL
import me.joshshin.filmed.R
import me.joshshin.filmed.utils.setGone
import me.joshshin.filmed.utils.setVisible

/**
 * Created by Josh Shin on 2020-02-11
 */

interface MoviesPresenter {
    fun setTitle(titleStr: String)
    fun setOverview(text: String)
    fun showOverview(shouldShow: Boolean)
    fun enlargeImage(shouldEnlarge: Boolean)
    fun updatePoster(imagePath: String)
}

class MoviePresenterView(rootView: View) : MoviesPresenter {
    val title = rootView.title
    val overview = rootView.overview
    val movieInfoContainer = rootView.info_container
    val image = rootView.backdrop_image


    //TODO change image path i/r/t image size depending on screen density
    override fun setTitle(titleStr: String) {
        title.text = titleStr
    }

    override fun setOverview(text: String) {
        overview.text = text
    }

    override fun showOverview(shouldShow: Boolean) {
        if (shouldShow) {
            movieInfoContainer.setVisible()
        } else {
            overview.setGone()
        }
    }

    override fun enlargeImage(shouldEnlarge: Boolean) {
        val context = image.context
        val params: ViewGroup.LayoutParams = image.layoutParams

        // TODO fix this jankiness
        if (shouldEnlarge) {
            params.height = (image.height * 1.2f).toInt()
            params.width = (ViewGroup.LayoutParams.MATCH_PARENT * 1.2f).toInt()
            image.setPadding(0, 0, 0, 0)
            image.adjustViewBounds = false
            image.animate()
                    .scaleX(1.25f)
                    .scaleY(1.25f)
                    .alpha(1f)
                    .setInterpolator(LinearInterpolator())
                    .start()
        } else {
            val paddingSmall = context.resources.getDimension(R.dimen.margin_small).toInt()
            val paddingRegular = context.resources.getDimension(R.dimen.margin_regular).toInt()
            image.adjustViewBounds = true
            params.width = (image.height * 5.0/6.0).toInt()
            params.height = ViewGroup.LayoutParams.MATCH_PARENT
            image.setPadding(paddingRegular, paddingSmall, paddingRegular, paddingSmall)
            image.animate()
                    .scaleX(1.2f)
                    .scaleY(1.2f)
                    .alpha(1f)
                    .setInterpolator(LinearInterpolator())
                    .start()
        }

        image.layoutParams = params
        image.scaleType = if (shouldEnlarge) ImageView.ScaleType.CENTER_CROP else ImageView.ScaleType.FIT_CENTER
    }

    override fun updatePoster(imagePath: String) {
        Picasso.get().load(BASE_IMAGE_URL + imagePath).into(image)
    }
}