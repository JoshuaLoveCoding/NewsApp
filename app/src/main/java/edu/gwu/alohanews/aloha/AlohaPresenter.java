package edu.gwu.alohanews.aloha;

import java.util.List;
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

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onViewAttached(AlohaContract.View view) {
        this.view = view;
        this.model.fetchData();
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

}
