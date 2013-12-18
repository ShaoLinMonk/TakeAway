package com.foodie.repository;

import static org.junit.Assert.assertEquals;
import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.foodie.BaseSpringDAOTest;
import com.foodie.model.Image;

public class ImageDAOTest extends BaseSpringDAOTest {
	
	@Autowired
	private ImageDAO imageDAO;
	
	@Test
	public void addImageTest(){
		
		String testString = "this is a test";
		Image image = new Image();
		image.setTitle(testString);
		image.setImage(testString.getBytes());
		imageDAO.addImage(image);
		System.out.println(image.getId());
		Image testImage = imageDAO.getImageById(image.getId());
		assertEquals(image.getTitle(),testImage.getTitle());
		assertEquals(image.getImage(),testImage.getImage());
		
		
	}
}
