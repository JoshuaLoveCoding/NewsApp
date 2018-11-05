package edu.gwu.alohanews.aloha;

import android.annotation.SuppressLint;

import edu.gwu.alohanews.AlohaApplication;
import edu.gwu.alohanews.database.AppDatabase;
import edu.gwu.alohanews.retrofit.NewsRequestApi;
import edu.gwu.alohanews.retrofit.RetrofitClient;
import edu.gwu.alohanews.retrofit.response.News;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AlohaModel implements AlohaContract.Model {

    private AlohaContract.Presenter presenter;

    private final NewsRequestApi newsRequestApi;

    private final AppDatabase db;

    public AlohaModel() {
        newsRequestApi = RetrofitClient.getInstance().create(NewsRequestApi.class);
        db = AlohaApplication.getDataBase();
    }

    @Override
    public void setPresenter(AlohaContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void fetchData() {
        newsRequestApi.getNewsByCountry("us")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(baseResponse -> baseResponse != null && baseResponse.articles != null)
                .subscribe(baseResponse -> {
                    presenter.showNewsCard(baseResponse.articles);
                });
    }

    @SuppressLint("CheckResult")
    @Override
    public void saveFavoriteNews(News news) {
        Disposable disposable = Completable.fromAction(() -> db.newsDao().insertNews(news)).
                subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(() ->{

        }, error -> {
        });
    }
}
