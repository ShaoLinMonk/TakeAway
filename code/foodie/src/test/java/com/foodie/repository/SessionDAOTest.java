package com.foodie.repository;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.foodie.BaseSpringDAOTest;
import com.foodie.model.session.Session;

public class SessionDAOTest extends BaseSpringDAOTest {

	@Autowired
    private SessionDAO sessionDAO;
    
    //TODO: hard-coded userId joker should be replaced by a constant value
    @Test
    public void testGetSessionBySessionId() {
        Session session = new Session();
        session.setUserId("joker");
        pm.makePersistent(session);
        Assert.assertEquals("joker", sessionDAO.getSessionById(session.getSessionId()).getUserId());


    }

}
