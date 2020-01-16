package sample.kingja.loadsir.target

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.kingja.loadsir.core.LoadService
import com.kingja.loadsir.core.LoadSir
import kotlinx.android.synthetic.main.activity_view.*
import sample.kingja.loadsir.PostUtil.postCallbackDelayed
import sample.kingja.loadsir.PostUtil.postSuccessDelayed
import sample.kingja.loadsir.R
import sample.kingja.loadsir.callback.LoadingCallback
import sample.kingja.loadsir.callback.TimeoutCallback

/**
 * @author dengdai
 * @date 2020/1/10.
 * GitHub：
 * email：291996307@qq.com
 * description：
 */
class ViewTargetActivity : AppCompatActivity() {
    private lateinit var loadService: LoadService<*>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)
        val loadSir = LoadSir.Builder()
                .addCallback(TimeoutCallback())
                .addCallback(LoadingCallback())
                .setDefaultCallback(LoadingCallback::class.java)
                .build()
        loadService = loadSir.register(iv_img) {
            loadService.showCallback(LoadingCallback::class.java)
            postSuccessDelayed(loadService)
        }
        postCallbackDelayed(loadService, TimeoutCallback::class.java)
    }
}