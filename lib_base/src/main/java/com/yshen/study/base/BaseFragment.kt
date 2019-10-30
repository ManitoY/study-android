package com.yshen.study.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

/**
 * Created by Yshen
 * On 2019-10-30
 */
abstract class BaseFragment : Fragment() {

    protected val layout by lazy { View.inflate(activity, getLayoutId(), null) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        afterViews()
        return layout
    }

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun afterViews()

    protected fun <T: View> getViewById(@IdRes idRes: Int): T? {
        return layout.findViewById(idRes)
    }
}