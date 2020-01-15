@file:Suppress("DEPRECATION")

package sample.kingja.loadsir.target

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import sample.kingja.loadsir.R
import java.util.*

/**
 * Description:TODO
 * Create Time:2017/9/4 10:56
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
class MultiFragmentWithViewPagerActivity : AppCompatActivity() {
    private val fragments: MutableList<Fragment> = ArrayList()
    private val tabTitles = arrayOf("Fragment A", "Fragment B")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_viewpager)
        fragments.add(FragmentA())
        fragments.add(FragmentB())
        val viewPager: ViewPager = findViewById(R.id.viewpager)
        viewPager.adapter = PagerAdapter(supportFragmentManager)
        viewPager.setCurrentItem(0)
        viewPager.offscreenPageLimit = 1
        val tabLayout: TabLayout = findViewById(R.id.tablayout)
        tabLayout.setupWithViewPager(viewPager)
        tabLayout.tabMode = TabLayout.MODE_FIXED
    }

    private inner class PagerAdapter internal constructor(fm: FragmentManager?) : FragmentPagerAdapter(fm!!) {
        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        override fun getCount(): Int {
            return fragments.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return tabTitles[position]
        }
    }
}