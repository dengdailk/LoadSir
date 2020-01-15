package sample.kingja.loadsir.callback

import android.content.Context
import android.view.View
import android.widget.Toast
import com.kingja.loadsir.callback.Callback
import sample.kingja.loadsir.R

/**
 * Description:TODO
 * Create Time:2017/9/2 16:17
 * Author:KingJA
 * Email:kingjavip@gmail.com
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