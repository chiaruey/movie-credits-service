package com.ruey.movie.credit.model;

import java.util.List;

public class MovieCredits {

	private int id;

	private List<MovieCredit> cast;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<MovieCredit> getCast() {
		return cast;
	}

	public void setCast(List<MovieCredit> cast) {
		this.cast = cast;
	}

}
