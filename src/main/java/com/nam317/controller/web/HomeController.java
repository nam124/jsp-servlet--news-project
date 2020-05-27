package com.nam317.controller.web;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nam317.Utils.FormUtil;
import com.nam317.Utils.SessionUtil;
import com.nam317.model.UserModel;
import com.nam317.service.ICategoryServicve;
import com.nam317.service.IUserService;  
@WebServlet(urlPatterns = {"/trang-chu","/dang-nhap","/thoat"})
public class HomeController extends HttpServlet {
	@Inject
	private ICategoryServicve categoryServicve;
	@Inject
	private IUserService userService;

	private static final long serialVersionUID = -4017428989940305205L;
	ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{	
		String action = request.getParameter("action");
		if(action != null && action.equals("login")) {
			String alert = request.getParameter("alert");
			String message = request.getParameter("message");
			if(message != null && alert != null) {
				request.setAttribute("message", resourceBundle.getString(message));
				request.setAttribute("alert", alert);
			}
			RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
			rd.forward(request, response);
		} else if(action != null && action.equals("logout")) {
			SessionUtil.getInstance().removeValue(request, "USERMODEL");
			response.sendRedirect(request.getContextPath()+"/trang-chu");
		}else {
			
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
			rd.forward(request, response);	
		} 
	}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	String action = request.getParameter("action");
	if(action != null && action.equals("login")) {
		UserModel model = FormUtil.toModel(UserModel.class, request);
		model = userService.findByUserNameAndPasswordAndStatus(model.getUserName(), model.getPassword(), 1);
		if(model != null) {
			SessionUtil.getInstance().putValue(request, "USERMODEL", model);
			if(model.getRole().getCode().equals("USER")) {
				response.sendRedirect(request.getContextPath()+"/trang-chu");
			}else if(model.getRole().getCode().equals("ADMIN")) {
				response.sendRedirect(request.getContextPath()+"/admin-home");
			}
		}else {
			response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login&message=username_password_invalid&alert=danger");
		}
		} 
	}

}
