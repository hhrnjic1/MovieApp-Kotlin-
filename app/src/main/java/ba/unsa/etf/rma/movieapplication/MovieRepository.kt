package ba.unsa.etf.rma.movieapplication

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL


sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}

object MovieRepository {

    private const val tmdb_api_key : String = "5fc1daf303e9627351f99829f46f170d"

    suspend fun searchRequest(
        query: String
    ) : GetMoviesResponse?{
        return withContext(Dispatchers.IO) {
            var response = ApiAdapter.retrofit.searchMovie(query)
            val responseBody = response.body()
            return@withContext responseBody
        }
    }



    suspend fun getFavoriteMovies(context: Context) : List<Movie> {
        return withContext(Dispatchers.IO) {
            var db = AppDatabase.getInstance(context)
            var movies = db!!.movieDao().getAll()
            return@withContext movies
        }
    }
    suspend fun writeFavorite(context: Context,movie:Movie) : String?{
        return withContext(Dispatchers.IO) {
            try{
                var db = AppDatabase.getInstance(context)
                db!!.movieDao().insertAll(movie)
                return@withContext "success"
            }
            catch(error:Exception){
                return@withContext null
            }
        }
    }
    suspend fun getUpcomingMovies(
    ) : GetMoviesResponse?{
        return withContext(Dispatchers.IO) {
            var response = ApiAdapter.retrofit.getUpcomingMovies()
            val responseBody = response.body()
            return@withContext responseBody
        }
    }

    suspend fun getMovie(id: Long
    ) : Movie?{
        return withContext(Dispatchers.IO) {
            var response = ApiAdapter.retrofit.getMovie(id)
            val responseBody = response.body()
            return@withContext responseBody
        }
    }


    fun getUpcomingMovies2(
        onSuccess: (movies: List<Movie>) -> Unit,
        onError: () -> Unit
    ) {
        ApiAdapter.retrofit.getUpcomingMovies2()
            .enqueue(object : Callback<GetMoviesResponse> {
                override fun onResponse(
                    call: Call<GetMoviesResponse>,
                    response: Response<GetMoviesResponse>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()

                        if (responseBody != null) {
                            onSuccess.invoke(responseBody.movies)
                        } else {
                            onError.invoke()
                        }
                    } else {
                        onError.invoke()
                    }
                }

                override fun onFailure(call: Call<GetMoviesResponse>, t: Throwable) {
                    onError.invoke()
                }
            })
    }

}