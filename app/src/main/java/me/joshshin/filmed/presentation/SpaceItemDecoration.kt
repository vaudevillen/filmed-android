package me.joshshin.filmed.presentation

import android.content.Context
import android.graphics.Rect
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import me.joshshin.filmed.utils.convertDpToPixel


/**
 * Created by Josh Shin on 4/28/18
 *
 * Adds a space between items in a recycler view
 */

class SpaceItemDecoration(context: Context, spaceSize: Float) : RecyclerView.ItemDecoration() {
    private val spaceSizePixels = convertDpToPixel(spaceSize, context).toInt()

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)

        if (parent.getChildAdapterPosition(view) == 0) return
        val orientation = (parent.layoutManager as LinearLayoutManager).orientation
        if (orientation == LinearLayoutManager.HORIZONTAL) {
            outRect.left = spaceSizePixels
        } else if (orientation == LinearLayoutManager.VERTICAL) {
            outRect.top = spaceSizePixels
        }
    }
}

