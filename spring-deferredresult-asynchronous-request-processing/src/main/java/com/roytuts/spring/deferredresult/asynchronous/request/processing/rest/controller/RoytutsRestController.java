package com.roytuts.spring.deferredresult.asynchronous.request.processing.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
public class RoytutsRestController {

	private final static Logger logger = LoggerFactory.getLogger(RoytutsRestController.class.getName());

	@GetMapping("/test")
	public DeferredResult<String> getTestRequest() {
		logger.info("Request processing started");

		final DeferredResult<String> deferredResult = new DeferredResult<>();

		setResultInOtherThread(deferredResult);

		logger.info("Request processing finished");

		return deferredResult;
	}

	private void setResultInOtherThread(DeferredResult<String> deferredResult) {
		new Thread(() -> {
			logger.info("Deferred task started");

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			logger.info("Deferred task finished");

			deferredResult.setResult("Test deferred result");
		}).start();
	}

}
