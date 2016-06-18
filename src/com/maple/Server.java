package com.maple;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

import com.maple.ConstString; // 字符串常量定义

@SuppressWarnings("unused")
public class Server {
    // 常量定义
    private static final int PORT = 8080;
    private static final int THREAD_NUM = 50;
    // 网络相关变量
    private static Socket con = null;
    private static ServerSocket socket = null;
    // 输入输出流
    private static InputStream in = null;
    private static OutputStream out = null;
    private static BufferedWriter writer = null;
    // 其他
    private static BlockingQueue<Socket> queForsoc = new LinkedBlockingQueue<>();// socket的仓库队列
    private static ExecutorService executorService = Executors.newFixedThreadPool(THREAD_NUM);// 线程池

    public static void main(String[] args) {
        try {
            socket = new ServerSocket(PORT);
            writer = new BufferedWriter(new FileWriter(ConstString.SRC_TO_ROOT + "log.txt", true));
            /* 写日志 */
            writer.write(new Date() + "\r\n" + "服务器已经启动并监听" + PORT + "端口...\r\n\r\n\r\n");
            writer.flush();
            while (true) {
                WaitRequest();
                socket.setReuseAddress(true);// 设置svrSoc允许多次绑定同个端口
                con = socket.accept();// 接受套接字
                writer.write("于" + new Date() + " 接受到请求：\r\n");
                writer.flush();
                queForsoc.put(con);// 放进仓库队列
            }
        } catch (Exception e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }

    private static void WaitRequest() {
        // TODO 自动生成的方法存根
        for (int i = 0; i < THREAD_NUM; i++) {
            executorService.submit(() -> {
                try {
                    Socket soc = queForsoc.take();// 试图从仓库里拿一个socket出来

                    /* 读取请求 */
                    InputStream in = soc.getInputStream();// 获取输入流
                    BufferedReader br = new BufferedReader(new InputStreamReader(in)); // 字节流
                    StringBuffer tmp = new StringBuffer();
                    while (true) {
                        String line = br.readLine();
                        if (line.length() == 0) {
                            break;
                        }
                        tmp.append(line + '\n');
                    }
                    String request = tmp.toString();

                    /* 处理 */
                    if (request.contains(ConstString.GET_TODOLIST)) {
                        handleGetToDoList(soc, request);
                    } else if (request.contains(ConstString.GET_TODOLIST_CONTENT)) {
                        handleGetToDoListContent(soc, request);
                    } else if (request.contains(ConstString.GET_TODOLIST_PIC)) {
                        handleGetToDoListPic(soc, request);
                    } else if (request.contains(ConstString.LOGIN)) {
                        handleLogin(soc, request);
                    } else if (request.contains(ConstString.POST_TODOLIST_CONTENT)) {
                        handlePostToDolistContent(soc, request);
                    } else if (request.contains(ConstString.POST_TODOLIST_PIC)) {
                        handlePostToDoListPic(soc, request);
                    } else if (request.contains(ConstString.PUT_TODOLIST)) {
                        handlePutToDoList(soc, request);
                    } else if (request.contains(ConstString.SIGNUP)) {
                        handleSignUp(soc, request);
                    } else {
                        System.out.println("未知请求:");
                        System.out.println(request);
                    }
                    /* 处理结束 */
                    queForsoc.remove(soc);
                    soc.close();
                } catch (Exception e) {
                    // TODO 自动生成的 catch 块
                    e.printStackTrace();
                }
            });
        }
    }

    private static void handleSignUp(Socket soc, String request) {
        // TODO 自动生成的方法存根
        try {
            OutputStream outputStream = soc.getOutputStream();

            // 报文传给UserData
            UserData user = new UserData(soc, request);
            int result = user.trySignUp();

            // 判断result 将user传回给客户端
            user.setMSG("ERROR");
            if (result == 0) {
                user.setMSG("OK");
            }
            out.write(user.toString().getBytes());
            out.write('\n');
            out.write(-1);
            out.flush();
        } catch (Exception e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }

    private static void handleLogin(Socket soc, String request) {
        // TODO 自动生成的方法存根
        try {
            OutputStream outputStream = soc.getOutputStream();

            // 报文传给UserData
            UserData user = new UserData(soc, request);
            int result = user.tryLogin();

            // 判断result 将user传回给客户端
            user.setMSG("ERROR");
            if (result == 0) {
                user.setMSG("OK");
            }
            out.write(user.toString().getBytes());
            out.write('\n');
            out.write(-1);
            out.flush();
        } catch (Exception e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }

    private static void handleGetToDoList(Socket soc, String request) {
        // TODO 自动生成的方法存根

    }

    private static void handlePutToDoList(Socket soc, String request) {
        // TODO 自动生成的方法存根

    }

    private static void handlePostToDoListPic(Socket soc, String request) {
        // TODO 自动生成的方法存根

    }

    private static void handlePostToDolistContent(Socket soc, String request) {
        // TODO 自动生成的方法存根

    }

    private static void handleGetToDoListPic(Socket soc, String request) {
        // TODO 自动生成的方法存根

    }

    private static void handleGetToDoListContent(Socket soc, String request) {
        // TODO 自动生成的方法存根

    }
}
