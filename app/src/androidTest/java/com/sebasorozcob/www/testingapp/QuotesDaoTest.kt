package com.sebasorozcob.www.testingapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.test.core.app.ApplicationProvider
import com.sebasorozcob.www.testingapp.database.Quote
import com.sebasorozcob.www.testingapp.database.QuoteDatabase
import com.sebasorozcob.www.testingapp.database.QuotesDao
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class QuotesDaoTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var quoteDatabase: QuoteDatabase
    private lateinit var quotesDao: QuotesDao

    @Before
    fun setUp() {
        quoteDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            QuoteDatabase::class.java
        ).allowMainThreadQueries().build()

        quotesDao = quoteDatabase.quoteDao()
    }

    @Test
    fun insertQuote_expectedSingleQuote() = runBlocking {
        val quote = Quote(0,"This is a test quote", "Juan S Orozco Buitrago")
        quotesDao.insertQuote(quote)


        val result = quotesDao.getQuotes().getOrAwaitValue()

        Assert.assertEquals(1, result.size)
        Assert.assertEquals("This is a test quote", result[0].text)
    }

    @Test
    fun deleteQuotes_expectedNoResults() = runBlocking {
        val quote = Quote(0,"This is a quote", "Juan S Orozco Buitrago")
        quotesDao.insertQuote(quote)

        quotesDao.deleteAll()

        val result = quotesDao.getQuotes().getOrAwaitValue()

        assertEquals(0, result.size)
    }

    @Test
    fun getQuoteById_expectedExactResult() = runBlocking {
        val quote = Quote(0,"This is a quote test", "Juan S Orozco Buitrago")
        quotesDao.insertQuote(quote)

        val result = quotesDao.getQuoteById(1)

        assertEquals("This is a quote test", result.text)
    }

    @After
    fun tearDown() {
        quoteDatabase.close()
    }

}