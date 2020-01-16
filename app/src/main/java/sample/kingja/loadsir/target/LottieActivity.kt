package sample.kingja.loadsir.target

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kingja.loadsir.core.LoadService
import com.kingja.loadsir.core.LoadSir
import sample.kingja.loadsir.PostUtil.postCallbackDelayed
import sample.kingja.loadsir.PostUtil.postSuccessDelayed
import sample.kingja.loadsir.R
import sample.kingja.loadsir.callback.LottieEmptyCallback
import sample.kingja.loadsir.callback.LottieLoadingCallback

/**
 * @author dengdai
 * @date 2020/1/10.
 * GitHub：
 * email：291996307@qq.com
 * description：
 */
class LottieActivity : AppCompatActivity() {
    private lateinit var loadService: LoadService<*>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)
        val loadSir = LoadSir.Builder()
                .addCallback(LottieLoadingCallback())
                .addCallback(LottieEmptyCallback())
                .setDefaultCallback(LottieLoadingCallback::class.java)
                .build()
        loadService = loadSir.register(this) {
            loadService.showCallback(LottieLoadingCallback::class.java)
            postSuccessDelayed(loadService, 1500)
        }
        postCallbackDelayed(loadService, LottieEmptyCallback::class.java)
    }
}