package com.stiehl.recyclerview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stiehl.recyclerview.R
import com.stiehl.recyclerview.models.Person
import kotlinx.android.synthetic.main.item_person.view.*
import kotlinx.android.synthetic.main.item_person_disabled.view.*

class PersonAdapter : RecyclerView.Adapter<PersonAdapter.ViewHolder>() {
    private val people = Person.getAll().toMutableList()

    override fun getItemCount() = people.size

    override fun getItemViewType(position: Int): Int {
        val person = people[position]
        return if (person.enabled) {
            R.layout.item_person
        } else {
            R.layout.item_person_disabled
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(viewType, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person = people[position]
        holder.fillView(person)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun fillView(person: Person) {
            if (person.enabled) {
                itemView.lbTitle.text = person.title
                itemView.lbFirstName.text = person.firstName
                itemView.lbLastName.text = person.lastName
            } else {
                itemView.lbFullName.text = "${person.firstName} ${person.lastName}"
            }

            itemView.setOnClickListener {
                person.enabled = !person.enabled
                val position = people.indexOf(person)
                notifyItemChanged(position)
            }

            itemView.setOnLongClickListener {
                val position = people.indexOf(person)
                people.removeAt(position)
                notifyItemRemoved(position)
                true
            }
        }
    }
}