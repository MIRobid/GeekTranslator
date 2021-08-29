package com.example.android.geektranslator.view.main

import androidx.lifecycle.LiveData
import com.example.android.geektranslator.AppState
import com.example.android.geektranslator.DataSourceLocal
import com.example.android.geektranslator.DataSourceRemote
import com.example.android.geektranslator.RepositoryImplementation
import com.example.android.geektranslator.view.base.BaseViewModel
import io.reactivex.observers.DisposableObserver

class MainViewModel (
    private val interactor: MainInteractor = MainInteractor(
            RepositoryImplementation(DataSourceRemote()),
            RepositoryImplementation(DataSourceLocal())
    )
) : BaseViewModel<AppState>(){

        private var appState: AppState? = null

        override fun getData(word: String, isOnline: Boolean): LiveData<AppState> {
            compositeDisposable.add(
                    interactor.getData(word, isOnline)
                            .subscribeOn(schedulerProvider.io())
                            .observeOn(schedulerProvider.ui())
                            .doOnSubscribe { liveDataForViewToObserve.value = AppState.Loading(null) }
                            .subscribeWith(getObserver())
            )
            return super.getData(word, isOnline)
        }

        private fun getObserver(): DisposableObserver<AppState> {
            return object : DisposableObserver<AppState>() {

                override fun onNext(state: AppState) {
                    appState = state
                    liveDataForViewToObserve.value = state
                }

                override fun onError(e: Throwable) {
                    liveDataForViewToObserve.value = AppState.Error(e)
                }

                override fun onComplete() {
                }
            }
        }
    }