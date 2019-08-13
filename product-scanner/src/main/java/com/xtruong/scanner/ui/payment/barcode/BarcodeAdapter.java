package com.xtruong.scanner.ui.payment.barcode;

import android.view.ViewGroup;

import com.xtruong.scanner.ui.base.BaseViewHolder;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by truongtx on 8/13/2019
 */
public class BarcodeAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;

    private Callback mCallback;

    public void setCallback(Callback callback) {
        mCallback = callback;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return null;
//        switch (viewType) {
//            case VIEW_TYPE_NORMAL:
//                return new RecyclerView.ViewHolder(
//                        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_blog_view, parent, false));
//            case VIEW_TYPE_EMPTY:
//            default:
//                return new EmptyViewHolder(
//                        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false));
//        }
    }

    @Override
    public int getItemViewType(int position) {
        //TODO
        return 0;
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public interface Callback {
        void onBlogEmptyViewRetryClick();
    }
}
