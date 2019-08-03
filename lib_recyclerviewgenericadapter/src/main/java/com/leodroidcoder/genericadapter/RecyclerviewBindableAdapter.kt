package com.leodroidcoder.genericadapter

interface RecyclerviewBindableAdapter<T> {
    fun onSetListsData(data: List<T>)
}