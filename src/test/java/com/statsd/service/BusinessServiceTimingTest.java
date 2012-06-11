package com.statsd.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring-config.xml")

public class BusinessServiceTimingTest {

@Autowired
private BusinessService businessService;




	@Test
	public void testPerformTask() {
		// this will assert if exception was thrown
		businessService.performTask();
		
		
	}

}
