package edu.gwu.alohanews.profile;

import org.greenrobot.eventbus.EventBus;

import edu.gwu.alohanews.AlohaApplication;
import edu.gwu.alohanews.database.AppDatabase;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ProfileModel implements ProfileContract.Model {

    private ProfileContract.Presenter presenter;
    private AppDatabase db = AlohaApplication.getDataBase();

    @Override
    public void deleteAllNewsCache() {
        Disposable disposable = Completable.fromAction(() -> db.newsDao().deleteAllNews()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(() -> {
            presenter.onCacheCleared();
        }, error -> {

        });
    }

    @Override
    public void setDefaultCountry(String country) {
        EventBus.getDefault().post(new CountryEvent(country));
    }

    @Override
    public void setPresenter(ProfileContract.Presenter presenter) {

    }
}
