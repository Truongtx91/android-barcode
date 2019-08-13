package com.xtruong.scanner.ui.main.rating;

import com.xtruong.scanner.ui.base.IPresenter;

/**
 * Created by truongtx on 8/13/2019
 */
public interface IRatingDialogPresenter<V extends IRatingDialogView> extends IPresenter<V> {

    void onRatingSubmitted(float rating, String message);

    void onCancelClicked();

    void onLaterClicked();

    void onPlayStoreRatingClicked();
}
