package com.example.android.geektranslator

import com.example.android.geektranslator.view.base.View


interface Presenter<T : AppState, V : View> {

    fun attachView(view: V)

    fun detachView(view: V)

    fun getData(word: String, isOnline: Boolean)
}
