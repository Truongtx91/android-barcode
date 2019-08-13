package com.xtruong.scanner.ui.payment;

import com.xtruong.scanner.ui.payment.barcode.BarcodeFragment;
import com.xtruong.scanner.ui.payment.report.ReportFragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

/**
 * Created by truongtx on 8/13/2019
 */
public class PaymentPagerAdapter extends FragmentStatePagerAdapter {

    private int mTabCount;

    public PaymentPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.mTabCount = 0;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return BarcodeFragment.newInstance();
            case 1:
                return ReportFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mTabCount;
    }

    public void setCount(int count) {
        mTabCount = count;
    }


}
