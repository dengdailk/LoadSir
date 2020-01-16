package sample.kingja.loadsir.callback

import com.kingja.loadsir.callback.Callback
import sample.kingja.loadsir.R

/**
 * @author dengdai
 * @date 2020/1/10.
 * GitHub：
 * email：291996307@qq.com
 * description：
 */
class ErrorCallback : Callback() {
    override fun onCreateView(): Int {
        return R.layout.layout_error
    }
}