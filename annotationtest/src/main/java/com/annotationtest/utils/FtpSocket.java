package com.annotationtest.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

@Component
public class FtpSocket {

    //定义基础变量
    Socket socket = null;
    BufferedReader reader = null;
    BufferedWriter writer = null;

    public synchronized void connect(String host) throws IOException {
        connect(host, 21);
    }

    public synchronized void connect(String host, int port) throws IOException {
        connect(host, port, "anonymous", "anonymous");
    }

    public synchronized void connect(String host, int port, String user, String pass) {
        try {
            socket = new Socket(host, port);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String line = reader.readLine();
            System.out.println("step1 ----- " + line);
            boolean connect = socket.isConnected();
            //input user
          /*  sendCommand("USER " + user);
            line = reader.readLine();
            System.out.println("step2 -----" + line);

            //input pwd
            sendCommand("PASS " + pass);
            line = reader.readLine();
            System.out.println("step3 -----" + line);*/
            //boolean connect= socket.isConnected();

            ReadFtpfile(socket.getInputStream());
            System.out.println(connect);


        } catch (UnknownHostException ex) {
            System.out.println("Couldn't find the Ftp Server");
        } catch (IOException ex) {
            System.out.println(ex.toString());
            System.out.println("IOException");
        }
    }

    /*@Autowired
    MyBean myBean;*/
    //读取ftp服务器指定文件内容并打印出来(编码格式为utf-8)
    private void ReadFtpfile(InputStream stream) throws IOException {
        //ApplicationContext context=myBean.getContext();
        //Resource resource= context.getResource(filename);
        InputStream inputStream = stream;//resource.getInputStream();
        InputStreamReader isr = new InputStreamReader(inputStream,
                "UTF-8");
        BufferedReader read = new BufferedReader(isr);
        // BufferedReader br = new BufferedReader(new FileReader(localFile));
        String str;
        while ((str = read.readLine()) != null) {
            System.out.println(str);
        }
    }

    public synchronized void disconnect() throws IOException {

        try {
            sendCommand("QUIT");
            System.out.println("last step ----- " + reader.readLine());
        } finally {
            socket = null;
        }
    }

    public synchronized void listFiles(String serverPath) throws IOException {

        writer.write("cwd  " + serverPath + "/r/n"); //若要指定某一位置就修改 caches
        writer.flush();
        System.out.println(reader.readLine());

        sendCommand("PASV");

        String response = reader.readLine();
        String ip = null;
        int port1 = -1;
        int opening = response.indexOf('(');
        int closing = response.indexOf(')', opening + 1);

        if (closing > 0) {
            String dataLink = response.substring(opening + 1, closing);
            StringTokenizer tokenizer = new StringTokenizer(dataLink, ",");
            try {
                ip = tokenizer.nextToken() + "." + tokenizer.nextToken() + "."
                        + tokenizer.nextToken() + "." + tokenizer.nextToken();
                port1 = Integer.parseInt(tokenizer.nextToken()) * 256
                        + Integer.parseInt(tokenizer.nextToken());
            } catch (Exception e) {
                throw new IOException("SimpleFTP received bad data link information: "
                        + response);
            }
        }

        System.out.println(ip + "  " + port1);

        writer.write("LIST  " + "/r/n");
        writer.flush();
        Socket dataSocket = new Socket(ip, port1);
        reader.readLine();

        DataInputStream dis = new DataInputStream(dataSocket.getInputStream());
        String s = "";
        while ((s = dis.readLine()) != null) {
            String l = new String(s.getBytes("ISO-8859-1"), "utf-8");
            System.out.println(l);
        }
        dis.close();
        dataSocket.close();

        reader.readLine();
    }

    public synchronized boolean upload(String lfilepath, String serverPath) throws IOException {
        File file = new File(lfilepath);

        if (file.isDirectory()) {
            throw new IOException("SimpleFTP cannot upload a directory.");
        }

        String filename = file.getName();
        BufferedInputStream input = new BufferedInputStream(new FileInputStream(file));

        writer.write("cwd  " + serverPath + "/r/n"); //若要指定某一位置就修改 caches
        writer.flush();
        System.out.println(reader.readLine());

        sendCommand("PASV");
        String response = reader.readLine();
        if (!response.startsWith("227 ")) {
            throw new IOException("SimpleFTP could not request passive mode: "
                    + response);
        }

        String ip = null;
        int port = -1;
        int opening = response.indexOf('(');
        int closing = response.indexOf(')', opening + 1);
        if (closing > 0) {
            String dataLink = response.substring(opening + 1, closing);
            StringTokenizer tokenizer = new StringTokenizer(dataLink, ",");
            try {
                ip = tokenizer.nextToken() + "." + tokenizer.nextToken() + "."
                        + tokenizer.nextToken() + "." + tokenizer.nextToken();
                port = Integer.parseInt(tokenizer.nextToken()) * 256
                        + Integer.parseInt(tokenizer.nextToken());
            } catch (Exception e) {
                throw new IOException("SimpleFTP received bad data link information: "
                        + response);
            }
        }

        System.out.println(ip + "  " + port);

        sendCommand("STOR " + filename);

        Socket dataSocket = new Socket(ip, port);

        response = reader.readLine();

        BufferedOutputStream output = new BufferedOutputStream(dataSocket.getOutputStream());
        byte[] buffer = new byte[4096];
        int bytesRead = 0;
        while ((bytesRead = input.read(buffer)) != -1) {
            output.write(buffer, 0, bytesRead);
        }
        output.flush();
        output.close();
        input.close();

        response = reader.readLine();
        return response.startsWith("226 ");
    }


    private void sendCommand(String com) throws IOException {

        if (socket == null) {
            throw new IOException("SimpleFTP is not connected.");
        }

        try {
            writer.write(com + "/r/n");
            writer.flush();

        } catch (IOException e) {
            socket = null;
            throw e;
        }
    }

    public void userUrl() throws IOException {
        //使用URL读取网页内容
//创建一个URL实例
        URL url = new URL("ftp://172.17.13.36:2121/" + "1.txt");
        // ftp://test:test@192.168.0.1:21/profile
        InputStream is = url.openStream();//通过openStream方法获取资源的字节输入流
        InputStreamReader isr = new InputStreamReader(is, "UTF-8");//将字节输入流转换为字符输入流,如果不指定编码，中文可能会出现乱码
        BufferedReader br = new BufferedReader(isr);//为字符输入流添加缓冲，提高读取效率
        String data = br.readLine();//读取数据
        while (data != null) {
            System.out.println(data);//输出数据
            data = br.readLine();
        }
        br.close();
        isr.close();
        is.close();
    }

}
