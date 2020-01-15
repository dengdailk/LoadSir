package sample.kingja.loadsir.target

import android.annotation.SuppressLint
import android.view.View
import kotlinx.android.synthetic.main.activity_content.*
import sample.kingja.loadsir.PostUtil.postCallbackDelayed
import sample.kingja.loadsir.PostUtil.postSuccessDelayed
import sample.kingja.loadsir.R
import sample.kingja.loadsir.base.BaseTitleActivity
import sample.kingja.loadsir.callback.ErrorCallback
import sample.kingja.loadsir.callback.LoadingCallback

/**
 * Description:
 * Create Time:2017/9/4 10:56
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
open class KeepTitleActivity : BaseTitleActivity() {

    override val contentTitle: String
        get() = "Title"

    override val contentView: Int
        get() = R.layout.activity_content

    @SuppressLint("SetTextI18n")
    override fun initView() {
        tv_subTitle.text = "Keep Title In Activity"
        tv_title.text = "Yes, Success"
    }

    override fun initNet() {
        postCallbackDelayed(this.mBaseLoadService, ErrorCallback::class.java)
    }

    override fun onNetReload(v: View?) {
        mBaseLoadService.showCallback(LoadingCallback::class.java)
        postSuccessDelayed(mBaseLoadService)
    }
}