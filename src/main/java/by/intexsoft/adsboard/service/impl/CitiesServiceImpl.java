package main.java.by.intexsoft.adsboard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.by.intexsoft.adsboard.entity.CitiesEntity;
import main.java.by.intexsoft.adsboard.repository.CitiesEntityRepository;
import main.java.by.intexsoft.adsboard.service.CitiesService;

@Service
public class CitiesServiceImpl extends AbstractEntityServiceImpl<CitiesEntity> implements CitiesService{
	@Autowired
	CitiesEntityRepository repostitory;
}
