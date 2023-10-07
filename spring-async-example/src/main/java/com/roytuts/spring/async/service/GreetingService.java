package com.roytuts.spring.async.service;

import java.util.Date;
import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

	@Async
	public Future<String> getGreetingMsg(final String name) throws InterruptedException {
		System.out.println("Execute method asynchronously. " + Thread.currentThread().getName());
		Thread.sleep(1000);
		return new AsyncResult<String>("Hello! Good Morning, " + name);
	}

	@Async
	public void logMsg() {
		System.out.println("Execute method asynchronously. " + Thread.currentThread().getName());
		System.out.println("Today's date: " + new Date());
	}

}
