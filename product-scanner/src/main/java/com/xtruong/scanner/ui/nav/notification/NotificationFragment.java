package com.xtruong.scanner.ui.nav.notification;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xtruong.scanner.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Created by truongtx on 8/26/2019
 */
public class NotificationFragment extends Fragment {

    public static NotificationFragment newInstance(){return new NotificationFragment();}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceSate){
        return inflater.inflate(R.layout.fragment_notification, container, false);
    }
}
