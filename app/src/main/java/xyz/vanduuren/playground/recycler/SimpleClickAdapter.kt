package xyz.vanduuren.playground.recycler

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import xyz.vanduuren.playground.recycler.databinding.CardListItemBinding
import xyz.vanduuren.playground.recycler.databinding.ClickListItemBinding
import xyz.vanduuren.playground.recycler.databinding.SimpleListItemBinding

class SimpleClickAdapter(var mPeople: MutableList<Person>) : RecyclerView.Adapter<SimpleClickAdapter.SimpleViewHolder>() {

    class SimpleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val clickItemBinding : ClickListItemBinding = DataBindingUtil.bind(itemView)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): SimpleViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.click_list_item, parent, false)
        return SimpleViewHolder(v)
    }

    override fun getItemCount(): Int {
        return mPeople.size
    }

    fun addPerson(person: Person): Unit {
        mPeople.add(person)
    }

    override fun onBindViewHolder(holder: SimpleViewHolder, position: Int) {
        val person = mPeople.get(position)
        holder.clickItemBinding.setVariable(BR.person, person)
        holder.clickItemBinding.executePendingBindings()
    }
}