package com.elink.socket;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.elink.hospitalhealthnurse.common.utils.DateUtils;
import com.elink.hospitalhealthnurse.common.utils.IdGen;



public class Server {

	public static final int PORT = 2586;//监听的端口号 
	private static final String URL = "jdbc:mysql://10.0.0.9:3306/hospitalhealthnurse?useUnicode=true&characterEncoding=utf-8";
	private static final String NAME = "root";
	private static final String PASS = "0000abc!";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	
	public static void main(String[] args) {
		System.out.println("服务器端口2586监听启动..\r");
		Server server = new Server();
		server.init();
	}
	
	public void init(){
		try {
			ServerSocket serverSocket = new ServerSocket(PORT);
	//		while (true) {
				// 一旦有堵塞, 则表示服务器与客户端获得了连接
				Socket client = serverSocket.accept();
				// 处理这次连接
				new HandlerThread(client);
	//		}
		} catch (Exception e) {
			System.out.println("服务器异常: " + e.getMessage());
		}
	}
	
	private class HandlerThread implements Runnable{

		private Socket socket;
		
		public HandlerThread(Socket client){
			socket = client;
			new Thread(this).start();
		}
		
		public void initEntityInfoMysql(String[] filters){
			Connection conn = null;
			Statement pStemt = null;
			StringBuffer sb = new StringBuffer("INSERT sys_fall_gps_data VALUES(");
			sb.append("'"+IdGen.uuid()+"',");
			sb.append("'"+filters[0]+"',");
			sb.append("'"+filters[1]+"',");
			sb.append("'"+filters[2]+"',");
			sb.append("'"+filters[3]+"',");
			String gps_date = DateUtils.formatDate(new Date()) + " " + filters[4];
			sb.append("'"+gps_date+"',");
			sb.append("'"+filters[5]+"',");
			sb.append("'"+filters[6]+"',");
			String lbs_date = DateUtils.formatDate(new Date()) + " " + filters[7];
			sb.append("'"+lbs_date+"',");
			sb.append("'"+filters[8]+"',");
			sb.append("'"+filters[9]+"',");
			sb.append("'"+filters[10]+"',");
			String create_date = DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
			sb.append("'"+create_date+"',");
			sb.append("'"+0+"')");
/*			String sql  = "INSERT sys_fall_gps_data(id, product_id, war, bat, temp, gps_date, gps_lat, gps_long," 
					+ "lbs_date, lbs_lat, lbs_long, take_medicine, create_date, del_flag)"
					+ " VALUES('c910e8c711114b42996183056ba9a051', '012896006527201', '00', '84', '26', '2015-12-08 16:32:25', 'N34.213245', 'E108.542152', '2015-12-08 16:32:25', 'N34.213245', 'E108.542152', '0', '2015-12-08 16:32:25', '0')";
*/			
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
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				// 读取客户端数据
				DataInputStream input = new DataInputStream(socket.getInputStream());
				String clientInputStr  = input.readUTF(); //这里要注意和客户端输出流的写方法对应,否则会抛 EOFException
				 // 处理客户端数据
				if(clientInputStr.startsWith("+STAR:")){
					String data = clientInputStr.substring(6, clientInputStr.lastIndexOf("\r\n"));
					initEntityInfoMysql(data.split(",")); 
				}
				System.out.println(clientInputStr);
//				// 向客户端回复信息
//				DataOutputStream out = new DataOutputStream(socket.getOutputStream());
//				String s = "向客户端回复信息";
//				out.writeUTF(s);
//				out.close();
				input.close();
			} catch (Exception e) {
				System.out.println("服务器 run 异常: " + e.getMessage());  
			} finally {
				if( socket != null){
					try {
						socket.close();
					} catch (Exception ex) {
						socket = null;
						System.out.println("服务端 finally 异常:" + ex.getMessage()); 
					}
				}
			}
		}
		
	}
	
}
