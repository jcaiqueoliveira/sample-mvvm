package sample.kanda.mvvm.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_layout_home_list.view.*
import sample.kanda.mvvm.R


        /**
         * Created by jcosilva on 2/7/2018.
         */
typealias ContactList = List<ContactPresentation>

class Adapter(private val contacts: ContactList) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_layout_home_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        contacts[position].apply {
            holder.setItem(this)
        }
    }

}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun setItem(item: ContactPresentation) {
        itemView.apply {
            nameProperty.text = item.propertyName
            companyName.text = item.companyName
            initialsName.text = item.getInitials()
        }
    }
}
