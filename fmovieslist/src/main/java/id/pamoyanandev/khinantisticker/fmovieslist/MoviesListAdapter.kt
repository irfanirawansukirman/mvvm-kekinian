package id.pamoyanandev.khinantisticker.fmovieslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.leodroidcoder.genericadapter.RecyclerviewBindableAdapter
import id.pamoyanan_dev.khinantisticker.f_movies_list.databinding.MoviesItemBinding
import id.pamoyanandev.khinantisticker.androidmvvmmystarter.data.model.Result

class MoviesListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(),
    RecyclerviewBindableAdapter<Result> {

    var data = emptyList<Result>()

    override fun onSetListsData(data: List<Result>) {
        this.data = data

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MoviesVH(
            MoviesItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MoviesVH).bindItem(data[position])
    }

    class MoviesVH(val moviesItemBinding: MoviesItemBinding) :
        RecyclerView.ViewHolder(moviesItemBinding.root) {
        fun bindItem(item: Result) {
            moviesItemBinding.apply {
                 this.item = item
            }
        }
    }
}