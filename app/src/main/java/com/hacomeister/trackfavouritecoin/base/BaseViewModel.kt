package com.hacomeister.trackfavouritecoin.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.hacomeister.trackfavouritecoin.TFCApplication
import com.hacomeister.trackfavouritecoin.UseCases

open class BaseViewModel(application: Application, protected val useCases: UseCases) :
    AndroidViewModel(application) {

    protected val application: TFCApplication = getApplication()

}
