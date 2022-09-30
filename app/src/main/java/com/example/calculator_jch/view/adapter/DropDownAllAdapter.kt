package com.example.calculator_jch.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.calculator_jch.R
import com.example.calculator_jch.databinding.ItemDropDownOptionsBinding
import com.example.calculator_jch.view.model.Measurements


class DropDownAllAdapter(
    var items: ArrayList<Measurements>,
    var mListner: onItemSelectedListner
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
//        private const val TAG = "DocumentAdapter"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = DataBindingUtil.inflate<ItemDropDownOptionsBinding>(
            LayoutInflater.from(parent.context), R.layout.item_drop_down_options,
            parent, false
        )
        return ItemHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ItemHolder
        val item = items[position]
        viewHolder.binding.txtProjectType.text = item.name
        viewHolder.binding.llMain.setOnClickListener {
            mListner.onItemSelected(item)
        }
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    inner class ItemHolder(val binding: ItemDropDownOptionsBinding) :
        RecyclerView.ViewHolder(binding.root)

    interface onItemSelectedListner {
        fun onItemSelected(type: Measurements)
    }
}