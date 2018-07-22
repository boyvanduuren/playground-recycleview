package xyz.vanduuren.playground.recycler

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import xyz.vanduuren.playground.recycler.databinding.SimpleListItemBinding

public class SimpleListAdapter(var mPeople: List<Person>) : RecyclerView.Adapter<SimpleListAdapter.SimpleViewHolder>() {

    class SimpleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val listItemBinding : SimpleListItemBinding = DataBindingUtil.bind(itemView)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): SimpleViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.simple_list_item, parent, false)
        return SimpleViewHolder(v)
    }

    override fun getItemCount(): Int {
        return mPeople.size
    }

    override fun onBindViewHolder(holder: SimpleViewHolder, position: Int) {
        val person = mPeople.get(position)
        holder.listItemBinding.setVariable(BR.person, person)
        holder.listItemBinding.executePendingBindings()
    }
}