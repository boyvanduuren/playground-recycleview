package xyz.vanduuren.playground.recycler

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import xyz.vanduuren.playground.recycler.databinding.ActivitySimpleListBinding

class SimpleListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle("Simple List")

        val mSimpleListBinding = DataBindingUtil.setContentView<ActivitySimpleListBinding>(this, R.layout.activity_simple_list)
        val people = Person.getPeopleList(this)
        val mLayoutManager = LinearLayoutManager(this)
        mSimpleListBinding.recyclerView.layoutManager = mLayoutManager

        val mAdapter = SimpleListAdapter(people)
        mSimpleListBinding.recyclerView.adapter = mAdapter
    }
}