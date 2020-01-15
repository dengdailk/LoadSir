package sample.kingja.loadsir.target

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.kingja.loadsir.callback.Callback.OnReloadListener
import com.kingja.loadsir.callback.HintCallback
import com.kingja.loadsir.callback.ProgressCallback
import com.kingja.loadsir.core.LoadService
import com.kingja.loadsir.core.LoadSir
import sample.kingja.loadsir.PostUtil.postCallbackDelayed
import sample.kingja.loadsir.PostUtil.postSuccessDelayed
import sample.kingja.loadsir.R

/**
 * Description:TODO
 * Create Time:2017/9/4 10:12
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
class DefaultCallbackActivity : AppCompatActivity() {
    private lateinit var loadService: LoadService<*>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)
        val loadingCallback = ProgressCallback.Builder()
                .setTitle("Loading", R.style.Hint_Title)
//                .setAboveSuccess(true) // attach loadingView above successView
                .build()
        val hintCallback = HintCallback.Builder()
                .setTitle("Error", R.style.Hint_Title)
                .setSubTitle("Sorry, buddy, I will try it again.")
                .setHintImg(R.drawable.error)
                .build()
        val loadSir = LoadSir.Builder()
                .addCallback(loadingCallback)
                .addCallback(hintCallback)
                .setDefaultCallback(ProgressCallback::class.java)
                .build()
        loadService = loadSir.register(this) {
            loadService.showCallback(ProgressCallback::class.java)
            postSuccessDelayed(loadService)
        }
        postCallbackDelayed(loadService, HintCallback::class.java)
    }
}