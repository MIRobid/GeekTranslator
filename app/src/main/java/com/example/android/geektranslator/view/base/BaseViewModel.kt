package com.example.android.geektranslator.view.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.geektranslator.AppState
import com.example.android.geektranslator.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel<T : AppState>(
        protected val liveDataForViewToObserve: MutableLiveData<T> = MutableLiveData(),
        protected val compositeDisposable: CompositeDisposable = CompositeDisposable(),
        protected val schedulerProvider: SchedulerProvider = SchedulerProvider()
) : ViewModel() {

    open fun getData(word: String, isOnline: Boolean): LiveData<T> = liveDataForViewToObserve

    override fun onCleared() {
        compositeDisposable.clear()
    }
}