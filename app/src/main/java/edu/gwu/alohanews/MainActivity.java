package edu.gwu.alohanews;

import android.os.Bundle;

import edu.gwu.alohanews.common.AlohaBasicActivity;

public class MainActivity extends AlohaBasicActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void showSnackBar(String message) {

    }
}
