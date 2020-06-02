package com.tang.sunnyweather.ui.place

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.tang.sunnyweather.R
import com.tang.sunnyweather.logic.model.Place
import com.tang.sunnyweather.util.toast
import kotlinx.android.synthetic.main.fragment_place.*

class PlaceFragment : Fragment() {

    val viewModel by lazy { ViewModelProvider(this)[PlaceViewModel::class.java] }

    private lateinit var adapter: PlaceAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_place, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = PlaceAdapter(this, viewModel.placeList)
        recyclerView.adapter = adapter
        searchPlaceEdit.addTextChangedListener { editable ->
            val content = editable.toString()
            content.toast()
            if (content.isNotEmpty()){
                viewModel.searchPlaces(content)
            } else {
                recyclerView.visibility = View.GONE
                bgImageView.visibility = View.VISIBLE
                viewModel.placeList.clear()
                adapter.notifyDataSetChanged()
            }
        }

        viewModel.PlaceLiveData.observe(viewLifecycleOwner, Observer {
            val place = it.getOrNull()
            if (place != null){
                recyclerView.visibility = View.VISIBLE
                bgImageView.visibility = View.GONE
                viewModel.placeList.clear()
                viewModel.placeList.addAll(place)
                adapter.notifyDataSetChanged()
            }else{
                toast("未能查询到任何地点")
                it.exceptionOrNull()?.printStackTrace()
            }
        })
    }
}