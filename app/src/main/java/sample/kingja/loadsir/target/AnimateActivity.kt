package sample.kingja.loadsir.target

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.SystemClock
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kingja.loadsir.core.LoadService
import com.kingja.loadsir.core.LoadSir
import sample.kingja.loadsir.PostUtil
import sample.kingja.loadsir.R
import sample.kingja.loadsir.callback.AnimateCallback
import sample.kingja.loadsir.callback.EmptyCallback

/**
 * Description:TODO
 * Create Time:2017/9/4 10:12
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
class AnimateActivity : AppCompatActivity() {
    private lateinit var loadService: LoadService<*>
    @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)
        // Your can change the callback on sub thread directly.
        val loadSir = LoadSir.Builder()
                .addCallback(EmptyCallback())
                .addCallback(AnimateCallback())
                .setDefaultCallback(AnimateCallback::class.java)
                .build()
        loadService = loadSir.register(this) {
            // Your can change the status out of Main thread.
            Thread(Runnable {
                loadService.showCallback(AnimateCallback::class.java)
                //do retry logic...
                SystemClock.sleep(500)
                //callback on sub thread
                loadService.showSuccess()
            }).start()
        }
        Toast.makeText(this,"运行到这里",Toast.LENGTH_SHORT)
        PostUtil.postCallbackDelayed(loadService, EmptyCallback::class.java, 1000)
    }
}