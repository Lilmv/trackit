package com.egraph.menu;

import java.awt.BorderLayout;
//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.egraph.menu.Menu;


import javax.swing.JLabel;
import java.awt.Font;
//import java.awt.Frame;

import javax.swing.JTextField;
import javax.swing.JButton;
import com.egraph.controller.*;
import com.egraph.model.*;
//import com.teamdev.jxbrowser.chromium.dom.By;
//import com.teamdev.jxbrowser.chromium.dom.DOMDocument;
//import com.teamdev.jxbrowser.chromium.dom.DOMElement;
//import com.teamdev.jxbrowser.chromium.dom.DOMInputElement;

@SuppressWarnings("serial")
public class Menu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private javax.swing.JPanel map_panel;
	private String Longitude;
	private String Latitude;
	
	
	/**
	 * Launch the application.
	 */
		

	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		setSize(800,600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 800, 576);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblEgraph = new JLabel("E-Graph");
		lblEgraph.setFont(new Font("Laksaman", Font.BOLD | Font.ITALIC, 20));
		lblEgraph.setBounds(12, 10, 88, 30);
		panel.add(lblEgraph);
		
		JLabel lblIpTracer = new JLabel("IP Tracer");
		lblIpTracer.setFont(new Font("Ubuntu", Font.BOLD, 20));
		lblIpTracer.setBounds(98, 12, 100, 30);
		panel.add(lblIpTracer);
		
		map_panel = new JPanel();
		map_panel.setBounds(195, 0, 593, 576);
		panel.add(map_panel);
		map_panel.setLayout(new BorderLayout(0, 0));
		
		textField = new JTextField();
		textField.setBounds(12, 57, 171, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(39, 133, 117, 25);
		panel.add(btnSearch);
		btnSearch.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				JButtonSearchActionPerformed(evt);
			}
		});
		
		JButton btnReload = new JButton("Reload");
		btnReload.setBounds(39, 517, 117, 25);
		panel.add(btnReload);
		btnReload.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				JButtonReloadActionPerformed(evt);
			}
		});
		
		DisplayBrowser site = new DisplayBrowser();
		site.open_site(map_panel,Latitude, Longitude);
	}
	
	private void JButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {
		System.out.println(textField.getText());
		String Response = AddressFinder.IpFinder(textField.getText());
		GetLocationCoord result = new GetLocationCoord();
		String[] List = result.getCoord(Response);
		System.out.println("Latitude : " + List[21] + " Longitude : " + List[23]);
		
		//Menu men = new Menu();
		//men.setVisible(true);
		DisplayBrowser site = new DisplayBrowser();
		site.open_site(map_panel,List[21], List[23]);
		
		
	}
	
	private void JButtonReloadActionPerformed(java.awt.event.ActionEvent evt) {
		DisplayBrowser site = new DisplayBrowser();
		site.open_site(map_panel,Latitude, Longitude);
		
	}
}
