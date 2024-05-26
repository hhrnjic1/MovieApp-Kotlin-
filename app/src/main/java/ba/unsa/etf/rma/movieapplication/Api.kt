package ba.unsa.etf.rma.movieapplication

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("api_key") apiKey: String = "5fc1daf303e9627351f99829f46f170d"
    ): Response<GetMoviesResponse>
    @GET("movie/{id}")
    suspend fun getMovie(@Path("id") id:Long,
                         @Query("api_key") apiKey: String = "5fc1daf303e9627351f99829f46f170d"
    ): Response<Movie>

    @GET("movie/latest")
    suspend fun getLatestMovie(
        @Query("api_key") apiKey: String = "5fc1daf303e9627351f99829f46f170d"
    ): Response<Movie>
    @GET("search/movie")
    suspend fun searchMovie(
        @Query("query") query: String,
        @Query("api_key") apiKey: String = "5fc1daf303e9627351f99829f46f170d"
    ): Response<GetMoviesResponse>
    @GET("movie/upcoming")
    fun getUpcomingMovies2(
        @Query("api_key") apiKey: String = "5fc1daf303e9627351f99829f46f170d"
    ): Call<GetMoviesResponse>
}