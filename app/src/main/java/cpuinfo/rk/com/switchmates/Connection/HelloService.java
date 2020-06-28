package cpuinfo.rk.com.switchmates.Connection;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import cpuinfo.rk.com.switchmates.Activity.HomeActivity;
import cpuinfo.rk.com.switchmates.Others.L;

/**
 * Created by ranjit on 01-09-2017.
 */

public class HelloService extends Service {

    private static final String TAG = "HelloService";

    private boolean isRunning = false;

    private static InputStreamReader inputStreamReader;
    private static BufferedReader bufferedReader;
    private static String message;
    Socket mySocket = SocketHolder.getInstance().getSocket();

    @Override
    public void onCreate() {
        Log.i(TAG, "Service onCreate");

        isRunning = true;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.i(TAG, "Service onStartCommand");

        //Creating new thread for my service
        //Always write your long running tasks in a separate thread, to avoid ANR
        new Thread(new Runnable() {
            @Override
            public void run() {

                //Your logic that service will perform will be placed here
                //In this example we are just looping and waits for 1000 milliseconds in each loop.
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                    }

                    if (isRunning) {
                        try {
                            inputStreamReader = new InputStreamReader(mySocket.getInputStream());
                            message = "after isr";
                            bufferedReader = new BufferedReader(inputStreamReader); //get the client message
                            message = bufferedReader.readLine();

                            Log.i(TAG, message );


                        } catch (UnknownHostException e) {
                            e.printStackTrace();
                            L.m("ERROR");
                        } catch (IOException e) {
                            e.printStackTrace();
                            L.m("ERROR");
                        } catch (Exception e){
                            e.printStackTrace();
                            L.m("ERROR");
                        }
                        HomeActivity.Result(message);
                        //Log.i(TAG, "Service running");
                    }
                }

                //Stop service once it finishes its task
                //stopSelf();
            }
        }).start();

        return Service.START_STICKY;
    }

    private final Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.arg1 == 1)
                Toast.makeText(getApplicationContext(), "Your message", Toast.LENGTH_LONG).show();
        }
    };


    @Override
    public IBinder onBind(Intent arg0) {
        Log.i(TAG, "Service onBind");
        return null;
    }

    @Override
    public void onDestroy() {

        isRunning = false;

        Log.i(TAG, "Service onDestroy");
    }



}
