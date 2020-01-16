package sample.kingja.loadsir.target

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.kingja.loadsir.core.LoadService
import com.kingja.loadsir.core.LoadSir
import kotlinx.android.synthetic.main.include_title.*
import sample.kingja.loadsir.PostUtil.postCallbackDelayed
import sample.kingja.loadsir.R
import sample.kingja.loadsir.callback.EmptyCallback
import sample.kingja.loadsir.callback.LoadingCallback

/**
 * @author dengdai
 * @date 2020/1/10.
 * GitHub：
 * email：291996307@qq.com
 * description：
 */
class KeepTitleFragment : Fragment() {
    private lateinit var loadService: LoadService<*>
    private lateinit var rootView: ViewGroup

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        iv_back.setOnClickListener { activity?.finish() }
        val contentView = rootView.findViewById<View>(R.id.ll_content) as LinearLayout
        val loadSir = LoadSir.Builder()
                .addCallback(EmptyCallback())
                .addCallback(LoadingCallback())
                .setDefaultCallback(LoadingCallback::class.java)
                .build()
        loadService = loadSir.register(contentView) { loadService.showSuccess() }
        postCallbackDelayed(loadService, EmptyCallback::class.java, 1200)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.title_title_bar, container, false) as ViewGroup
        return rootView
    }

}