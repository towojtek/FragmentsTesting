package com.example.wojtek.fragmentstesting;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MojFragment2 extends Fragment {
    private TextView tv;
    public static MojFragment2 create ( int wiek){
        MojFragment2 fragment = new MojFragment2();
        Bundle argumenty = new Bundle();
        argumenty.putInt("wiek", (int) (Math.random() *100));
        fragment.setArguments(argumenty);
        return fragment;
    }

    public void helo(String komunikat){
        tv.setText("halo" + komunikat);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return tv = new TextView(getActivity()) {{
            setText("Jestem fragmentem1 a moj hashcode to : " + MojFragment2.this.hashCode());
        }};

    }
}
