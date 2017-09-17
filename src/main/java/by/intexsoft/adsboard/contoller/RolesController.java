package main.java.by.intexsoft.adsboard.contoller;

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

import main.java.by.intexsoft.adsboard.entity.RolesEntity;
import main.java.by.intexsoft.adsboard.service.RolesService;
import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/roles")
public class RolesController {
	private static Logger logger = (Logger) LoggerFactory.getLogger(CitiesController.class.getName());

	@Autowired
	RolesService rolesService;

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> add(@RequestBody RolesEntity entity) {
		logger.info("Creation of a new role with name: " + entity.name + "and description" + entity.description);
		try {
			return new ResponseEntity<RolesEntity>(rolesService.save(entity), HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("Error while saving new role with name: " + entity.name + "or description" + entity.description);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping("/del/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
		logger.info("Delete role with id= " + id);
		try {
			rolesService.deleteById(id);
		} catch (Exception e) {
			logger.error("Role with id= " + id + " is not exist");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping("/all")
	public ResponseEntity<?> findAll() {
		logger.info("Getting all roles");
		List<RolesEntity> resultList = rolesService.findAll();
		return new ResponseEntity<List<RolesEntity>>(resultList, HttpStatus.OK);
	}

}
