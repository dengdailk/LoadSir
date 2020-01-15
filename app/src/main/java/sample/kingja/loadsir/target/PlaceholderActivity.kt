package sample.kingja.loadsir.target

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kingja.loadsir.core.LoadService
import com.kingja.loadsir.core.LoadSir
import sample.kingja.loadsir.PostUtil.postSuccessDelayed
import sample.kingja.loadsir.R
import sample.kingja.loadsir.callback.PlaceholderCallback

/**
 * Description:TODO
 * Create Time:2017/9/3 11:22
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
class PlaceholderActivity : AppCompatActivity() {
    private lateinit var loadService: LoadService<*>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_placeholder)
        val loadSir = LoadSir.Builder()
                .addCallback(PlaceholderCallback())
                .setDefaultCallback(PlaceholderCallback::class.java)
                .build()
        loadService = loadSir.register(this) {
            //do retry logic...
        }
        postSuccessDelayed(loadService, 1000)
    }
}