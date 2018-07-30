package xyz.vanduuren.playground.recycler

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import xyz.vanduuren.playground.recycler.databinding.ActivityCardListBinding
import xyz.vanduuren.playground.recycler.databinding.ActivitySimpleListBinding

class SimpleCardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle("Simple List")

        val mSimpleListBinding = DataBindingUtil.setContentView<ActivityCardListBinding>(this, R.layout.activity_card_list)
        val people = Person.getPeopleList(this)
        val mLayoutManager = LinearLayoutManager(this)
        mSimpleListBinding.recyclerView.layoutManager = mLayoutManager

        val mAdapter = SimpleCardAdapter(people)
        mSimpleListBinding.recyclerView.adapter = mAdapter
    }
}