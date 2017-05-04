package com.elink.hospitalhealthnurse.common.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class VNTCenter {

	public static final int SERVER_PORT=2010;
	
	
	public static void main(String[] args) {
		VNTCenter vntCenter = new VNTCenter(); 
		vntCenter.init();
	}
	
	public void init(){
		System.out.println("VNTCenter.main()===TCP SERVER==============");
		try {
			ServerSocket vntServer= new ServerSocket(SERVER_PORT);
			System.out.println("Listening Port is "+vntServer.getLocalPort()+"...");
			while(true){
				Socket vntClient=vntServer.accept();
				System.out.println("have a client entering , the IP is "+vntClient.getInetAddress()+"...");
				System.out.println("have a client entering , the Port is "+vntClient.getPort()+"...");
				new GetGpsThreadFun(vntClient).start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
	
class GetGpsThreadFun extends Thread{
	private Socket vntThreadClient;
	private static final String URL = "jdbc:mysql://localhost:3306/healthcarekangyang?useUnicode=true&characterEncoding=utf-8";
	private static final String NAME = "root" ;
	private static final String PASS = "ghgxX0uHFMNr";  
//	private static final String URL = "jdbc:mysql://10.0.0.9:3306/healthcarekangyang?useUnicode=true&characterEncoding=utf-8";
//	private static final String NAME = "root";
//	private static final String PASS = "0000abc!";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private final static SimpleDateFormat longSdf  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	private final static SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd"); 
	
	public GetGpsThreadFun(Socket vntThreadSocket){
		vntThreadClient=vntThreadSocket;
	}
		
	@Override
	public void run() {
		try {
			BufferedReader vntThreadIS=new BufferedReader(new InputStreamReader(vntThreadClient.getInputStream()));
			while(true){
				String vntReceiveString=vntThreadIS.readLine();
				if (vntReceiveString!=null){
					System.out.println(vntThreadClient.getInetAddress()+":"+vntThreadClient.getPort()+":"+vntReceiveString);
					if(vntReceiveString.startsWith("+STAR:")){
						String data = vntReceiveString.substring(6);
						initEntityInfoMysql(data.split(",")); 
					}
				}
				if("shutdown".equals(vntReceiveString)){
                    break;
                }
			}
			vntThreadIS.close();
			 vntThreadClient.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void initEntityInfoMysql(String[] filters){
		Connection conn = null;
		Statement pStemt = null;
		StringBuffer sb = new StringBuffer("INSERT sys_fall_gps_data VALUES(");
		sb.append("'"+UUID.randomUUID().toString().replaceAll("-", "")+"',");
		sb.append("'"+filters[0]+"',");
		sb.append("'"+filters[1]+"',");
		sb.append("'"+filters[2]+"',");
		sb.append("'"+filters[3]+"',");
		String gps_date = shortSdf.format(new Date()) + " " + filters[4]; 
		sb.append("'"+gps_date+"',");
		sb.append("'"+filters[5]+"',");
		sb.append("'"+filters[6]+"',");
		String lbs_date = shortSdf.format(new Date()) + " " + filters[7];
		sb.append("'"+lbs_date+"',");
		sb.append("'"+filters[8]+"',");
		sb.append("'"+filters[9]+"',");
		sb.append("'"+filters[10]+"',");
		String create_date = longSdf.format(new Date());
		sb.append("'"+create_date+"',");
		sb.append("'"+0+"')");		
		System.out.println(sb.toString());
		try {
			try {
				Class.forName(DRIVER);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(URL, NAME, PASS);
			pStemt = conn.createStatement();
			pStemt.executeUpdate(sb.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pStemt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
