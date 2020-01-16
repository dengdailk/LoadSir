package sample.kingja.loadsir.target

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_a_content.*
import sample.kingja.loadsir.PostUtil.postCallbackDelayed
import sample.kingja.loadsir.PostUtil.postSuccessDelayed
import sample.kingja.loadsir.R
import sample.kingja.loadsir.base.BaseFragment
import sample.kingja.loadsir.callback.ErrorCallback
import sample.kingja.loadsir.callback.LoadingCallback

/**
 * @author dengdai
 * @date 2020/1/10.
 * GitHub：
 * email：291996307@qq.com
 * description：
 */
class FragmentA : BaseFragment() {

    override fun onCreateFragmentView(): Int {
        return R.layout.fragment_a_content
    }

    override fun loadNet() {
        postCallbackDelayed(mBaseLoadService, ErrorCallback::class.java)
    }

    @SuppressLint("SetTextI18n")
    override fun onNetReload(v: View?) {
//        val tvResultA:TextView = v!!.findViewById(R.id.tv_result_a)
        tv_result_a.text = "Oh, Yes."
        Toast.makeText(context, "reload in Fragment A", Toast.LENGTH_SHORT).show()
        mBaseLoadService.showCallback(LoadingCallback::class.java)
        postSuccessDelayed(mBaseLoadService)
    }
}