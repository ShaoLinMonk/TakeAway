package com.foodie.repository;

import javax.jdo.annotations.Transactional;

import org.springframework.stereotype.Repository;

import com.foodie.model.Image;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@Repository
public class ImageDAOImpl extends BaseDAO implements ImageDAO {
	
	@Override
	public Image getImageById(Long id) {
		Image result = null;
		try {
			Key key = KeyFactory.createKey(Image.class.getSimpleName(), id);
			result = pm.getObjectById(Image.class,key);
        } finally {
            pm.close();
            
        }
		return result;
	}

	@Override
	@Transactional
	public void addImage(Image image) {
		pm.makePersistent(image);

	}

}
