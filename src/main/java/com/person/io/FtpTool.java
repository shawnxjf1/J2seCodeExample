package com.person.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.junit.Test;

public class FtpTool {  
    /** 
     * 向ftp写文件(数据) 
     */  
	
    private  String url;
    private  int port;
    private  String user;
    private  String password;
    
    public FtpTool(){}
    
    public FtpTool(String url,int port,String user,String password){
    	this.url = url;
    	this.port = port;
    	this.user = user;
    	this.password = password;
    }
    
    public Boolean uploadFile(File file,String remoteFilePath,String remoteFileName) {  
        // 指定写入的目录  
        boolean success = false;
        FTPClient ftpClient = new FTPClient();  
        try {  
            // 1.输入流  
        	 InputStream is =  new FileInputStream(file);
            // 2.连接服务器  
            ftpClient.connect(url,port);  
            // 3.登录ftp  
            ftpClient.login(user, password);  
            // 4.指定写入的目录  
            ftpClient.changeWorkingDirectory(remoteFilePath);  
            // 5.写操作  
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);  
            success = ftpClient.storeFile(remoteFileName, is);  
            is.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            if (ftpClient.isConnected()) {  
                try {  
                    ftpClient.disconnect();  
                } catch (Exception e) {  
                    e.printStackTrace();  
                }  
            }  
        } 
        return success;
    }  
      
    /** 
     * ftp下载数据 
     */  
    public Boolean downFile(String localPath,String fileName,String remoteFilePath) {  
        FTPClient ftp = new FTPClient(); 
        boolean success = false;
        try {  
            int reply;  
            //1.连接服务器  
            ftp.connect(url);  
            //2.登录服务器 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器  
            ftp.login(user, password);  
            //3.判断登陆是否成功  
            reply = ftp.getReplyCode();  
            if (!FTPReply.isPositiveCompletion(reply)) {  
                ftp.disconnect();  
            }  
            //4.指定要下载的目录  
            ftp.changeWorkingDirectory(remoteFilePath);// 转移到FTP服务器目录  
            //5.遍历下载的目录  
            FTPFile[] fs = ftp.listFiles();  
            for (FTPFile ff : fs) {  
                //解决中文乱码问题，两次解码  
                byte[] bytes=ff.getName().getBytes("iso-8859-1");  
                String fn=new String(bytes,"utf8");  
                if (fn.equals(fileName)) {  
                    //6.写操作，将其写入到本地文件中  
                    File localFile = new File(localPath + ff.getName());  
                    OutputStream is = new FileOutputStream(localFile);  
                    success = ftp.retrieveFile(ff.getName(), is);  
                    is.close();  
                }  
            }  
            ftp.logout();  
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
    
    @Test
    public void testDownloadFile()
    {
    	/**
    	 * 如下为2016-12-19 测试成功：前提是必须先建立好D:\tmp目录<br>
    	 */
    	 String url = "10.7.111.15";
         int port = 21;
         String user = "pospadm";
         String password = "pospadm";
         FtpTool ftpUtil = new FtpTool(url,port,user,password);
         ftpUtil.downFile("D://tmp/", "F0_20141112_3G0120001_REFUND_000001.txt", "/home/pospadm");
    }
    
	private static void uploadfile() {
		/**
		 * 2016-12-19測試OK
		 */
		String url = "10.7.111.15";
		int port = 21;
		String user = "pospadm";
		String password = "pospadm";
		FtpTool ftpUtil = new FtpTool(url, port, user, password);
		// ftpUtil.uploadFile(new
		// File("/home/stlm/out_file/deyang/SCDY_20140810.dz"),"/",
		// "SCDY_20140810.dz");
		ftpUtil.uploadFile(new File("D://lakala_work/testfile/F0_20161219_3H1230001_REFUND_000001.txt"), "/home/pospadm/ftpfile/",
				"F0_20161219_3H1230001_REFUND_000002.txt");
		// ftpUtil.downFile("C://update/","mf_20150512.txt",
		// "/home/pospadm/test/");
		
		System.out.println("upload file to 10.7.111.15");
	}
    
    public static void main(String[] args) {
    	uploadfile();
    }
 }  