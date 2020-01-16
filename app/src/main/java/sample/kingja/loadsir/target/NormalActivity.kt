package sample.kingja.loadsir.target

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.kingja.loadsir.core.LoadService
import com.kingja.loadsir.core.LoadSir
import kotlinx.android.synthetic.main.layout_empty.view.*
import sample.kingja.loadsir.PostUtil.postCallbackDelayed
import sample.kingja.loadsir.R
import sample.kingja.loadsir.callback.EmptyCallback
import sample.kingja.loadsir.callback.LoadingCallback

/**
 * @author dengdai
 * @date 2020/1/10.
 * GitHub：
 * email：291996307@qq.com
 * description：
 */
class NormalActivity : AppCompatActivity() {
    private lateinit var loadService: LoadService<*>
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)
        // Your can change the callback on sub thread directly.
        loadService = LoadSir.getDefault().register(this) {
            // Your can change the status out of Main thread.
            Thread(Runnable {
                loadService.showCallback(LoadingCallback::class.java)
                //do retry logic...
                SystemClock.sleep(500)
                //callback
                loadService.showSuccess()
            }).start()
        }.setCallBack(EmptyCallback::class.java) { context: Context, view: View ->
            view.tv_empty.text = "fine, no data. You must fill it!"
        }
        postCallbackDelayed(loadService, EmptyCallback::class.java)
    }
}