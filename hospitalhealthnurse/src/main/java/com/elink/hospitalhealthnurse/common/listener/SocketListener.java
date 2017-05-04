package com.elink.hospitalhealthnurse.common.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.elink.hospitalhealthnurse.common.socket.VNTCenter;

public class SocketListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public SocketListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("启动了Socket监听器");
    	new SocketThread(new VNTCenter()).start(); 
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }
	
}

class SocketThread extends Thread{

	private VNTCenter vntCenter;
	public SocketThread(VNTCenter vntCenter){
		this.vntCenter = vntCenter;
	}
	
	@Override
	public void run() {
		try {
			vntCenter.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
