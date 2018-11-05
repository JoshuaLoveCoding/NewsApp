package edu.gwu.alohanews.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import edu.gwu.alohanews.retrofit.response.News;

@Dao
public interface NewsDao {

    @Insert
    void insertNews(News news);
}
