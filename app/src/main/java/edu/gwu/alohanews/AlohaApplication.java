package edu.gwu.alohanews;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.facebook.stetho.Stetho;

import edu.gwu.alohanews.database.AppDatabase;

public class AlohaApplication extends Application {

    public static AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        database = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "aloha_db").build();
    }

    public static AppDatabase getDataBase() {
        return database;
    }

}
