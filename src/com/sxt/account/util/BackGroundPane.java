package com.sxt.account.util;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BackGroundPane extends JPanel{
		
	   String imgSrc = null;
	   int width,height;
	   
		public BackGroundPane(String imgSrc,int w,int h){
			this.imgSrc = imgSrc;
			this.width = w;
			this.height = h;
			
		}
		/**
		 * 系统调用的，但是用户需要重写的
		 */
		public void paintComponent(Graphics  g){
			g.drawImage(new ImageIcon(imgSrc).getImage() , 0, 0, width, height,  null);
			
		}
		
	}
