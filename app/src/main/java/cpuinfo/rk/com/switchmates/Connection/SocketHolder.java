package cpuinfo.rk.com.switchmates.Connection;

import java.net.Socket;

/**
 * Created by ranjit on 15-08-2017.
 */

public class SocketHolder {
    private Socket socket;
    public Socket getSocket() { return socket; }
    public void setSocket(Socket socket) {this.socket = socket;}

    private static final SocketHolder holder = new SocketHolder();
    public static SocketHolder getInstance() {return holder;}
}