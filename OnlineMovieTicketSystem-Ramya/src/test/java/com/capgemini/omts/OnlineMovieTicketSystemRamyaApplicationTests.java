package com.capgemini.omts;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capgemini.omts.entity.ScreenBean;
import com.capgemini.omts.repository.ScreenRepo;
import com.capgemini.omts.service.ScreenServiceImpl;

@SpringBootTest
class OnlineMovieTicketSystemRamyaApplicationTests {

	@Autowired
	private ScreenServiceImpl screenService;
	@MockBean
	private ScreenRepo screenRepo;

	
	@Test
	public void testAddScreen() {
		ScreenBean bean = new ScreenBean();
		bean.setScreenId(15);
		bean.setTheatreId(29);
		bean.setScreenName("Ramya");
		bean.setMovieEndDate(LocalDate.parse("2020-12-12"));
		Mockito.when(screenRepo.saveAndFlush(bean)).thenReturn(bean);
		assertThat(screenService.addScreen(bean)).isEqualTo(bean);
	}
	


	@Test
	public void testGetAllScreens() {

		ScreenBean bean1 = new ScreenBean();
		bean1.setScreenId(15);
		bean1.setTheatreId(29);
		bean1.setScreenName("Ramya");
		bean1.setMovieEndDate(LocalDate.parse("2020-12-12"));

		ScreenBean bean2 = new ScreenBean();
		bean2.setScreenId(16);
		bean2.setTheatreId(29);
		bean2.setScreenName("Ramya");
		bean2.setMovieEndDate(LocalDate.parse("2020-12-12"));

		List<ScreenBean> screenlist = new ArrayList<>();
		screenlist.add(bean1);
		screenlist.add(bean2);
		Mockito.when(screenRepo.findAll()).thenReturn(screenlist);
		assertThat(screenService.getAllScreens()).isEqualTo(screenlist);
		assertEquals(screenlist.size(), 2);

	}
	@Test
	public void testGetAllScreens1() {

		ScreenBean bean1 = new ScreenBean();
		bean1.setScreenId(15);
		bean1.setTheatreId(29);
		bean1.setScreenName("Ramya");
		bean1.setMovieEndDate(LocalDate.parse("2020-12-12"));

		ScreenBean bean2 = new ScreenBean();
		bean2.setScreenId(16);
		bean2.setTheatreId(29);
		bean2.setScreenName("Ramya");
		bean2.setMovieEndDate(LocalDate.parse("2020-12-12"));

		List<ScreenBean> screenlist = new ArrayList<>();
		screenlist.add(bean1);
		screenlist.add(bean2);
		Mockito.when(screenRepo.findAll()).thenReturn(screenlist);
		assertThat(screenService.getAllScreens()).isEqualTo(screenlist);
		assertEquals(screenlist.size(), 3);

	}



}
