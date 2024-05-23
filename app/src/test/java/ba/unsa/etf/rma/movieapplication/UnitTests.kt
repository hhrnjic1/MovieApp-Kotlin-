package ba.unsa.etf.rma.movieapplication

import org.hamcrest.CoreMatchers.`is` as Is
import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.hasItem
import org.hamcrest.Matchers.not
import org.hamcrest.beans.HasPropertyWithValue.hasProperty
import org.junit.Assert.assertEquals
import org.junit.Test


class UnitTests {
    @Test
    fun testGetFavoriteMovies(){
        val movies = getFavoriteMovies()
        assertEquals(movies.size,6)
        assertThat(movies, hasItem<Movie>(hasProperty("title", Is("Pulp Fiction"))))
        assertThat(movies, not(hasItem<Movie>(hasProperty("title", Is("Black Widow")))))
    }
}