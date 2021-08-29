package com.example.android.geektranslator

import io.reactivex.Observable

interface DataSource<T> {

    fun getData(word: String): Observable<T>
}
