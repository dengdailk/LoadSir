package sample.kingja.loadsir.callback

import com.kingja.loadsir.callback.Callback
import sample.kingja.loadsir.R

/**
 * Description:TODO
 * Create Time:2017/9/4 10:22
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
class EmptyCallback : Callback() {
    override fun onCreateView(): Int {
        return R.layout.layout_empty
    }
}