package com.statsd.service;

import org.springframework.stereotype.Service;

import com.statsd.aspect.Timed;

@Service
public class BusinessServiceImpl implements BusinessService {
	/**
	* this method will be advised because it has the timed annotation
	*/
	@Timed(timingNotes = "this is a slow service")
	public void performTask() {
		// do something useful
		try {
			Thread.currentThread().sleep(400);
			System.out.println("Inside useful business method");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
		
		

	}

}
