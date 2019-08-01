package id.pamoyanandev.khinantisticker.androidmvvmmystarter.util

interface NavigationRoute {
    fun onMoviesListRoute(): String
    fun onMovieDetailRoute(): String

    companion object {
        const val BASE_PACKAGE = "id.pamoyanandev.khinantisticker."

        const val F_MOVIES_LIST = "fmovieslist.MoviesListActivity"
        const val F_MOVIE_DETAIL = "fmoviedetail.MovieDetailActivity"
    }
}