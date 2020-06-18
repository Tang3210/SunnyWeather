package com.tang.sunnyweather.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.tang.sunnyweather.logic.Repository
import com.tang.sunnyweather.logic.model.Place
import kotlin.collections.ArrayList

class PlaceViewModel : ViewModel() {

    private val searchLiveData = MutableLiveData<String>()

    val placeList = ArrayList<Place>()

    val PlaceLiveData = Transformations.switchMap(searchLiveData){query ->
        Repository.searchPlaces(query)
    }

    fun searchPlaces(query: String){
        searchLiveData.value = query
    }

    fun savePlace(place: Place) = Repository.savePlace(place)

    fun getSavePlace() = Repository.getSavePlace()

    fun isPlaceSave() = Repository.isPlaceSave()
}