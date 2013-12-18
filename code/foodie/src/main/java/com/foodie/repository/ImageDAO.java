package com.foodie.repository;

import com.foodie.model.Image;

public interface ImageDAO {

	public Image getImageById(Long id);
	public void addImage(Image image);
}
