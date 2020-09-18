package com.with.common.listener;

import javax.servlet.ServletContextEvent;
import com.with.common.AESCrypto;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class CryptorListener
 *
 */
@WebListener
public class CryptorListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public CryptorListener() {
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	new AESCrypto();
    }
	
}
