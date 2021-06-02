package com.cendekia.capstone.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cendekia.capstone.R
import com.cendekia.capstone.data.source.models.MyTrainResponse
import com.cendekia.capstone.databinding.ItemPostBinding

class PostAdapter(private val list: ArrayList<MyTrainResponse>):RecyclerView.Adapter<PostAdapter.PostViewHolder>(){
    fun setData(newListData:  ArrayList<MyTrainResponse>?) {
        if (newListData == null) return
        list.clear()
        list.addAll(newListData)
        notifyDataSetChanged()
    }

    inner class PostViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        private val binding = ItemPostBinding.bind(itemView)
        fun bind(myTrainRespone : MyTrainResponse){
            with(binding){
                this.tvGrade.text ="Id: ${myTrainRespone.id}\n"+
                        "Damage Grade : ${myTrainRespone.damageGrade}"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}