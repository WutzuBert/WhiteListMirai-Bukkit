package cn.cubegarden.whitelistmirai;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MiraiConnect {
    public static final MiraiConnect INSTANCE = new MiraiConnect();
    public void connect(){
        try {
            ServerSocket servers = new ServerSocket(23300);
            while(true){
                Socket soc = servers.accept();
                BufferedReader br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
                WhiteListMirai.Command = br.readLine();
                OutputStreamWriter re = new OutputStreamWriter(soc.getOutputStream());
                re.write(1);
                re.flush();
                re.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
