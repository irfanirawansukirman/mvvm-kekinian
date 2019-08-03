package id.pamoyanandev.khinantisticker.fmovieslist

import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.leodroidcoder.genericadapter.RecyclerviewBindableAdapter
import id.pamoyanandev.khinantisticker.androidmvvmmystarter.util.ext.horizontalListStyle
import id.pamoyanandev.khinantisticker.androidmvvmmystarter.util.ext.verticalListStyle

object MoviesListBindings {
    @BindingAdapter("app:recyclerviewData", "app:orientationList")
    @JvmStatic
    fun <T> setRecyclerviewData(
        recyclerView: RecyclerView,
        data: MutableLiveData<List<T>>,
        orientationList: Int?
    ) {
        try {
            if (recyclerView.adapter is RecyclerviewBindableAdapter<*>) {
                if (orientationList == 1) recyclerView.horizontalListStyle() else
                    recyclerView.verticalListStyle()
                (recyclerView.adapter as RecyclerviewBindableAdapter<T>)
                    .onSetListsData(data.value!!)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}