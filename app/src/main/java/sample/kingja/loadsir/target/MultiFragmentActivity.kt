package sample.kingja.loadsir.target

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import sample.kingja.loadsir.R

/**
 * Description:TODO
 * Create Time:2017/9/4 10:56
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
class MultiFragmentActivity : AppCompatActivity() {
    private lateinit var fragmentA: FragmentA
    private lateinit var fragmentB: FragmentB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_mutil)
        fragmentA = FragmentA()
        fragmentB = FragmentB()
        supportFragmentManager.beginTransaction().add(R.id.fl_content, fragmentA).commit()
        supportFragmentManager.beginTransaction().add(R.id.fl_content, fragmentB).commit()
        supportFragmentManager.beginTransaction().show(fragmentA).hide(fragmentB).commit()
        val showFragmentA: Button = findViewById(R.id.showFragmentA)
        showFragmentA.setOnClickListener { supportFragmentManager.beginTransaction().show(fragmentA).hide(fragmentB).commit() }
        val showFragmentB: Button = findViewById(R.id.showFragmentB)
        showFragmentB.setOnClickListener { supportFragmentManager.beginTransaction().show(fragmentB).hide(fragmentA).commit() }
    }
}