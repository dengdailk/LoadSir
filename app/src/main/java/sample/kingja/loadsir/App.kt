package sample.kingja.loadsir

import android.app.Application
import com.kingja.loadsir.core.LoadSir
import com.squareup.leakcanary.LeakCanary
import sample.kingja.loadsir.callback.*

/**
 * Description:TODO
 * Create Time:2017/9/3 14:02
 * Author:KingJA
 * Email:kingjavip@gmail.com
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