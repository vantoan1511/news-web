package com.newsweb.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newsweb.constant.SystemConstant;
import com.newsweb.model.NewsModel;
import com.newsweb.paging.Pagable;
import com.newsweb.paging.PageRequest;
import com.newsweb.service.INewsService;
import com.newsweb.sort.Sorter;
import com.newsweb.utilities.FormUtility;

@WebServlet(urlPatterns = { "/admin-news-list" })
public class NewsController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private INewsService newsService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		NewsModel model = FormUtility.toModel(NewsModel.class, req);
		Pagable pagable = new PageRequest(model.getPage(), model.getMaxPageItem(),
				new Sorter(model.getSortBy(), model.getSortOrder()));
		model.setLists(newsService.findAll(pagable));
		model.setTotalItem(newsService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
		req.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/news/list.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
