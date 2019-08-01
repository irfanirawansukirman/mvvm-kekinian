package id.pamoyanandev.khinantisticker.androidmvvmmystarter.util

import id.pamoyanandev.khinantisticker.androidmvvmmystarter.util.NavigationRoute.Companion.BASE_PACKAGE
import id.pamoyanandev.khinantisticker.androidmvvmmystarter.util.NavigationRoute.Companion.F_MOVIES_LIST
import id.pamoyanandev.khinantisticker.androidmvvmmystarter.util.NavigationRoute.Companion.F_MOVIE_DETAIL

object NavigationRouteImpl : NavigationRoute {

    override fun onMoviesListRoute(): String {
        return BASE_PACKAGE + F_MOVIES_LIST
    }

    override fun onMovieDetailRoute(): String {
        return BASE_PACKAGE + F_MOVIE_DETAIL
    }

}