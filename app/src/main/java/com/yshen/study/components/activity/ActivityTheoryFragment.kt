package com.yshen.study.components.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yshen.study.R

/**
 * Created by Yshen
 * On 2019-10-29
 */
class ActivityTheoryFragment : Fragment() {

    private val layout by lazy { View.inflate(activity, R.layout.fragment_activity_theory, null) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layout
    }
}