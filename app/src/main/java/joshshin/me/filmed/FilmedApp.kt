package joshshin.me.filmed

import android.app.Application
import com.squareup.leakcanary.LeakCanary

/**
 * Created by jjshin on 4/15/18
 */

class FilmedApp : Application() {
    override fun onCreate() {
        super.onCreate()
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return
        }
        LeakCanary.install(this)
    }
}