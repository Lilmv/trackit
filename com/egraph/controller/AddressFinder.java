/**
 * 
 */
package com.egraph.controller;
import java.net.*; 
import java.io.*; 

/**
 * @author egraph
 *
 */
public class AddressFinder {
	public static String IpFinder(String IP)
    { 
        // Returns the instance of InetAddress containing 
        // local host name and address 
        /*InetAddress localhost = InetAddress.getLocalHost(); 
        System.out.println("System IP Address : " + 
                      (localhost.getHostAddress()).trim()); */
  
        // Find public IP address 
        String systemipaddress = ""; 
        try
        { 
            URL url_name = new URL("http://api.ipstack.com/"+ IP +"?access_key=2e89965144b8732599379288314c6e52"); 
  
            BufferedReader sc = new BufferedReader(new InputStreamReader(url_name.openStream())); 
  
            // reads system IPAddress ru
            systemipaddress = sc.readLine().trim(); 
        } 
        catch (Exception e) 
        { 
            systemipaddress = "Cannot Execute Properly"; 
        } 
		return systemipaddress; 
    } 

}


  
