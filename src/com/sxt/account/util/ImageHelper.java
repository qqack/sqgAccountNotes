package com.sxt.account.util;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * @desc:������ͼƬ������
 * @version v1.0
 * @author phenixchen
 * @date: 2015-08-04 pm:15
 *
 */
public class ImageHelper {
	/**
	 * ��ȡһ��ָ����С��ͼƬ
	 * @param width
	 * @param height
	 * @param imgUrl  ͼƬ·��
	 * @return ImagIcon
	 */
	public static ImageIcon getScaledIcon(int width,int height,String imgUrl){
		Image  smallImg =new  ImageIcon(imgUrl).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return new ImageIcon(smallImg);
	}
	
	/**
	 * ��ȡһ��ָ����С��ͼƬ
	 * @param width
	 * @param height
	 * @param imgUrl ͼƬ·��
	 * @return Image
	 */
	public static Image getScaledImg(int width,int height,String imgUrl){
		Image  smallImg =new  ImageIcon(imgUrl).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return smallImg;
	}

}
