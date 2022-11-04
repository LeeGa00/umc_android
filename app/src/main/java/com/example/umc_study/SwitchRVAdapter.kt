package com.example.umc_study

import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.umc_study.databinding.ItemSwitchTestBinding

class SwitchRVAdapter(private val dataList: ArrayList<MemoData>) : RecyclerView.Adapter<SwitchRVAdapter.DataViewHolder>() {
    private val switchStatus = SparseBooleanArray()

    // ViewHolder 객체
    inner class DataViewHolder(private val viewBinding: ItemSwitchTestBinding) : RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(data: MemoData) {
            viewBinding.text1.text = data.memo_title
            viewBinding.text2.text = data.memo_content

            viewBinding.switch1.isChecked = switchStatus[adapterPosition]
            viewBinding.switch1.setOnClickListener(){
                if (!viewBinding.switch1.isChecked)
                    switchStatus.put(adapterPosition, false)
                else
                    switchStatus.put(adapterPosition, true)
                notifyItemChanged(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val viewBinding = ItemSwitchTestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(viewBinding)
    }

    // ViewHolder 가 실제로 데이터를 표시해야할 때 호출
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size
}