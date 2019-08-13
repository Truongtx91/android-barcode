package com.xtruong.scanner.ui.payment.report;

import android.view.ViewGroup;

import com.xtruong.scanner.ui.base.BaseViewHolder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by truongtx on 8/13/2019
 */
public class ReportAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;

    private Callback mCallback;

    public void setCallback(Callback callback) {
        mCallback = callback;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //TODO
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        //TODO
    }

    @Override
    public int getItemCount() {
        //TODO
        return 0;
    }

    public interface Callback {
        void onRepoEmptyViewRetryClick();
    }
}
