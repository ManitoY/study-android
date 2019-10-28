package com.yshen.study

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.yshen.study.animation.AnimationActivity
import com.yshen.study.components.ComponentsActivity
import com.yshen.study.designmodel.DesignModelActivity
import com.yshen.study.framework.FrameworkActivity
import com.yshen.study.jetpack.JetPackActivity
import com.yshen.study.network.NetworkActivity
import com.yshen.study.optimization.OptimizationActivity
import com.yshen.study.process.ProcessActivity
import com.yshen.study.storage.StorageActivity
import com.yshen.study.thread.ThreadActivity
import com.yshen.study.tools.ToolsActivity
import com.yshen.study.view.ViewActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Yshen
 * On 2019-10-24
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle(R.string.app_name)
        setContentView(R.layout.activity_main)
        setButtonClickListener(this)
    }

    private fun setButtonClickListener(l: View.OnClickListener?) {
        animationBtn.setOnClickListener(l)
        componentsBtn.setOnClickListener(l)
        designModelBtn.setOnClickListener(l)
        frameworkBtn.setOnClickListener(l)
        jetPackBtn.setOnClickListener(l)
        networkBtn.setOnClickListener(l)
        optimizationBtn.setOnClickListener(l)
        processBtn.setOnClickListener(l)
        storageBtn.setOnClickListener(l)
        threadBtn.setOnClickListener(l)
        toolsBtn.setOnClickListener(l)
        viewBtn.setOnClickListener(l)
    }

    override fun onClick(v: View?) {
        val intent = Intent()
        when(v){
            animationBtn -> intent.setClass(this, AnimationActivity::class.java)
            componentsBtn -> intent.setClass(this, ComponentsActivity::class.java)
            designModelBtn -> intent.setClass(this, DesignModelActivity::class.java)
            frameworkBtn -> intent.setClass(this, FrameworkActivity::class.java)
            jetPackBtn -> intent.setClass(this, JetPackActivity::class.java)
            networkBtn -> intent.setClass(this, NetworkActivity::class.java)
            optimizationBtn -> intent.setClass(this, OptimizationActivity::class.java)
            processBtn -> intent.setClass(this, ProcessActivity::class.java)
            storageBtn -> intent.setClass(this, StorageActivity::class.java)
            threadBtn -> intent.setClass(this, ThreadActivity::class.java)
            toolsBtn -> intent.setClass(this, ToolsActivity::class.java)
            viewBtn -> intent.setClass(this, ViewActivity::class.java)
        }
        startActivity(intent)
    }
}
