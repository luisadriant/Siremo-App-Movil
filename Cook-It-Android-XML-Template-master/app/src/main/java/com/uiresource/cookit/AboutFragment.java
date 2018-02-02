package com.uiresource.cookit;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AboutFragment extends Fragment {
    private Context globalContext = null;
    public AboutFragment(){
        setHasOptionsMenu(true);
    }
    public void onCreate(Bundle a){
        super.onCreate(a);
        setHasOptionsMenu(true);
        globalContext=this.getActivity();
    }

    @Override
    public void onResume() {
        super.onResume();
        //consultaVestimentas();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, null, false);

        ((Main)getActivity()).setupToolbar(R.id.toolbar, "SIREMO", R.color.colorPink, R.color.colorWhiteTrans, R.drawable.ic_burger);

        return view;
    }

}
