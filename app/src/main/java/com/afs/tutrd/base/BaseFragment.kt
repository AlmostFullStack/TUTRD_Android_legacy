//package com.afs.turtd.base
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.annotation.LayoutRes
//import androidx.databinding.DataBindingUtil
//import androidx.databinding.ViewDataBinding
//import androidx.fragment.app.Fragment
//
///**
// * binding을 간소화 하는 추상 Fragment
// *
// * Fragment 를 생성할 때 상속 받아 사용
// *
// * @param B ViewDataBinding 의 타입.
// * @property layoutResId 인플레이트할 레이아웃의 리소스 ID.
// *
// * @constructor 지정된 레이아웃 리소스 ID로 BindingFragment 를 생성.
// *
// */
//
//abstract class BaseFragment<B : ViewDataBinding>(
//    @LayoutRes private val layoutResId: Int
//) : Fragment() {
//    private var _binding: B? = null
//    protected val binding
//        get() = requireNotNull(_binding) { "binding object is not initialized" } // 바인딩 객체가 초기화 되지 않은 경우 예외 발생
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        _binding = DataBindingUtil.inflate(inflater, layoutResId, container, false)
//        return binding.root
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
//
//    /**
//     * 뷰 초기화를 위한 추상 메서드.
//     * 상속받는 클래스에서 구현하여 뷰를 설정하는 데 사용.
//     */
//    abstract fun initView()
//}