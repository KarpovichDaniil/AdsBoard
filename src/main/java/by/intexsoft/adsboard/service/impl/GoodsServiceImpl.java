package main.java.by.intexsoft.adsboard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.by.intexsoft.adsboard.entity.GoodsEntity;
import main.java.by.intexsoft.adsboard.repository.GoodsEntityRepository;
import main.java.by.intexsoft.adsboard.service.GoodsService;

@Service
public class GoodsServiceImpl extends AbstractEntityServiceImpl<GoodsEntity> implements GoodsService{
	@Autowired
	GoodsEntityRepository repostitory;
}
