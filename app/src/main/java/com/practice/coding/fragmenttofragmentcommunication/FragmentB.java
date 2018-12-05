package com.practice.coding.fragmenttofragmentcommunication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentB extends Fragment {
    private TextView tvData;
    private String data = "";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);

        if(savedInstanceState == null)
        {
            //means first time when created a activity
        }else
        {
            data = savedInstanceState.getString("DATA_B");
            TextView updatedTextView = view.findViewById(R.id.tvFragmentB);
            updatedTextView.setText(data);
        }

        return view;
    }

    //get The view reference

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //this method gives the guarantee , the ui of the underlaying activity is created..means the ui of that activity in which
        //this fragment is attached..
        tvData = getActivity().findViewById(R.id.tvFragmentB);
    }

    //here we can get the data from fragmentA so update the UI any time when data come from Fragement A..
    public void changeData(String data)
    {
        /*
        actually assign the coming data to this.data for saving that value in savedIstanseState may be anywhere fragment is destroy
         */
        this.data = data;
        tvData.setText(data);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("DATA_B", data);
    }

    /*
    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if(savedInstanceState!=null)
        {
            this.data = savedInstanceState.getString("DATA_B");
            tvData.setText(data);
        }
    }

    */
}
