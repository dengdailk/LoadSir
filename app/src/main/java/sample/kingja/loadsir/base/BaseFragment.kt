package sample.kingja.loadsir.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kingja.loadsir.core.LoadService
import com.kingja.loadsir.core.LoadSir

/**
 * @author dengdai
 * @date 2020/1/10.
 * GitHub：
 * email：291996307@qq.com
 * description：
 */
abstract class BaseFragment : Fragment() {
    protected lateinit var mBaseLoadService: LoadService<*>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = View.inflate(activity, onCreateFragmentView(), null)
        mBaseLoadService = LoadSir.getDefault().register(rootView) { v -> onNetReload(v) }
        return mBaseLoadService.loadLayout
    }
    protected abstract fun onCreateFragmentView(): Int
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadNet()
    }
    protected abstract fun loadNet()
    protected abstract fun onNetReload(v: View?)
}