package com.microservice.service;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.model.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	
	public List<User> fetchFirstFityRandomUsers() {

		log.info("Inside fetchFirstFityRandomUsers()");
		List<User> users = readUserData();
		List<User> _5OUsers = new ArrayList<>();
		int max = 50;
		Random rand = new Random();
		int randomIndex = 0;

		for (int i = 0; i < max; i++) {

			randomIndex = rand.nextInt(users.size());
			_5OUsers.add(users.get(randomIndex));

		} 

		return _5OUsers;
	}

	public List<User> readUserData() {

		List<User> listOfUsers = null;
		
		try (InputStream inputStream = getClass().getResourceAsStream("/UserData.json");
				BufferedInputStream  stream = new BufferedInputStream(inputStream)) {
			
			ObjectMapper mapper = new ObjectMapper();
			listOfUsers = mapper.readValue(stream.readAllBytes(), mapper.getTypeFactory().constructCollectionType(List.class, User.class));

			log.info("Size of Users list -> " + listOfUsers.size());
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		
		return listOfUsers;
	}
}
