package com.practice.coding.fragmenttofragmentcommunication;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements Communicator{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void respond(String data) {
        /*
        here we get the change occur in fragment a..so here access the fragment B changeData() method
        and pass the data that is coming from Fragment A..let see below how it will do actually
         */

        FragmentManager manager = getSupportFragmentManager();
        FragmentB fragmentB = (FragmentB) manager.findFragmentById(R.id.fragmentB);
        fragmentB.changeData(data);
    }
}
