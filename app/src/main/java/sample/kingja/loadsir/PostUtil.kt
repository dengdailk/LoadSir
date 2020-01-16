package sample.kingja.loadsir

import android.os.Handler
import android.os.Looper
import com.kingja.loadsir.callback.Callback
import com.kingja.loadsir.core.LoadService

/**
 * @author dengdai
 * @date 2020/1/10.
 * GitHub：
 * email：291996307@qq.com
 * description：
 */
object PostUtil {
    private const val DELAY_TIME = 1000
    @JvmStatic
    @JvmOverloads
    fun postCallbackDelayed(loadService: LoadService<*>, clazz: Class<out Callback?>?, delay: Long = DELAY_TIME.toLong()) {
        Handler(Looper.getMainLooper()).postDelayed({ loadService.showCallback(clazz) }, delay)
    }

    @JvmStatic
    @JvmOverloads
    fun postSuccessDelayed(loadService: LoadService<*>, delay: Long = DELAY_TIME.toLong()) {
        Handler(Looper.getMainLooper()).postDelayed({ loadService.showSuccess() }, delay)
    }
}