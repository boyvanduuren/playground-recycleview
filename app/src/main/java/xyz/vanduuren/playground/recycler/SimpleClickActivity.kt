package xyz.vanduuren.playground.recycler

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Button
import xyz.vanduuren.playground.recycler.databinding.ActivityClickListBinding

class SimpleClickActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle("Simple List")

        val mClickBinding = DataBindingUtil.setContentView<ActivityClickListBinding>(this, R.layout.activity_click_list)
        mClickBinding.recyclerView.setHasFixedSize(true)
        val mLayoutManager = LinearLayoutManager(this)
//        val mLayoutManager = GridLayoutManager(this, 2)
        mClickBinding.recyclerView.layoutManager = mLayoutManager

        val people = Person.getPeopleList(this)

        val mAdapter = SimpleClickAdapter(people)
        mClickBinding.recyclerView.adapter = mAdapter

        mClickBinding.insertFAB.setOnClickListener { view ->
            mAdapter.addPerson(Person.getRandom(this))
            mLayoutManager.scrollToPositionWithOffset(0, 0)
        }
    }
}