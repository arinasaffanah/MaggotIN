package com.capstone.maggotin.ui.bookmark

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BookmarksViewModel : ViewModel() {

//    private val _text = MutableLiveData<String>().apply {
//        value = "This is bookmarks Fragment"
//    }
//    val text: LiveData<String> = _text

    private val _bookmarkList = MutableLiveData<List<String>>()
    val bookmarkList: LiveData<List<String>> = _bookmarkList

    init {
        _bookmarkList.value = emptyList()
    }

    fun updateBookmarks(newBookmarks: List<String>) {
        _bookmarkList.value = newBookmarks
    }
}