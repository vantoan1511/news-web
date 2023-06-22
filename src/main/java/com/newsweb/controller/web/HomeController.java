package com.newsweb.controller.web;

import java.io.IOException;
import java.io.Serial;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newsweb.model.UserModel;
import com.newsweb.service.IUserService;
import com.newsweb.utilities.FormUtility;

@WebServlet(urlPatterns = {"/home", "/login"})
public class HomeController extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;
    @Inject
    private IUserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        RequestDispatcher dispatcher;
        if (action != null && action.equals("login")) {
            dispatcher = req.getRequestDispatcher("/views/login.jsp");
        } else if (action != null && action.equals("logout")) {
            dispatcher = req.getRequestDispatcher("/views/web/home.jsp");
        } else {
            dispatcher = req.getRequestDispatcher("/views/web/home.jsp");
        }
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action != null && action.equals("login")) {
            UserModel model = FormUtility.toModel(UserModel.class, req);
            model = userService.findByUsernameAndPasswordAndStatus(model.getUsername(), model.getPassword(), 1);
            if (model != null) {
                if (model.getRole().getCode().equals("USER")) {
                    resp.sendRedirect(req.getContextPath() + "/home");
                } else if (model.getRole().getCode().equals("ADMIN")) {
                    resp.sendRedirect(req.getContextPath() + "/admin-home");
                }
            } else {
                resp.sendRedirect(req.getContextPath() + "/login?action=login");
            }
        }
    }
}
