package com.litoos11.oracle.component;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("taskComponent")
public class TastkComponent {

	private static final Log LOG = LogFactory.getLog(TastkComponent.class);

	@Scheduled(fixedDelay = 5000)
	public void doTask() {
		LOG.info("TIME IS: " + new Date());
	}
}
