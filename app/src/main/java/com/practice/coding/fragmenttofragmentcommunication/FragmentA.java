package com.practice.coding.fragmenttofragmentcommunication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentA extends Fragment implements OnClickListener{
    private EditText etData;
    private Button btSendData;
    String data = "";
    private Communicator communicator;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        return view;
    }

    @Override
    public void onClick(View v) {
        data = etData.getText().toString();
      //The interface reference variable is able to access the subclass methods..
        communicator.respond(data);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        /*
        this method gives the assurity of the activity is created , means the activity inwhich the fragment attached.
        we can not do any thing or change in the UI of activity unless it is not created.
        when activity is created then we make change in the UI..
        So we initialize our views here and makes change in the UI here..
         */
        //the interface reference variable get the context or reference of the MainAcivity in which we implements it.
        //The interface reference variable is initialize with the reference of activity that implements its.

        communicator = (Communicator) getActivity();

        //getAcitivity() is the context of the underlying acitivity
        etData = getActivity().findViewById(R.id.etFragmentA);
        btSendData = getActivity().findViewById(R.id.btSend);

        btSendData.setOnClickListener(this);
    }

    /* here onCreate method for getting the saved instanse bundle value after orientation change fragment destroy so get
    saved value */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState == null)
        {
            //means first time when activity create
        }else
        {
            //possible when orientation change or something occur that destroy the fragment..so gettinh the saved value
            data = savedInstanceState.getString("DATA_A");
        }
    }

    //when orientation change the fragment is destroy so keep save value in the save Instance State
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Toast.makeText(getActivity(), "SavedInstanceState", Toast.LENGTH_SHORT).show();
        outState.putString("DATA_A", data);
    }
}
