package sample.kingja.loadsir.target

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_best_practices.*
import sample.kingja.loadsir.R

/**
 * Description:TODO
 * Create Time:2017/9/29 13:54
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
class BestPracticesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_best_practices)
        onLottie.setOnClickListener {  startActivity(Intent(this, LottieActivity::class.java)) }
    }

}