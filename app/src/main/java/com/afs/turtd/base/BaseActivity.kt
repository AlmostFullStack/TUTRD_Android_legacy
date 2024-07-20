//package com.afs.turtd.base
//
//import android.os.Bundle
//import androidx.annotation.LayoutRes
//import androidx.appcompat.app.AppCompatActivity
//import androidx.databinding.DataBindingUtil
//import androidx.viewbinding.ViewBinding
//
//
//abstract class BaseActivity<B : ViewBinding>(@LayoutRes private val layoutResId: Int) :
//    AppCompatActivity() {
//    protected lateinit var binding: B
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = DataBindingUtil.setContentView(this, layoutResId)
//    }
//
//    abstract fun initView()
//}