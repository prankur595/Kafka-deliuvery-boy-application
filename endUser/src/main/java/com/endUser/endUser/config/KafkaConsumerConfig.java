package com.endUser.endUser.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import com.endUser.endUser.AppConstants;

@Configuration
public class KafkaConsumerConfig
{

	Logger logger = LoggerFactory.getLogger(KafkaConsumerConfig.class);

	@KafkaListener(topics = AppConstants.LOCATION_UPDATE_TOPIC, groupId = AppConstants.GROUP_ID)
	public void updatedLocation(String location)
	{
		logger.info("The current location is: " + location);
	}

}
