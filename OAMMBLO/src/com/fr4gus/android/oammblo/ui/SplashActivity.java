package com.fr4gus.android.oammblo.ui;

import android.content.Intent;
import android.os.AsyncTask;
import com.fr4gus.android.oammblo.R;

import android.os.Bundle;
import com.fr4gus.android.oammblo.util.BackgroundTask;
import com.fr4gus.android.oammblo.util.LogIt;

/**
 * Shows App logo for few seconds.
 * 
 * @author Franklin Garcia
 * Created Mar 25, 2012
 */
public class SplashActivity extends OammbloActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
         //using a new thread
        //usingNewThread();

        //using backgroundtask from util
        //usingBackgroundTask();

        //using asynctask
        usingAsyncTask();
    }

    private void usingNewThread()
    {
        Thread splashThread = new Thread()
        {
            @Override
            public void run()
            {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
                finally {
                    finish();
                    Intent loginIntent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(loginIntent);
                }

            }

        };
        splashThread.start();
    }

    private void usingBackgroundTask()
    {
        new BackgroundTask(){

            @Override
            public void work() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    //do nothing
                }
            }

            @Override
            public void done() {
                finish();
                Intent loginIntent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(loginIntent);
            }

            @Override
            public void error(Throwable error) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        };

    }

    private void usingAsyncTask()
    {
        LoginAsyncTask task = new LoginAsyncTask();
        task.execute();
    }

    class LoginAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            long startTime = System.currentTimeMillis();
            try {
                //TODO Cargar base de datos
                LogIt.d(this, "Deteniendo hilo por 2 segundos", "en serio");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
            finish();
        }

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();
        }

    }

}
