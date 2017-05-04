package com.elink.socket;

import java.io.DataOutputStream;
import java.net.Socket;

public class Client {

	public static final String IP_ADDR = "localhost";//服务器地址
	public static final int PORT = 2010;//服务器端口号
	
	public static void main(String[] args) {
		 System.out.println("客户端启动...");
		 Socket socket = null;
		 try {
				//创建一个流套接字并将其连接到指定主机上的指定端口号  
				socket = new Socket(IP_ADDR, PORT);
				//向服务器端发送数据
				DataOutputStream out = new DataOutputStream(socket.getOutputStream());
				String str = "+STAR:012896006527201,01,84,26,16:32:25,N34.213245,E108.542152,08:48:46,N34.213239,E1.8542211,0\r\n";
				out.writeUTF(str);
				out.close();  
			} catch (Exception e) {
				System.out.println("客户端异常:" + e.getMessage());
			} finally{
				if(socket != null){
					try {
						socket.close();
					} catch (Exception ex) {
						// TODO: handle exception
						socket = null;
						System.out.println("客户端 finally 异常:" + ex.getMessage());
					}
				}
			}
	}
}
