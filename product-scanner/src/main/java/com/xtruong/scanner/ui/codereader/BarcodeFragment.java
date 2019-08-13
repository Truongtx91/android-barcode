package com.xtruong.scanner.ui.codereader;

import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.vision.barcode.Barcode;
import com.xtruong.scanner.R;
import com.xtruong.scanner.di.component.ActivityComponent;
import com.xtruong.scanner.ui.base.BaseFragment;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import info.androidhive.barcode.BarcodeReader;

/**
 * Created by truongtx on 8/10/2019
 */
public class BarcodeFragment extends BaseFragment
        implements BarcodeReader.BarcodeReaderListener, IBarcodeView {

    private static final String TAG = BarcodeFragment.class.getSimpleName();

    private BarcodeReader barcodeReader;

    @Inject
    IBarcodePresenter<IBarcodeView> mPresenter;

    public static BarcodeFragment newInstance() {
        Bundle args = new Bundle();
        BarcodeFragment fragment = new BarcodeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_barcode, container, false);

        ActivityComponent component = getActivityComponent();

        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));

            barcodeReader = (BarcodeReader) getChildFragmentManager().findFragmentById(R.id.barcode_fragment);
            barcodeReader.setListener(this);

            mPresenter.onAttach(this);
        }

        return view;
    }

    @Override
    protected void setUp(View view) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }

    @Override
    public void onScanned(final Barcode barcode) {
        Log.e(TAG, "onScanned: " + barcode.displayValue);
        barcodeReader.playBeep();
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getActivity(), "Barcode: " + barcode.displayValue, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onScannedMultiple(List<Barcode> barcodes) {
        Log.e(TAG, "onScannedMultiple: " + barcodes.size());

        String codes = "";
        for (Barcode barcode : barcodes) {
            codes += barcode.displayValue + ", ";
        }

        final String finalCodes = codes;
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getActivity(), "Barcodes: " + finalCodes, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBitmapScanned(SparseArray<Barcode> sparseArray) {
    }

    @Override
    public void onScanError(String errorMessage) {
        Log.e(TAG, "onScanError: " + errorMessage);
    }

    @Override
    public void onCameraPermissionDenied() {
        Toast.makeText(getActivity(), "Camera permission denied!", Toast.LENGTH_LONG).show();
    }
}
