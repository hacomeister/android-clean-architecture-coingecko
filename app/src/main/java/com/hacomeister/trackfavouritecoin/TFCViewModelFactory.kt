package com.hacomeister.trackfavouritecoin

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hacomeister.trackfavouritecoin.base.BaseViewModel

object TFCViewModelFactory : ViewModelProvider.Factory {

    lateinit var application: Application

    lateinit var dependencies: UseCases

    fun inject(application: Application, dependencies: UseCases) {
        TFCViewModelFactory.application = application
        TFCViewModelFactory.dependencies = dependencies
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(BaseViewModel::class.java.isAssignableFrom(modelClass)) {
            return modelClass.getConstructor(Application::class.java, UseCases::class.java)
                .newInstance(
                    application,
                    dependencies
                )
        } else {
            throw IllegalStateException("ViewModel must extend bASEViewModel")
        }
    }

}
