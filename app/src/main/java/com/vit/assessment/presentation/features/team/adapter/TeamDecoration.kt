package com.vit.assessment.presentation.features.team.adapter

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.vit.assessment.R

class TeamDecoration(context: Context) : RecyclerView.ItemDecoration() {

    private val homeMargin =
        context.resources.getDimensionPixelSize(R.dimen.app_margin)

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        with(outRect) {
            if (position != RecyclerView.NO_POSITION) {
                if (position == 0) {
                    top = homeMargin
                }
                left = homeMargin
                right = homeMargin
                bottom = homeMargin
            }
        }
    }
}