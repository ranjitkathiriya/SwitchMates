package cpuinfo.rk.com.switchmates.Activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import cpuinfo.rk.com.switchmates.Connection.SocketHolder;
import cpuinfo.rk.com.switchmates.Others.L;
import cpuinfo.rk.com.switchmates.R;

public class MainActivity extends AppCompatActivity  {

    private Button btn1,btn2;

    public static Socket socket;
//    private final Integer OUT_PORT = 8080;
//    private final String S_IP = "192.168.2.7";
    final Context context = this;
    public static LinearLayout ln1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       // new ConnectClient().execute();
       /* try {
            socket = new Socket(S_IP, OUT_PORT);
            SocketHolder.getInstance().setSocket(socket);
        } catch (IOException e) {
            e.printStackTrace();
        }*/



        ln1= (LinearLayout) findViewById(R.id.linear1);
        btn1 = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),HomeActivity.class));
            }
        });

        btn2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
// get prompts.xml view
                LayoutInflater li = LayoutInflater.from(context);
                View promptsView = li.inflate(R.layout.prompt, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                // set prompts.xml to alertdialog builder
                alertDialogBuilder.setView(promptsView);

                final EditText ipadd = (EditText) promptsView
                        .findViewById(R.id.edtipaddress);
                final EditText portadd = (EditText) promptsView
                        .findViewById(R.id.edtportaddress);

                // set dialog message
                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        // get user input and set it to result
                                        // edit text
                                        try {
                                            new Thread(new ClientThread(ipadd.getText().toString().trim(),portadd.getText().toString().trim())).start();
                                            L.m("SUCESS ");
                                        }catch (Exception e){
                                            L.m("ERROR "+e);
                                        }

                                    }
                                })
                        .setNegativeButton("Conform",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        if (!socket.isConnected()) {
                                            ln1.setBackgroundColor(Color.parseColor("#ff0000"));

                                        }else {
                                            ln1.setBackgroundColor(Color.parseColor("#008000"));
                                        }
                                    }
                                });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
                return false;
            }
        });
    }

    class ClientThread implements Runnable {
        String port;
        String ip;

        ClientThread(String ip,String port){
            this.ip = ip;
            this.port = port;
        }

        @Override
        public void run() {
            try {
                socket = new Socket(ip, Integer.parseInt(port));
                SocketHolder.getInstance().setSocket(socket);
                L.m("SOCECT SUCESS!!");

            } catch (UnknownHostException e) {
                e.printStackTrace();
                L.m("ERROR");
            } catch (IOException e) {
                e.printStackTrace();
                L.m("ERROR");
            }catch(Exception e){
                e.printStackTrace();
                L.m("ERROR");
            }
        }
    }

    /*public class ConnectClient extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            // new Thread(new ClientThread()).start();
        }


        @Override
        protected String doInBackground(String... params) {

            try {
                inputStreamReader = new InputStreamReader(socket.getInputStream());
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
            Toast.makeText(context, result + "HELLO ", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            Toast.makeText(context, "In progress", Toast.LENGTH_SHORT).show();
        }
    }*/
}
