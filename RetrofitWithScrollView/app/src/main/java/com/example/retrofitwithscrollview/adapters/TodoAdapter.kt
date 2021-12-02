package com.example.retrofitwithscrollview.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitwithscrollview.databinding.ItemsTodoBinding
import com.example.retrofitwithscrollview.model.Todos

class TodoAdapter : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {


    inner class TodoViewHolder(val binding : ItemsTodoBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<Todos>(){
        override fun areItemsTheSame(oldItem: Todos, newItem: Todos): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Todos, newItem: Todos): Boolean {
            return oldItem == newItem
        }
    }

    private val differ =AsyncListDiffer(this,diffCallback)

    var todos : List<Todos>
        get() = differ.currentList
        set(value) {differ.submitList(value)}

    override fun getItemCount() =todos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {

        return TodoViewHolder(ItemsTodoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false))

    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {

        val items = todos[position]
        holder.binding.apply {
            tvTitle.text = items.title
            cbDone.isChecked = items.completed

        }
    }

}