package com.example.umc_study

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.umc_study.databinding.ItemMemoListBinding

class MemoDataRVAdapter(private val dataList: ArrayList<MemoData>) : RecyclerView.Adapter<MemoDataRVAdapter.DataViewHolder>() {

    // ViewHolder 객체
    inner class DataViewHolder(private val viewBinding: ItemMemoListBinding) : RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(data: MemoData) {
            viewBinding.memoTitle.text = data.memo_title
            viewBinding.memoContent.text = data.memo_content
        }
    }

    // ViewHolder 만들어질 때 실행할 동작
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val viewBinding = ItemMemoListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(viewBinding)
    }

    // ViewHolder 가 실제로 데이터를 표시해야할 때 호출
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(dataList[position])
        holder.itemView.setOnClickListener() {
            mItemClickListener.onItemClick(dataList[position])
            mItemClickListener.onRemoveAlbum(position)
        }
    }

    // 표한할 item 의 총 개수
    override fun getItemCount(): Int = dataList.size

    interface MyItemClickListener{
        fun onItemClick(memo : MemoData)
        fun onRemoveAlbum(position: Int)
    }

    // listener 객체 전달 받는 함수 & 저장하는 변수
    private lateinit var mItemClickListener: MemoDataRVAdapter.MyItemClickListener

    fun setMyItemClickListener(itemClickListener: MemoDataRVAdapter.MyItemClickListener){
        mItemClickListener = itemClickListener
    }

    fun removeItem(position: Int) {
        dataList.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, getItemCount());
    }

}