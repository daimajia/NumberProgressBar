package com.daimajia.numberprogressbar.example;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.daimajia.numberprogressbar.NumberProgressBar;
import com.daimajia.numberprogressbar.OnProgressBarListener;

import java.util.Timer;
import java.util.TimerTask;



public class MainActivity extends ActionBarActivity implements OnProgressBarListener {

    private Timer timer;
    private TimerTask timerTask;

    private NumberProgressBar[] npbArray = new NumberProgressBar[8];
    private int[] ids = {R.id.numberbar1, R.id.numberbar2, R.id.numberbar3, R.id.numberbar4, R.id.numberbar5, R.id.numberbar6, R.id.numberbar7, R.id.numberbar8};
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < ids.length; i++) {
            npbArray[i] = (NumberProgressBar) findViewById(ids[i]);
            npbArray[i].setOnProgressBarListener(this);
        }

        timer = new Timer();
        runTimer();
    }

    private void runTimer() {
        timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        npbArray[currentIndex].incrementProgressBy(1);
                    }
                });
            }
        };
        if (timer != null)
            timer.schedule(timerTask, 1000, 100);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_reset) {
            resetNPB();
            return true;
        }else if(id==R.id.action_stop){
            stopNPB();
            return true;
        }else if(id==R.id.action_start){
            startNPB();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void startNPB() {
        runTimer();
    }

    private void stopNPB() {
        if(timerTask!=null){
            timerTask.cancel();
            timerTask = null;
        }
    }

    private void resetNPB() {
        for (int i = 0; i < npbArray.length; i++) {
            npbArray[i].setProgress(10 * (i + 1));
        }
        currentIndex = 0;
        if(timerTask!=null) {
          timerTask.cancel();
          timerTask = null;
        }
        runTimer();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (timerTask != null) {
            timerTask.cancel();
            timerTask = null;
        }
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        currentIndex = 0;
    }

    @Override
    public void onProgressChange(int current, int max) {
        if (currentIndex < npbArray.length - 1) {
            if (current == max) {
                currentIndex++;
                if(timerTask!=null)
                   timerTask.cancel();
                timerTask = null;
                runTimer();
            }
        } else {
            if (current == max) {
                Toast.makeText(getApplicationContext(), getString(R.string.finish), Toast.LENGTH_SHORT).show();
                resetNPB();
            }
        }
    }
}
