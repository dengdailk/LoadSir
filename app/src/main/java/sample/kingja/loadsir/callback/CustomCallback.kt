package sample.kingja.loadsir.callback

import android.content.Context
import android.view.View
import android.widget.Toast
import com.kingja.loadsir.callback.Callback
import kotlinx.android.synthetic.main.layout_custom.view.*
import sample.kingja.loadsir.R

/**
 * @author dengdai
 * @date 2020/1/10.
 * GitHub：
 * email：291996307@qq.com
 * description：
 */
class CustomCallback : Callback() {
    override fun onCreateView(): Int {
        return R.layout.layout_custom
    }

    override fun onReloadEvent(context: Context, view: View): Boolean {
        Toast.makeText(context.applicationContext, "Hello buddy, how r u! :p", Toast.LENGTH_SHORT).show()
        view.iv_gift.setOnClickListener { Toast.makeText(context.applicationContext, "It's your gift!", Toast.LENGTH_SHORT).show() }
        return true
    }
}