package com.maoyan.ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maoyan.bean.Movie;
import com.maoyan.service.MovieServiceImpl;

/**
 * Servlet implementation class addMovieCtrl
 */
@WebServlet("/AddMovieCtrl")
public class AddMovieCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddMovieCtrl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Movie movie = new Movie();
		boolean show;
		if (request.getParameter("show").equals("已上映")) {
			show = true;
		} else {
			show = false;
		}
		movie.setMovieName(request.getParameter("name"));
		movie.setPrice(Double.parseDouble(request.getParameter("price")));
		movie.setType(request.getParameter("type"));
		movie.setMovieLong(request.getParameter("movieLong"));
		movie.setOnShow(show);

		// request.getParameter("moviePost");
		System.out.println(show);
		MovieServiceImpl.getMovieServiceImpl().addMovie(movie);

	}

}
