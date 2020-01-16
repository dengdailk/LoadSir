package sample.kingja.loadsir.callback

import android.content.Context
import android.view.View
import android.widget.Toast
import com.kingja.loadsir.callback.Callback
import sample.kingja.loadsir.R

/**
 * @author dengdai
 * @date 2020/1/10.
 * GitHub：
 * email：291996307@qq.com
 * description：
 */
class TimeoutCallback : Callback() {
    override fun onCreateView(): Int {
        return R.layout.layout_timeout
    }

    override fun onReloadEvent(context: Context, view: View): Boolean {
        Toast.makeText(context.applicationContext, "Connecting to the network again!", Toast.LENGTH_SHORT).show()
        return false
    }
}