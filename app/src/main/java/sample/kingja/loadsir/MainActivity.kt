package sample.kingja.loadsir

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import sample.kingja.loadsir.target.*

/**
 * Description:TODO
 * Create Time:2017/9/2 16:02
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inActivity.setOnClickListener { startActivity(Intent(this, NormalActivity::class.java)) }
        showPlaceholder.setOnClickListener { startActivity(Intent(this, PlaceholderActivity::class.java)) }
        inActivityWithConvertor.setOnClickListener { startActivity(Intent(this, ConvertorActivity::class.java)) }
        inFragment.setOnClickListener { startActivity(Intent(this, FragmentSingleActivity::class.java)) }
        inFragmentMutil.setOnClickListener { startActivity(Intent(this, MultiFragmentActivity::class.java)) }
        inFragmentViewSirPager.setOnClickListener { startActivity(Intent(this, MultiFragmentWithViewPagerActivity::class.java)) }
        inView.setOnClickListener { startActivity(Intent(this, ViewTargetActivity::class.java)) }
        defaultCallback.setOnClickListener { startActivity(Intent(this, DefaultCallbackActivity::class.java)) }
        animatCallback.setOnClickListener { startActivity(Intent(this, AnimateActivity::class.java)) }
        keepTitleInFragment.setOnClickListener { startActivity(Intent(this, KeepTitleFragmentActivity::class.java)) }
        bestPractices.setOnClickListener { startActivity(Intent(this, BestPracticesActivity::class.java)) }
        keepTitleInActivity.setOnClickListener { startActivity(Intent(this, KeepTitleActivity::class.java)) }
    }
}