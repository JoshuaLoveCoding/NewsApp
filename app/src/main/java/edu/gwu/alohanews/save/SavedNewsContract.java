package edu.gwu.alohanews.save;

import java.util.List;
import edu.gwu.alohanews.mvp.MvpContract;
import edu.gwu.alohanews.retrofit.response.News;

public interface SavedNewsContract {

    interface View extends MvpContract.View<Presenter> {
        void loadSavedNews(List<News> newsList);
    }

    interface Presenter extends  MvpContract.Presenter<View, Model> {
        void loadSavedNews(List<News> newsList);
    }

    interface Model extends MvpContract.Model<Presenter> {
        void fetchData();
    }
}
