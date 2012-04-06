package com.fr4gus.android.oammblo.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * Base Activity class. All activities on this application should inherit from OammbloActivity
 * 
 * @author Franklin Garcia
 * Created Mar 25, 2012
 */
public class OammbloActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //En vez de definir esto en el xml con el tema Theme.NoTitleBar
        //Se puede hacer de manera programada. La ventaja es que solo se
        //hace desde aqui en vez de ir a modificar el AndroidManifest.xml
        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }
}