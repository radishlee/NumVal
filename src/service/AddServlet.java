package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.StringUtils;

import dao.NumValDao;


public class AddServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		
		
		if(StringUtils.isNullOrEmpty(no)){
			writeErrorMsg(response);
		}
		
		NumValDao dao = new NumValDao();
		if(dao.addNum(no)){
			writeSuccMsg(response);
		}else{
			writeFailMsg(response);
		}
	}

	private void writeFailMsg(HttpServletResponse response) {
		String msg = "-1";
		printMsg(response,msg);
	}

	private void writeSuccMsg(HttpServletResponse response) {
		String msg = "1";
		printMsg(response,msg);
	}

	private void writeErrorMsg(HttpServletResponse response) {
		String msg = "-2";
		printMsg(response,msg);
	}

	private void printMsg(HttpServletResponse response, String msg) {
		try {
			response.getWriter().print(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
