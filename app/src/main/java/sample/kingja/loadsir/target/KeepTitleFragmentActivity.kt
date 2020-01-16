package sample.kingja.loadsir.target

import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import sample.kingja.loadsir.R

/**
 * @author dengdai
 * @date 2020/1/10.
 * GitHub：
 * email：291996307@qq.com
 * description：
 */
class KeepTitleFragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_fragment)
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
        supportFragmentManager.beginTransaction().add(R.id.fl_content, KeepTitleFragment()).commit()
    }
}