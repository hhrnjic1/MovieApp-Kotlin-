package ba.unsa.etf.rma.movieapplication

import androidx.room.*

@Dao
interface MovieDao {
    @Query("SELECT * FROM movie WHERE favourite=1")
    suspend fun getAll(): List<Movie>

    @Query("SELECT * FROM movie WHERE id=:id AND favourite=1 LIMIT 1")
    suspend fun findById(id: Long): Movie

    @Insert
    suspend fun insertAll(vararg movies: Movie)

    @Delete
    suspend fun delete(movie: Movie)



}