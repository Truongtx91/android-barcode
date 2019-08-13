package com.xtruong.scanner.ui.main.rating;

import com.xtruong.scanner.ui.base.IDialogView;

/**
 * Created by truongtx on 8/13/2019
 */
public interface IRatingDialogView extends IDialogView {

    void openPlayStoreForRating();

    void showPlayStoreRatingView();

    void showRatingMessageView();

    void hideSubmitButton();

    void disableRatingStars();

    void dismissDialog();
}
