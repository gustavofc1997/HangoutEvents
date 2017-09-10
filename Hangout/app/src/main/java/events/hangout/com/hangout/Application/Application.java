package events.hangout.com.hangout.Application;

import android.content.ContextWrapper;

import com.pixplicity.easyprefs.library.Prefs;

/**
 * Created by Gustavo on 8/09/2017.
 */

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        new Prefs.Builder()
                .setContext(this)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();
    }
}
