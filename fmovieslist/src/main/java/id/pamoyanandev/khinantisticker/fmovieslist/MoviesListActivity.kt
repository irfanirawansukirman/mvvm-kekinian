package id.pamoyanandev.khinantisticker.fmovieslist

import id.pamoyanan_dev.khinantisticker.f_movies_list.R
import id.pamoyanan_dev.khinantisticker.f_movies_list.databinding.MoviesListActivityBinding
import id.pamoyanandev.khinantisticker.androidmvvmmystarter.App
import id.pamoyanandev.khinantisticker.androidmvvmmystarter.base.BaseActivityWithVM
import id.pamoyanandev.khinantisticker.androidmvvmmystarter.util.ext.getViewModel
import kotlinx.android.synthetic.main.movies_list_activity.*

class MoviesListActivity : BaseActivityWithVM<MoviesListActivityBinding, MoviesListVM>() {

    override fun bindLayoutRes() = R.layout.movies_list_activity

    override fun bindToolbarId() = EMPTY_TOOLBAR

    override fun onSetViewModel(): MoviesListVM {
        return getViewModel { MoviesListVM(App.instance) }
    }

    override fun onLoadObserver(baseViewModel: MoviesListVM) {

    }

    override fun onStartWork() {
        setupMoviesList()
    }

    override fun onSetInstrument() {
        baseViewModel.let {
            viewBinding.apply {
                lifecycleOwner = this@MoviesListActivity
                viewModel = it
            }
        }
    }

    override fun bindRootFragment(): Nothing? = null

    override fun bindFragmentContainerId(): Nothing? = null

    private fun setupMoviesList() {
        recycler_moviesList.adapter = MoviesListAdapter()
    }

}