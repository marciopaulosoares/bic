package br.com.marciopaulo.bic;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;

import br.com.marciopaulo.bic.helpers.DBHelper;
import br.com.marciopaulo.bic.dao.DatabaseManager;

/**
 * Created by marci on 12/12/2016.
 */

public class App extends Application {

    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        DatabaseManager.initializeInstance(new DBHelper());
    }

    public  static Context getContext(){
        return  instance;
    }

    public  App(){
        instance = this;
    }
}
