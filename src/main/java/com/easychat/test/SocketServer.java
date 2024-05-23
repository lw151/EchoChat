package com.easychat.test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * @author WeiLI
 * @date 2024/5/23 11:31
 * @desciption:
 */
public class SocketServer {

    public static void main(String[] args) {
        ServerSocket server = null;

        try {
            server = new ServerSocket(1024);
            System.out.println("服务已启动,等待客户端连接");
            Map<String, Socket> clientMap = new HashMap<>();
            while (true) {
                Socket socket = server.accept();
                String ip = socket.getInetAddress().getHostAddress();
                System.out.println("有客户端连接ip: " + ip + "端口: " + socket.getPort());
                String clientKey = ip + socket.getPort();
                clientMap.put(clientKey, socket);
                new Thread(() -> {
                    while (true) {
                        try {
                            InputStream inputStream = socket.getInputStream();
                            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                            String readLine = bufferedReader.readLine();
                            System.out.println(readLine);

                            clientMap.forEach((k, v) -> {
                                try {
                                    OutputStream outputStream = v.getOutputStream();
                                    PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(outputStream));
                                    printWriter.println(socket.getPort() + ":" + readLine);
                                    printWriter.flush();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                            });
//                            OutputStream outputStream = socket.getOutputStream();
//                            PrintWriter printWriter = new PrintWriter(outputStream);
//                            printWriter.println("我是服务端，我已经收到你发送过来的消息: " + readLine);
//                            printWriter.flush();
                        } catch (Exception e) {
                            e.printStackTrace();
                            break;
                        }

                    }
                }).start();
            }


        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
