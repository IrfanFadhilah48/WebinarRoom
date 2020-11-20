package com.bisaai.webinarroom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_user.view.*

class UserAdapter (
    var dataUser: MutableList<UserEntity>,
    val onItemClick: (data: UserEntity, position: Int, check: Int) -> Unit
): RecyclerView.Adapter<UserAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_user, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = dataUser.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataUser[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: UserEntity){
            with(itemView){
                tvUserNisn.text = data.nisn
                tvUserNama.text = data.nama
                tvUserKelas.text = data.kelas
                tvUserAlamat.text = data.alamat

                setOnClickListener {
                    onItemClick(data, adapterPosition, 1)
                }
                ivUserDelete.setOnClickListener {
                    onItemClick(data, adapterPosition, 2)
                }
            }
        }
    }
}