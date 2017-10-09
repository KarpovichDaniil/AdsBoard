package by.intexsoft.adsboard.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import by.intexsoft.adsboard.model.Users;
import by.intexsoft.adsboard.service.UsersService;
import ch.qos.logback.classic.Logger;

@RestController
public class UsersController {
	private static Logger logger = (Logger) LoggerFactory.getLogger(UsersController.class.getName());

	@Autowired
	private final UsersService usersService;

	@Autowired
	public UsersController(UsersService usersService) {
		this.usersService = usersService;
	}

	@RequestMapping(path = "/user/add", method = RequestMethod.POST)
	public ResponseEntity<?> add(@RequestBody Users entity) {
		logger.info("Creation of a new user with username: " + entity.username + " ,password" + entity.password
				+ " ,email" + entity.email + " and enabled" + entity.enabled);
		try {
			return new ResponseEntity<Users>(usersService.save(entity), HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("Error while saving new user with username: " + entity.username + " ,password"
					+ entity.password + " ,email" + entity.email + " or enabled" + entity.enabled);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping("/del/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
		logger.info("Delete user with id= " + id);
		try {
			usersService.deleteById(id);
		} catch (Exception e) {
			logger.error("User with id= " + id + " is not exist");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public Users findOne(@PathVariable("id") Long id) {
		logger.info("Request was received to find a single user {}", id);
		return usersService.findOne(id);
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<Users> findAll() {
		logger.info("Request was received to retrieve all users");
		return usersService.findAll();
	}
}
