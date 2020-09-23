package com.capgemini.omts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.omts.entity.ScreenBean;
import com.capgemini.omts.exceptions.InvalidInputException;
import com.capgemini.omts.exceptions.ScreenException;
import com.capgemini.omts.exceptions.TheatreAlreadyExistsException;
import com.capgemini.omts.repository.ScreenRepo;

@Service
public class ScreenServiceImpl implements IScreenService {
	@Autowired
	ScreenRepo screenRepo;

	@Override
	public ScreenBean addScreen(ScreenBean bean) {
		
		Integer screenId = bean.getScreenId();

		if (screenId == 0)
		{
			throw new InvalidInputException("screen id must be minimum of four characters");
		} 
		else if (screenRepo.existsById(screenId)) 
		{
			throw new TheatreAlreadyExistsException("user already exists with this id :" + screenId);
		}

		return screenRepo.saveAndFlush(bean);
	}

	@Override
	public boolean deleteScreen(int screenId) {
		
		if (screenRepo.existsById(screenId))
		{
			screenRepo.deleteById(screenId);
		}
		else {
			throw new ScreenException("Id not found");
		    }
		return true;

	}

	@Override
	public List<ScreenBean> getAllScreens() {
		
		return screenRepo.findAll();
	}

}
