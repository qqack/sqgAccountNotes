package com.sxt.account.util;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * @desc:用于做图片的设置
 * @version v1.0
 * @author phenixchen
 * @date: 2015-08-04 pm:15
 *
 */
public class ImageHelper {
	/**
	 * 获取一个指定大小的图片
	 * @param width
	 * @param height
	 * @param imgUrl  图片路径
	 * @return ImagIcon
	 */
	public static ImageIcon getScaledIcon(int width,int height,String imgUrl){
		Image  smallImg =new  ImageIcon(imgUrl).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return new ImageIcon(smallImg);
	}
	
	/**
	 * 获取一个指定大小的图片
	 * @param width
	 * @param height
	 * @param imgUrl 图片路径
	 * @return Image
	 */
	public static Image getScaledImg(int width,int height,String imgUrl){
		Image  smallImg =new  ImageIcon(imgUrl).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return smallImg;
	}

}
