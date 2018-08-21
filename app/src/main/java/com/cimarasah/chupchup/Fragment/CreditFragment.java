package com.cimarasah.chupchup.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cimarasah.chupchup.R;

/**
 * Created by c.de.sa.oliveira on 21/08/2018.
 */

public class CreditFragment extends Fragment {
    View v;
    public CreditFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.list_credit_fragment, container,false);
        return v;
    }
}
