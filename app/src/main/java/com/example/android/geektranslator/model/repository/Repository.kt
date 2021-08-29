package com.example.android.geektranslator

import io.reactivex.Observable

interface Repository<T> {

    fun getData(word: String): Observable<T>
}
