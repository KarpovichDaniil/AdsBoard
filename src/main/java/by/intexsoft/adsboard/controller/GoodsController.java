package by.intexsoft.adsboard.controller;

import java.util.List;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import by.intexsoft.adsboard.model.Goods;
import by.intexsoft.adsboard.service.GoodsService;

@RestController
public class GoodsController {
	private static Logger logger = (Logger) LoggerFactory.getLogger(GoodsController.class.getName());

	private final GoodsService goodsService;

	@Autowired
	public GoodsController(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	@RequestMapping(value = "/goods", method = RequestMethod.GET)
	public List<Goods> findAll() {
		logger.info("Request was received to retrieve all users");
		return goodsService.findAll();
	}

	@RequestMapping(path = "/goods/add", method = RequestMethod.POST)
	public ResponseEntity<?> add(@RequestBody Goods entity) {
		logger.info("Creation of a new goods with title: " + entity.title + " ,description" + entity.description
				+ " ,city" + entity.city + " ,user" + entity.user + " ,price" + entity.price + " ,created_date"
				+ entity.created_date + " and category" + entity.category);
		try {
			return new ResponseEntity<Goods>(goodsService.save(entity), HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("Error while saving new goods with title: " + entity.title + " ,description"
					+ entity.description + " ,city" + entity.city + " ,user" + entity.user + " ,price" + entity.price
					+ " ,created_date" + entity.created_date + " or category" + entity.category);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping("/goods/del/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
		logger.info("Delete goods with id= " + id);
		try {
			goodsService.deleteById(id);
		} catch (Exception e) {
			logger.error("Goods with id= " + id + " is not exist");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/goods/{id}", method = RequestMethod.GET)
	public Goods findOne(@PathVariable("id") Long id) {
		logger.info("Request was received to find a single user {}", id);
		return goodsService.findOne(id);
	}

}
