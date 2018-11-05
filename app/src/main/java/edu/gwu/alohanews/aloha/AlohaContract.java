package edu.gwu.alohanews.aloha;

import java.util.List;
import edu.gwu.alohanews.mvp.MvpContract;
import edu.gwu.alohanews.retrofit.response.News;

public interface AlohaContract {

    interface View extends MvpContract.View<Presenter> {
        void showNewsCard(List<News> newsList);
    }

    interface Presenter extends MvpContract.Presenter<View, Model> {
        void showNewsCard(List<News> newsList);
        void saveFavoriteNews(News news);
    }

    interface Model extends MvpContract.Model<Presenter> {
        void fetchData();
        void saveFavoriteNews(News news);
    }
}
