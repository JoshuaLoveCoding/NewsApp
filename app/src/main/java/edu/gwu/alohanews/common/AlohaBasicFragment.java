package edu.gwu.alohanews.common;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.UUID;
import edu.gwu.alohanews.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlohaBasicFragment extends Fragment {

    protected AlohaFragmentManager alohaFragmentManager;
    private final String uuid = UUID.randomUUID().toString();

    @CallSuper
    public void onAttach(Context context) {
        super.onAttach(context);
        alohaFragmentManager = (AlohaFragmentManager) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_aloha_basic, container, false);
    }

    public String getFragmentTag() {
        return this.getClass().getName() + uuid;
    }

}
