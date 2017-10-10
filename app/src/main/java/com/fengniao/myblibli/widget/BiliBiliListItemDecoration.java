package com.fengniao.myblibli.widget;


import android.graphics.Canvas;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public class BiliBiliListItemDecoration extends RecyclerView.ItemDecoration {
    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        if (parent.getLayoutManager() instanceof GridLayoutManager) {
            int spanSize = ((GridLayoutManager) parent.getLayoutManager())
                    .getSpanSizeLookup()
                    .getSpanSize(state.getTargetScrollPosition());
            if (spanSize == 2) {

            }
        }
    }
}
