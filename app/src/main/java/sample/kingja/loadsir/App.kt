package sample.kingja.loadsir

import android.app.Application
import com.kingja.loadsir.core.LoadSir
import com.squareup.leakcanary.LeakCanary
import sample.kingja.loadsir.callback.*

/**
 * @author dengdai
 * @date 2020/1/10.
 * GitHub：
 * email：291996307@qq.com
 * description：
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        if (setupLeakCanary()) {
            return
        }
        LoadSir.beginBuilder()
                .addCallback(ErrorCallback())
                .addCallback(EmptyCallback())
                .addCallback(LoadingCallback())
                .addCallback(TimeoutCallback())
                .addCallback(CustomCallback())
                .setDefaultCallback(LoadingCallback::class.java)
                .commit()
    }

    private fun setupLeakCanary(): Boolean {
        if (LeakCanary.isInAnalyzerProcess(this)) return true
        LeakCanary.install(this)
        return false
    }
}