package xyz.vanduuren.playground.recycler

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat

data class Person(var fname: String, var lname: String, var role: String, var description: String, var image: Drawable) {
    companion object {
        fun getPeopleList(context: Context): List<Person> {
            val defaultRole = "Default role"
            val defaultDescription = "Default description"
            return listOf(
                    Person("Clark", "Kent", context.resources?.getString(R.string.kent_role)
                            ?: defaultRole, context.resources?.getString(R.string.kent)
                            ?: defaultDescription, ContextCompat.getDrawable(context, R.drawable.kent)!!),
                    Person("Obaro", "Ogbo", context.resources?.getString(R.string.ogbo_role)
                            ?: defaultRole, context.resources?.getString(R.string.ogbo)
                            ?: defaultDescription, ContextCompat.getDrawable(context, R.drawable.obaro)!!),
                    Person("Peter", "Parker", context.resources?.getString(R.string.parker_role)
                            ?: defaultRole, context.resources?.getString(R.string.parker)
                            ?: defaultDescription, ContextCompat.getDrawable(context, R.drawable.parker)!!),
                    Person("Barack", "Obama", context.resources?.getString(R.string.obama_role)
                            ?: defaultRole, context.resources?.getString(R.string.obama)
                            ?: defaultDescription, ContextCompat.getDrawable(context, R.drawable.obama)!!),
                    Person("Bruce", "Wayne", context.resources?.getString(R.string.wayne_role)
                            ?: defaultRole, context.resources?.getString(R.string.wayne)
                            ?: defaultDescription, ContextCompat.getDrawable(context, R.drawable.wayne)!!),
                    Person("Oliver", "Queen", context.resources?.getString(R.string.queen_role)
                            ?: defaultRole, context.resources?.getString(R.string.queen)
                            ?: defaultDescription, ContextCompat.getDrawable(context, R.drawable.queen)!!)
            )
        }
    }
}