package cpuinfo.rk.com.switchmates.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import cpuinfo.rk.com.switchmates.Connection.HelloService;
import cpuinfo.rk.com.switchmates.Connection.SocketHolder;
import cpuinfo.rk.com.switchmates.Others.L;
import cpuinfo.rk.com.switchmates.R;


public class HomeActivity extends AppCompatActivity {

    public static ToggleButton s01, s02, s03, s04, s05, s06;
    Button s07;
    int flag = 0;

//    private final Integer OUT_PORT = 8080;
//    private final String S_IP = "192.168.4.1";

    //public static Socket socket;
    private PrintWriter printWriter;

    //    private String param;
    private static InputStreamReader inputStreamReader;
    private static BufferedReader bufferedReader;
    private static String message;
    public Handler handler = null;
    public static Runnable runnable = null;

    Socket mySocket = SocketHolder.getInstance().getSocket();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //new Thread(new ClientThread()).start();



        bind();


        s01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (s01.isChecked()) {
                    //Button is ON
                    send("*A");

                } else if (!s01.isChecked()) {
                    //Button is OFF
                    send("*a");
                }
            }
        });

        s02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (s02.isChecked()) {
                    //Button is ON
                    send("*B");
                } else if (!s02.isChecked()) {
                    //Button is OFF
                    send("*b");
                }
            }
        });
        s03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (s03.isChecked()) {
                    //Button is ON
                    send("*C");
                } else if (!s03.isChecked()) {
                    //Button is OFF
                    send("*c");
                }
            }
        });
        s04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (s04.isChecked()) {
                    //Button is ON
                    send("*D");
                } else if (!s04.isChecked()) {
                    //Button is OFF
                    send("*d");
                }
            }
        });
        s05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (s05.isChecked()) {
                    //Button is ON
                    send("*E");
                } else if (!s05.isChecked()) {
                    //Button is OFF
                    send("*e");
                }
            }
        });
        s06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (s06.isChecked()) {
                    //Button is ON
                    send("*F");
                } else if (!s06.isChecked()) {
                    //Button is OFF
                    send("*f");
                }
            }
        });
        s07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s01.setChecked(false);
                s02.setChecked(false);
                s03.setChecked(false);
                s04.setChecked(false);
                s05.setChecked(false);
                s06.setChecked(false);
                send("*#");

            }
        });
    }

    private void send(String s) {
        try {
            printWriter = new PrintWriter(new BufferedWriter(
                    new OutputStreamWriter(mySocket.getOutputStream())),
                    true);
            printWriter.println(s);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void bind() {
        s01 = (ToggleButton) findViewById(R.id.toggleButton1);
        s02 = (ToggleButton) findViewById(R.id.toggleButton2);
        s03 = (ToggleButton) findViewById(R.id.toggleButton3);
        s04 = (ToggleButton) findViewById(R.id.toggleButton4);
        s05 = (ToggleButton) findViewById(R.id.toggleButton5);
        s06 = (ToggleButton) findViewById(R.id.toggleButton6);
        s07 = (Button) findViewById(R.id.toggleButton7);
        s07.setVisibility(View.INVISIBLE);
        Intent intent = new Intent(this, HelloService.class);
        startService(intent);
    }

    public static void Result(final String msg) {
        message=msg;
        L.m("RES>> "+message);
        //if (msg=="a"){
        new Handler(Looper.getMainLooper()).post(new Runnable() { // Tried new Handler(Looper.myLopper()) also
            @Override
            public void run() {
                try {
                    if (message.equals("*A")) {
                        s01.setChecked(true);
                    }else if (message.equals("*a")){
                        s01.setChecked(false);
                    }

                    else if (message.equals("*B")) {
                        s02.setChecked(true);
                    }else if (message.equals("*b")){
                        s02.setChecked(false);
                    }

                    else if (message.equals("*C")) {
                        s03.setChecked(true);
                    }else if (message.equals("*c")){
                        s03.setChecked(false);
                    }

                    else if (message.equals("*D")) {
                        s04.setChecked(true);
                    }else if (message.equals("*d")){
                        s04.setChecked(false);
                    }

                    else if (message.equals("*E")) {
                        s05.setChecked(true);
                    }else if (message.equals("*e")){
                        s05.setChecked(false);
                    }

                    else if (message.equals("*F")) {
                        s06.setChecked(true);
                    }else if (message.equals("*f")){
                        s06.setChecked(false);
                    }

                    else if (message.equals("*#")){
                        s01.setChecked(false);
                        s02.setChecked(false);
                        s03.setChecked(false);
                        s04.setChecked(false);
                        s05.setChecked(false);
                        s06.setChecked(false);
                    }
                }catch (Exception e){

                }


            }
        });
    }

}

