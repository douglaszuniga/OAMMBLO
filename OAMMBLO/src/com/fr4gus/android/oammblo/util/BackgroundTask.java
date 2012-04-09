package com.fr4gus.android.oammblo.util;

import android.os.Handler;

/**
 * Created by IntelliJ IDEA.
 * User: Shang
 * Date: 4/8/12
 * Time: 8:09 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class BackgroundTask {
    protected Handler handler;

    public BackgroundTask() {
        handler = new Handler();

        new BackgroundThread().start();
    }

    public abstract void work();

    public abstract void done();

    public abstract void error(Throwable error);

    private class BackgroundThread extends Thread {

        Throwable err = null;

        public void run() {
            try {
                work();
            } catch (Throwable e) {
                err = e;
            }

            handler.post(new Runnable() {

                @Override
                public void run() {
                    if (err != null) {
                        error(err);
                    } else {
                        try {
                            done();
                        } catch (Throwable e) {
                            error(e);
                        }
                    }
                }
            });
        }
    }
}