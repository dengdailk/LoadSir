package sample.kingja.loadsir.target

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kingja.loadsir.core.LoadService
import com.kingja.loadsir.core.LoadSir
import sample.kingja.loadsir.PostUtil.postCallbackDelayed
import sample.kingja.loadsir.R
import sample.kingja.loadsir.callback.CustomCallback
import sample.kingja.loadsir.callback.LoadingCallback

/**
 * Description:TODO
 * Create Time:2017/9/5 13:28
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
class NormalFragment : Fragment() {
    private lateinit var loadService: LoadService<*>
    private lateinit var rootView: View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        rootView = View.inflate(activity, R.layout.fragment_a_content, null)
        val loadSir = LoadSir.Builder()
                .addCallback(CustomCallback())
                .addCallback(LoadingCallback())
                .setDefaultCallback(LoadingCallback::class.java)
                .build()
        loadService = loadSir.register(rootView)
        return loadService.loadLayout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postCallbackDelayed(loadService, CustomCallback::class.java)
    }
}