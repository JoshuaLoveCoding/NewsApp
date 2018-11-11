package edu.gwu.alohanews.save;

import android.annotation.SuppressLint;
import edu.gwu.alohanews.AlohaApplication;
import edu.gwu.alohanews.database.AppDatabase;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SavedNewsModel implements SavedNewsContract.Model {

    private final AppDatabase db;

    SavedNewsModel() {
        db = AlohaApplication.getDataBase();
    }

    private SavedNewsContract.Presenter presenter;

    @Override
    public void setPresenter(SavedNewsContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @SuppressLint("CheckResult")
    @Override
    public void fetchData() {
        db.newsDao().getAll().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(presenter::loadSavedNews, error -> {
                    System.out.println("error");
                }, () -> {
                    System.out.println("complete");
                });
    }

}
