package com.example.abdl.mymoviecatalogue.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.abdl.mymoviecatalogue.R
import com.example.abdl.mymoviecatalogue.utils.DataDummy
import com.example.abdl.mymoviecatalogue.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {
    private val dummyMovies = DataDummy.generateDummyMovies()
    private val dummyTvShow = DataDummy.generateDummyTvShows()

    @get:Rule
    val activtyRule = ActivityScenarioRule(HomeActivity::class.java)

    @Before
    fun setUp(){
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown(){
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun loadMovies(){
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))
    }
    @Test
    fun loadDetailMovies(){
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.text_title_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.text_title_movies)).check(matches(withText(dummyMovies[0].title)))
        onView(withId(R.id.tv_genre_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre_movies)).check(matches(withText(dummyMovies[0].genre)))
    }

    @Test
    fun loadTvShow(){
        onView(withId(R.id.navigation_tvshow)).check(matches(isDisplayed())).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))
    }

    @Test
    fun loadDetailTvShow() {
        onView(withId(R.id.navigation_tvshow)).check(matches(isDisplayed())).perform(click())
        onView(withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.text_title_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.text_title_tvshow)).check(matches(withText(dummyTvShow[0].title)))
        onView(withId(R.id.tv_creator)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_creator)).check(matches(withText(dummyTvShow[0].creator)))
    }

    @Test
    fun loadFavMovies() {
        onView(withId(R.id.navigation_favorites)).check(matches(isDisplayed())).perform(click())
        onView(withId(R.id.rv_fav_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_fav_movies)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovies.size
            )
        )
    }

    @Test
    fun loadFavTvShow() {
        onView(withId(R.id.navigation_favorites)).check(matches(isDisplayed())).perform(click())
        onView(withText("TV Shows")).perform(click())
        onView(withId(R.id.rv_fav_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_fav_tvshow)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyTvShow.size
            )
        )
    }
}