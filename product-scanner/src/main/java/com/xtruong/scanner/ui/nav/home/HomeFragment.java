package com.xtruong.scanner.ui.nav.home;

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
public class HomeFragment extends Fragment {

    public static HomeFragment newInstance(){return new HomeFragment();}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle saveInstanceState){
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}
