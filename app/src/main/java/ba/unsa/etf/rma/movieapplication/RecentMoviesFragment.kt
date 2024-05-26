package ba.unsa.etf.rma.movieapplication
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class RecentMoviesFragment : Fragment() {
    private lateinit var recentMovies: RecyclerView
    private lateinit var recentMoviesAdapter: MovieListAdapter
    private var recentMoviesList =  arrayListOf<Movie>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view =  inflater.inflate(R.layout.fragment_recent_movies, container, false)
        recentMovies = view.findViewById(R.id.recentMovies)
        recentMovies.layoutManager = GridLayoutManager(activity, 2)
        recentMoviesAdapter = MovieListAdapter(arrayListOf()) { movie -> showMovieDetails(movie) }
        recentMovies.adapter=recentMoviesAdapter
        recentMoviesAdapter.updateMovies(recentMoviesList)
        getUpcoming()
        return view;
    }
    private fun showMovieDetails(movie: Movie) {
        val intent = Intent(activity, MovieDetailActivity::class.java).apply {
            putExtra("movie_id", movie.id)
        }
        startActivity(intent)
    }

    fun onSuccess(movies:List<Movie>){
        val toast = Toast.makeText(context, "Upcoming movies found", Toast.LENGTH_SHORT)
        toast.show()
        recentMoviesAdapter.updateMovies(movies)
    }
    fun onError() {
        val toast = Toast.makeText(context, "Search error", Toast.LENGTH_SHORT)
        toast.show()
    }
    fun getUpcoming( ){
        val scope = CoroutineScope(Job() + Dispatchers.Main)
        // Create a new coroutine on the UI thread
        scope.launch{

            MovieRepository.getUpcomingMovies2(onSuccess = ::onSuccess,
                onError = ::onError)

        }
    }

}