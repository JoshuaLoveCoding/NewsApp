package edu.gwu.alohanews.aloha;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;

import edu.gwu.alohanews.R;
import edu.gwu.alohanews.common.AlohaBasicFragment;
import edu.gwu.alohanews.retrofit.response.News;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlohaGalleryFragment extends AlohaBasicFragment implements AlohaNewsCard.OnSwipeListener  {
    private SwipePlaceHolderView mSwipeView;


    public static AlohaGalleryFragment newInstance() {
        Bundle args = new Bundle();
        AlohaGalleryFragment fragment = new AlohaGalleryFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_aloha_gallery, container, false);

        mSwipeView = view.findViewById(R.id.swipeView);

        mSwipeView.getBuilder()
                .setDisplayViewCount(3)
                .setSwipeDecor(new SwipeDecor()
                        .setPaddingTop(20)
                        .setRelativeScale(0.01f)
                        .setSwipeInMsgLayoutId(R.layout.aloha_news_swipe_in_msg_view)
                        .setSwipeOutMsgLayoutId(R.layout.aloha_news_swipe_out_msg_view));

        view.findViewById(R.id.rejectBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSwipeView.doSwipe(false);
            }
        });

        view.findViewById(R.id.acceptBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSwipeView.doSwipe(true);
            }
        });

        //fake date start from line 62
        for (int i = 0; i < 10; i++) {
            News news = new News();
            news.image = "https://i.ytimg.com/vi/BgIJ45HKDpw/maxresdefault.jpg";
            AlohaNewsCard tinNewsCard = new AlohaNewsCard(news, mSwipeView, this);
            mSwipeView.addView(tinNewsCard);
        }

        return view;
    }


    @Override
    public void onLike(News news) {

    }
}
