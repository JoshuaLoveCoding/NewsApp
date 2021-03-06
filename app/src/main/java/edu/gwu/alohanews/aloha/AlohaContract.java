package edu.gwu.alohanews.aloha;

import java.util.List;
import edu.gwu.alohanews.mvp.MvpContract;
import edu.gwu.alohanews.retrofit.response.News;

public interface AlohaContract {

    interface View extends MvpContract.View<Presenter> {
        void showNewsCard(List<News> newsList);
        void onError(String message);
    }

    interface Presenter extends MvpContract.Presenter<View, Model> {
        void showNewsCard(List<News> newsList);
        void saveFavoriteNews(News news);
        void onError(String message);
    }

    interface Model extends MvpContract.Model<Presenter> {
        void fetchData(String country);
        void saveFavoriteNews(News news);
    }
}
