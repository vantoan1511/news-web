package com.newsweb.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.newsweb.model.NewsModel;
import com.newsweb.model.UserModel;
import com.newsweb.service.INewsService;
import com.newsweb.utilities.HttpUtility;
import com.newsweb.utilities.SessionUtility;

@WebServlet(urlPatterns = { "/api-admin-news" })
public class NewsAPI extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private INewsService newsService;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		NewsModel news = HttpUtility.of(req.getReader()).toModel(NewsModel.class);
		news.setCreateBy(((UserModel) SessionUtility.getInstance().getValue(req, "USERMODEL")).getUsername());
		news = newsService.save(news);
		mapper.writeValue(resp.getOutputStream(), news);
//		System.out.println(news);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		NewsModel news = HttpUtility.of(req.getReader()).toModel(NewsModel.class);
		newsService.delete(news.getIds());
		mapper.writeValue(resp.getOutputStream(), "{}");
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		NewsModel updatedNews = HttpUtility.of(req.getReader()).toModel(NewsModel.class);
		updatedNews.setModifyBy(((UserModel) SessionUtility.getInstance().getValue(req, "USERMODEL")).getUsername());
		updatedNews = newsService.update(updatedNews);
		mapper.writeValue(resp.getOutputStream(), updatedNews);
	}
}
