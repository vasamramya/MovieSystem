package com.capgemini.omts.service;

import java.util.List;

import com.capgemini.omts.entity.ScreenBean;

public interface IScreenService {

	public ScreenBean addScreen(ScreenBean bean);

	public boolean deleteScreen(int screenId);

	public List<ScreenBean> getAllScreens();
}
