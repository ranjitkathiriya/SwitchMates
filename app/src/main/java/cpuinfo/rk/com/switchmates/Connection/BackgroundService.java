/*
package cpuinfo.rk.com.switchmates.Connection;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import cpuinfo.rk.com.switchmates.Others.L;

*/
/**
 * Created by ranjit on 15-08-2017.
 *//*


public class BackgroundService extends Service {

    public Context context = this;
    public Handler handler = null;
    public static Runnable runnable = null;

    private PrintWriter printWriter;
    private static InputStreamReader inputStreamReader;
    private static BufferedReader bufferedReader;
    private static String message;
    Socket mySocket = SocketHolder.getInstance().getSocket();

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "Service created!", Toast.LENGTH_LONG).show();

        try {
            printWriter = new PrintWriter(mySocket.getOutputStream());
            bufferedReader = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
            int charsRead = 0;
            char[] buffer = new char[1024];
            while (true) {
                charsRead = bufferedReader.read(buffer);
                message = new String(buffer).substring(0, charsRead);
                if (message != null) {
                    Log.i("Message from Server", message.toString());
                }

            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
            L.m("ERROR");
        } catch (IOException e) {
            e.printStackTrace();
            L.m("ERROR");
        }
        */
/*handler = new Handler();
        runnable = new Runnable() {
            public void run() {
                try {
                    try {
                        printWriter = new PrintWriter(mySocket.getOutputStream());
                        bufferedReader = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
                        int charsRead = 0;
                        char[] buffer = new char[1024];
                        while (true) {
                            charsRead = bufferedReader.read(buffer);
                            message = new String(buffer).substring(0, charsRead);
                            if (message != null) {
                                Log.i("Message from Server", message.toString());
                            }

                        }
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                        L.m("ERROR");
                    } catch (IOException e) {
                        e.printStackTrace();
                        L.m("ERROR");
                    }
                    handler.postDelayed(runnable, 1000);
                }catch (Exception e){

                }
            }
        };

        handler.postDelayed(runnable, 15000);*//*

    }

    @Override
    public void onDestroy() {
        */
/* IF YOU WANT THIS SERVICE KILLED WITH THE APP THEN UNCOMMENT THE FOLLOWING LINE *//*

        //handler.removeCallbacks(runnable);
        Toast.makeText(this, "Service stopped", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStart(Intent intent, int startid) {
        Toast.makeText(this, "Service started by user.", Toast.LENGTH_LONG).show();
    }
}*/
