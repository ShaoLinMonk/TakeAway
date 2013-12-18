package com.foodie.model;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Blob;
import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Image {

	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private Key key;
	
	@Persistent
	private String title;
	
	@Persistent
	private Blob image;
	
	public Long getId() {
		return key.getId();
	}
	
	public String getTitle() {
		return title;
	}
	
	public byte[] getImage() {
		if(image == null) {
			return null;
		}
		
		return image.getBytes();
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setImage(byte[] bytes) {
		this.image = new Blob(bytes);
	}
}
	
