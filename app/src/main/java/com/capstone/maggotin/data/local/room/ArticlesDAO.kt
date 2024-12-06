package com.capstone.maggotin.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.capstone.maggotin.data.local.entity.ArticlesEntity

@Dao
interface ArticlesDao {

    // Retrieve all articles ordered by date in descending order
    @Query("SELECT * FROM articles ORDER BY date DESC")
    fun getArticles(): LiveData<List<ArticlesEntity>>

    // Retrieve bookmarked articles
    @Query("SELECT * FROM articles WHERE is_bookmarked = 1")
    fun getBookmarkedArticles(): LiveData<List<ArticlesEntity>>

    // Insert articles into the database. If an article already exists, ignore it.
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertArticles(articles: List<ArticlesEntity>)

    // Update an article's bookmark status
    @Update
    fun updateArticle(article: ArticlesEntity)

    // Delete articles that are not bookmarked (optional, depending on your use case)
    @Query("DELETE FROM articles WHERE is_bookmarked = 0")
    fun deleteNonBookmarkedArticles()

    // Check if a specific article is bookmarked based on its title
    @Query("SELECT EXISTS(SELECT 1 FROM articles WHERE title = :title AND is_bookmarked = 1)")
    fun isArticleBookmarked(title: String): Boolean

    @Query("UPDATE articles SET is_bookmarked = :status WHERE id = :articleId")
    suspend fun updateBookmarkStatusById(articleId: Int, status: Boolean)
}