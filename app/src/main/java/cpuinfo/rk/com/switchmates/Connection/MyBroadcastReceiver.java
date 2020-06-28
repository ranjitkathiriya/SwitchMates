/*
package cpuinfo.rk.com.switchmates.Connection;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import cpuinfo.rk.com.switchmates.Others.L;

*/
/**
 * Created by ranjit on 16-08-2017.
 *//*


public class MyBroadcastReceiver extends BroadcastReceiver {

    private static InputStreamReader inputStreamReader;
    private static BufferedReader bufferedReader;
    private static String message;
    Socket mySocket = SocketHolder.getInstance().getSocket();

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        try {
            inputStreamReader = new InputStreamReader(mySocket.getInputStream());
            message = "after isr";
            bufferedReader = new BufferedReader(inputStreamReader); //get the client message
            message = bufferedReader.readLine();
            L.m(message + "YES");
            // inputStreamReader.close();
//            socket.close();   //closing the connection

        } catch (UnknownHostException e) {
            e.printStackTrace();
            L.m("ERROR");
        } catch (IOException e) {
            e.printStackTrace();
            L.m("ERROR");
        }
    }

}
*/
