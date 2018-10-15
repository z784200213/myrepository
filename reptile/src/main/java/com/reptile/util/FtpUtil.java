package com.reptile.util;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class FtpUtil {
    //ftp服务器ip地址
    private static final String FTP_ADDRESS = "172.16.205.28";
    //端口号
    private static final int FTP_PORT = 21;
    //用户名
    private static final String FTP_USERNAME = "gzxiaoiftp";
    //密码
    private static final String FTP_PASSWORD = "gzxiaoi";
    //图片路径
    public final String FTP_BASEPATH = "/home/ftp/develop/";

    public boolean uploadFile(String originFileName, InputStream input) throws IOException {
        boolean success = false;
        FTPClient ftp = new FTPClient();
        ftp.setControlEncoding("GBK");
        try {
            int reply;
            ftp.connect(FTP_ADDRESS, FTP_PORT);// 连接FTP服务器
            ftp.login(FTP_USERNAME, FTP_PASSWORD);// 登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return success;
            }
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftp.makeDirectory(FTP_BASEPATH);
            ftp.changeWorkingDirectory(FTP_BASEPATH);
            ftp.storeFile(originFileName, input);
            input.close();
            ftp.logout();
            success = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return success;
    }

    @Autowired
    MyBean myBean;

    public boolean CheckLogin() throws IOException {
        FTPClient ftp = new FTPClient();
        int reply;
        ftp.connect("172.17.13.36", 2121);// 连接FTP服务器
        ftp.login("ftpuser", "1");// 登录
        reply = ftp.getReplyCode();
        List<String> list = new ArrayList<String>();
        FTPFile[] fs = ftp.listFiles();
        if (fs.length > 0) {
            for (FTPFile ftpFile : fs) {
                if (ftpFile.getName().endsWith(".txt")) {
                    list.add(ftpFile.getName());
                    File localFile = new File("E:\\ftp\\dir" + "/" + ftpFile.getName());
                    ApplicationContext context = myBean.getContext();
                    String filename = "ftp://172.17.13.36:2121/" + ftpFile.getName();
                    ReadFtpfile(filename);
                    OutputStream is = new FileOutputStream(localFile);
                    ftp.retrieveFile(ftpFile.getName(), is);
                    is.close();
                    //读取本地文件内容
                    //readFileBycode(localFile);
                }
            }
        }
        return false;
    }

    private void ReadFile(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str = null;
        while ((str = br.readLine()) != null) {
            System.out.println(str);
        }
    }

    //读取ftp服务器指定文件内容并打印出来(编码格式为utf-8)
    private void ReadFtpfile(String filename) throws IOException {
        ApplicationContext context = myBean.getContext();
        Resource resource = context.getResource(filename);
        InputStream inputStream = resource.getInputStream();
        InputStreamReader isr = new InputStreamReader(inputStream,
                "UTF-8");
        BufferedReader read = new BufferedReader(isr);
        // BufferedReader br = new BufferedReader(new FileReader(localFile));
        String str;
        while ((str = read.readLine()) != null) {
            System.out.println(str);
        }
    }

    //讲ftp中文件内容保存到本地文件中
    private void saveLocalFile(FTPClient ftp, FTPFile ftpFile, String localpath) throws IOException {
        //File localFile = new File("E:\\ftp\\dir" + "/" + ftpFile.getName());
        File localFile = new File(localpath + "/" + ftpFile.getName());
        OutputStream is = new FileOutputStream(localFile);
        ftp.retrieveFile(ftpFile.getName(), is);
        is.close();
    }

    //读取本地文件内容并打印出来
    private void readFileBycode(File localFile) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream(localFile),
                "UTF-8");
        BufferedReader read = new BufferedReader(isr);
        // BufferedReader br = new BufferedReader(new FileReader(localFile));
        String str;
        while ((str = read.readLine()) != null) {
            System.out.println(str);
        }
    }
}
