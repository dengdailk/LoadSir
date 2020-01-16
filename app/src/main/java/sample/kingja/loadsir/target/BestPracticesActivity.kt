package sample.kingja.loadsir.target

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_best_practices.*
import sample.kingja.loadsir.R

/**
 * @author dengdai
 * @date 2020/1/10.
 * GitHub：
 * email：291996307@qq.com
 * description：
 */
class BestPracticesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_best_practices)
        onLottie.setOnClickListener {  startActivity(Intent(this, LottieActivity::class.java)) }
    }

}