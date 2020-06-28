/*
package cpuinfo.rk.com.switchmates.Connection;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import cpuinfo.rk.com.switchmates.Others.L;

*/
/**
 * Created by ranjit on 15-08-2017.
 *//*


public class ConnectClient extends AsyncTask<String, Void, String> {

    private Context context;
    private static InputStreamReader inputStreamReader;
    private static BufferedReader bufferedReader;
    private static String message;
    Socket mySocket = SocketHolder.getInstance().getSocket();

    public ConnectClient(Context ctx){
        super();
        this.context = ctx;
    }

   */
/* @Override
    protected String doInBackground(String... params) {

        try {
            inputStreamReader = new InputStreamReader(mySocket.getInputStream());
            message = "after isr";
            bufferedReader = new BufferedReader(inputStreamReader); //get the client message
            message = bufferedReader.readLine();
           // inputStreamReader.close();
//            socket.close();   //closing the connection

        } catch (UnknownHostException e) {
            e.printStackTrace();
            L.m("ERROR");
        } catch (IOException e) {
            e.printStackTrace();
            L.m("ERROR");
        }

        return message;
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(context, result +"HELLO ", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        Toast.makeText(context, "In progress", Toast.LENGTH_SHORT).show();
    }*//*



}*/
