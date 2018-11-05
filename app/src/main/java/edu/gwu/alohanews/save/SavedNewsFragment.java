package edu.gwu.alohanews.save;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.gwu.alohanews.R;
import edu.gwu.alohanews.common.AlohaBasicFragment;
import edu.gwu.alohanews.save.detail.SavedNewsDetailedFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class SavedNewsFragment extends AlohaBasicFragment {


    public static SavedNewsFragment newInstance() {
        Bundle args = new Bundle();
        SavedNewsFragment fragment = new SavedNewsFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_saved_news, container, false);
        view.findViewById(R.id.text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alohaFragmentManager.doFragmentTransaction(SavedNewsDetailedFragment.newInstance());
            }
        });
        return view;

    }

}
