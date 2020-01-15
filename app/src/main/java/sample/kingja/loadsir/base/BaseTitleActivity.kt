package sample.kingja.loadsir.base

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.kingja.loadsir.core.LoadService
import com.kingja.loadsir.core.LoadSir
import kotlinx.android.synthetic.main.activity_title.*
import sample.kingja.loadsir.R

/**
 * Description：TODO
 * Create Time：2017/3/20 14:17
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
abstract class BaseTitleActivity : AppCompatActivity() {
    private lateinit var rootView : View
    lateinit var mBaseLoadService: LoadService<*>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rootView = View.inflate(this, R.layout.activity_title, null)
        addContent()
        setContentView(rootView)
        initView()
        initNet()
    }

    private fun addContent() {
        val flContent = rootView.findViewById(R.id.fl_content) as FrameLayout
        val tvTitleTitle = rootView.findViewById(R.id.tv_title_title) as TextView
        val llTitleBack = rootView.findViewById(R.id.ll_title_back) as LinearLayout
       tvTitleTitle.text = if (contentTitle == null) "" else contentTitle
        llTitleBack.setOnClickListener { backClick() }
        val content = View.inflate(this, contentView, null)
        if (content != null) {
            val params = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT)
            flContent.addView(content, params)
            mBaseLoadService = LoadSir.getDefault().register(content) { v -> onNetReload(v) }
        }
    }

    private fun backClick() {
        finish()
    }

    protected abstract val contentTitle: String?
    protected abstract val contentView: Int
    protected abstract fun initView()
    protected abstract fun initNet()
    protected abstract fun onNetReload(v: View?)
}