package com.example.android.geektranslator.view.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.anikin.aleksandr.simplevocabulary.viewmodel.Interactor
import com.example.android.geektranslator.AppState
import com.example.android.geektranslator.Presenter

abstract class BaseActivity<T : AppState, I : Interactor<T>> : AppCompatActivity(){
    abstract val model: BaseViewModel<T>

    abstract fun renderData(dataModel: T)
}

/*View {

    protected lateinit var presenter: Presenter<T, View>

    protected abstract fun createPresenter(): Presenter<T, View>

    abstract override fun renderData(appState: AppState)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = createPresenter()
    }

    override fun onStart() {
        super.onStart()
        presenter.attachView(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.detachView(this)
    }
}

 */
