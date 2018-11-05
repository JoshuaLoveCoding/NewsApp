package edu.gwu.alohanews.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import edu.gwu.alohanews.retrofit.response.News;

@Database(entities = {News.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract NewsDao newsDao();
}

