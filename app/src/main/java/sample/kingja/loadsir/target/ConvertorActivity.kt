package sample.kingja.loadsir.target

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.kingja.loadsir.callback.Callback
import com.kingja.loadsir.callback.SuccessCallback
import com.kingja.loadsir.core.LoadService
import com.kingja.loadsir.core.LoadSir
import sample.kingja.loadsir.PostUtil.postCallbackDelayed
import sample.kingja.loadsir.R
import sample.kingja.loadsir.callback.EmptyCallback
import sample.kingja.loadsir.callback.ErrorCallback
import sample.kingja.loadsir.callback.LoadingCallback
import java.util.*

/**
 * @author dengdai
 * @date 2020/1/10.
 * GitHub：
 * email：291996307@qq.com
 * description：
 */
class ConvertorActivity : AppCompatActivity() {
    private lateinit var loadService: LoadService<*>
    private val mHttpResult = HttpResult(Random().nextInt(2), ArrayList())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activity_convertor)
        val loadSir = LoadSir.Builder()
                .addCallback(LoadingCallback())
                .addCallback(EmptyCallback())
                .addCallback(ErrorCallback())
                .setDefaultCallback(LoadingCallback::class.java)
                .build()
        loadService = loadSir.register<HttpResult>(this, {
            loadService.showCallback(LoadingCallback::class.java)
            postCallbackDelayed(loadService, SuccessCallback::class.java)
        }) { httpResult ->
            var resultCode: Class<out Callback?> = when (httpResult.resultCode) {
                SUCCESS_CODE -> if (httpResult.data.isEmpty()) {
                    EmptyCallback::class.java
                } else {
                    SuccessCallback::class.java
                }
                ERROR_CODE -> ErrorCallback::class.java
                else -> ErrorCallback::class.java
            }
            resultCode
        }
        Handler().postDelayed({
            loadService.showWithConvertor(mHttpResult)
        }, 500)
    }

    private inner class HttpResult internal constructor(val resultCode: Int, val data: List<Any?>)

    companion object {
        private const val SUCCESS_CODE = 0x00
        private const val ERROR_CODE = 0x01
    }
}