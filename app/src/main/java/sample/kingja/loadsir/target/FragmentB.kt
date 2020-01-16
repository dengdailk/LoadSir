package sample.kingja.loadsir.target

import android.annotation.SuppressLint
import android.view.View
import android.widget.Toast
import sample.kingja.loadsir.PostUtil.postCallbackDelayed
import sample.kingja.loadsir.PostUtil.postSuccessDelayed
import sample.kingja.loadsir.R
import sample.kingja.loadsir.base.BaseFragment
import sample.kingja.loadsir.callback.EmptyCallback
import sample.kingja.loadsir.callback.LoadingCallback

/**
 * @author dengdai
 * @date 2020/1/10.
 * GitHub：
 * email：291996307@qq.com
 * description：
 */
class FragmentB : BaseFragment() {
    override fun onCreateFragmentView(): Int {
        return R.layout.fragment_b_content
    }

    override fun loadNet() {
        postCallbackDelayed(mBaseLoadService, EmptyCallback::class.java)
    }

    @SuppressLint("SetTextI18n")
    override fun onNetReload(v: View?) {
//        val tvResultB:TextView = v!!.findViewById(R.id.tv_result_b)
//        tv_result_b.text = "Oh, Yes too."
        Toast.makeText(context, "reload in Fragment B", Toast.LENGTH_SHORT).show()
        mBaseLoadService.showCallback(LoadingCallback::class.java)
        postSuccessDelayed(mBaseLoadService)
    }
}