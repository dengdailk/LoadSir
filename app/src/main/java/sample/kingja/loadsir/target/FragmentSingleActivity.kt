package sample.kingja.loadsir.target

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import sample.kingja.loadsir.R

/**
 * @author dengdai
 * @date 2020/1/10.
 * GitHub：
 * email：291996307@qq.com
 * description：
 */
class FragmentSingleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        supportFragmentManager.beginTransaction().add(R.id.fl_content, NormalFragment()).commit()
    }
}