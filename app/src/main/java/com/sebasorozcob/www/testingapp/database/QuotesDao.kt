package com.sebasorozcob.www.testingapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface QuotesDao {

    @Insert
    suspend fun insertQuote(quote: Quote)

    @Update
    suspend fun updateQuote(quote: Quote)

    @Query("DELETE FROM quote")
    suspend fun deleteAll()

    @Query("SELECT * FROM QUOTE")
    fun getQuotes(): LiveData<List<Quote>>

    @Query("SELECT * FROM QUOTE WHERE id = :quoteId")
    suspend fun getQuoteById(quoteId: Int): Quote






}