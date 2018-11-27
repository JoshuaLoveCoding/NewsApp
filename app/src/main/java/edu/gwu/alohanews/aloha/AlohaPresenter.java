package edu.gwu.alohanews.aloha;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import edu.gwu.alohanews.profile.CountryEvent;
import edu.gwu.alohanews.retrofit.response.News;

public class AlohaPresenter implements AlohaContract.Presenter {

    private AlohaContract.View view;

    private AlohaContract.Model model;

    public AlohaPresenter() {
        this.model = new AlohaModel();
        //link the model with presenter
        this.model.setPresenter(this);
    }

    @Override
    public void onCreate() {
        EventBus.getDefault().register(this);
    }


    @Override
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(CountryEvent countryEvent) {
        if (this.view != null) {
            this.model.fetchData(countryEvent.country);
        }
    }


    @Override
    public void onViewAttached(AlohaContract.View view) {
        this.view = view;
        this.model.fetchData("us");
    }

    @Override
    public void onViewDetached() {
        this.view = null;
    }

    @Override
    public void showNewsCard(List<News> newsList) {
        if (this.view != null) {
            view.showNewsCard(newsList);
        }
    }

    @Override
    public void saveFavoriteNews(News news) {
        model.saveFavoriteNews(news);
    }

    @Override
    public void onError(String message) {
        if (view != null) {
            view.onError(message);
        }
    }

}
