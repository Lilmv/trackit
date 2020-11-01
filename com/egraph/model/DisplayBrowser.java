package com.egraph.model;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import com.teamdev.jxbrowser.engine.RenderingMode;
import com.teamdev.jxbrowser.navigation.event.FrameLoadFinished;
import com.teamdev.jxbrowser.view.swing.BrowserView;
import com.teamdev.jxbrowser.zoom.ZoomLevel;

public class DisplayBrowser {
	public void open_site(JPanel map_panel,String Latitude, String Longitude) {
		

		/**
		 * Load map into the map_panel
		 */
	    	
	    	Engine engine = Engine.newInstance(
	    	        EngineOptions.newBuilder(RenderingMode.HARDWARE_ACCELERATED)
	    	                .licenseKey("1BNDHFSC1FWRF606ZNKM551WBQ3EJXYR0U41V8A9XPGILME2O7FSV6GDAH3ELM41G747JR")
	    	                .build());
	    	System.setProperty("jxbrowser.license.key", "1BNDHFSC1FWRF606ZNKM551WBQ3EJXYR0U41V8A9XPGILME2O7FSV6GDAH3ELM41G747JR");
	    	//BrowserUtil;
	    	Browser browser = engine.newBrowser();
	    	BrowserView view = BrowserView.newInstance(browser);
	    	System.out.println(map_panel+" "+view);	
	    	map_panel.add(view, BorderLayout.CENTER);
	    	
			/*browser.on(TitleChanged.class, event -> setTitle(evt.getTitle()));
			
	    	browser.on(ConsoleMessageReceived.class, event -> 
	    	        System.out.println("LOG: " + evt.getMessage()));*/
	
	    	browser.navigation().on(FrameLoadFinished.class, event -> {
	    	    event.frame().browser().zoom().level(ZoomLevel.P_80);
	    	});
	    	String url = "127.0.0.1/simple_map.php?lat="+Latitude+"&long="+Longitude;
	    	//String url = "https://www.google.com/maps/";
	    	//String url = "///home/egraph/Documents/ipTracer/simple_map.html";
	    	browser.navigation().loadUrl(url);
	    	
	    }
}
