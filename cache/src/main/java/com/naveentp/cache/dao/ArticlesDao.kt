package com.naveentp.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.naveentp.cache.model.ArticleEntity
import io.reactivex.Completable
import io.reactivex.Flowable

/**
 * @author Naveen T P
 * @since 02/06/19
 */
@Dao
interface ArticlesDao {

    @Query("SELECT * from Articles")
    fun getTopHeadlines(): Flowable<List<ArticleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveTopHeadlines(newsList: List<ArticleEntity>): Completable
}