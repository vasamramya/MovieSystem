package com.capgemini.omts.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="Screen_Boot")
public class ScreenBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	
	private int screenId;
	
	@NotEmpty(message = "ScreenName is Mandatory field.Please provide Screen Name")
	@Size(min = 4, message = "Name should have atleast 4 characters")
	private String screenName;
	
	@NotNull(message = "TheatreId is Mandatory field.Please provide TheatreId")
	@Min(value = 4, message = "Theater Id will be min 4 digit starting with 2")
	@Max(value = 100, message = "Theatre Id cannot be greater than 100")
	private int theatreId;
	
	@DateTimeFormat(pattern="YYYY-MM-DD")
    private LocalDate movieEndDate;

	public int getScreenId() {
		return screenId;
	}

	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public int getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}

	public LocalDate getMovieEndDate() {
		return movieEndDate;
	}

	public void setMovieEndDate(LocalDate movieEndDate) {
		this.movieEndDate = movieEndDate;
	}

	@Override
	public String toString() {
		return "ScreenBean [screenId=" + screenId + ", screenName=" + screenName + ", theatreId=" + theatreId
				+ ", movieEndDate=" + movieEndDate + "]";
	}
	
	

}
