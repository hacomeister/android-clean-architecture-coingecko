package com.hacomeister.trackfavouritecoin.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.hacomeister.trackfavouritecoin.R
import com.hacomeister.trackfavouritecoin.util.CustomDialog

/**
 * Base class for activity instances
 */
abstract class BaseActivity : AppCompatActivity() {

    //region vars
    private lateinit var mLoadingDialog : CustomDialog
    //endregion

    /**
     * Set Layout Id
     */
    @LayoutRes
    abstract fun getLayoutId() : Int

    /**
     * Prepare UI Components here
     */
    abstract fun prepareView(savedInstanceState: Bundle?)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set Layout
        setContentView(getLayoutId())
        // Set custom dialog
        mLoadingDialog = CustomDialog(this, R.style.LoadingDialogStyle)
        // Set View
        prepareView(savedInstanceState)
    }

    //region Loading methods
    /**
     * Show progress dialog
     */
    fun showProgressDialog() {
        try {
            if (!mLoadingDialog.isShowing && !isFinishing)
                mLoadingDialog.show()
        } catch (e : Exception) {
            e.printStackTrace()
        }
    }

    /**
     * Hide progress dialog
     */
    fun hideProgressDialog() {
        try {
            if (mLoadingDialog.isShowing)
                mLoadingDialog.dismiss()
        } catch (e : Exception) {
            e.printStackTrace()
        }
    }
    //endregion

}