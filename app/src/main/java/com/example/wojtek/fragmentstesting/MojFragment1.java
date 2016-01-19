package com.example.wojtek.fragmentstesting;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MojFragment1 extends Fragment {
    public TextView tv;
    public static MojFragment1 create ( int wiek){

        MojFragment1 fragment = new MojFragment1();
        Bundle argumenty = new Bundle();
        argumenty.putInt("wiek", (int) (Math.random() *100));
        fragment.setArguments(argumenty);
        return fragment;
    }

    public void helo(String komunikat){
        tv.setText("halo" + komunikat);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        return tv = new TextView(getActivity()) {{

            container.removeAllViews();
            setText("Jestem fragmentem1 a moj hashcode to : " + MojFragment1.this.hashCode());//+ "Argumenty : " + getArguments().getInt("wiek"));
//            setText("cos");
        }};


//        TextView a = new TextView(getActivity()) {{
//            setText("Jestem fragmentem1 a moj hashcode to : " + MojFragment1.this.hashCode());
//
//        }};

//        container.removeAllViews();


//        return inflater.inflate(R.layout.activity_main,container,false);

    }
}
