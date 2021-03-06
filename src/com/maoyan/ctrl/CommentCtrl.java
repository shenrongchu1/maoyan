package com.maoyan.ctrl;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maoyan.bean.Comment;
import com.maoyan.service.MovieServiceImpl;

/**
 * Servlet implementation class ServletManager3
 */
@WebServlet("/commentCtrl")
@SuppressWarnings("serial")
public class CommentCtrl extends HttpServlet {

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommentCtrl() {
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
		// �����ַ����룺request��response
		request.setCharacterEncoding("utf-8"); // ������Ƿ�������ǰ�˱���
		response.setCharacterEncoding("utf-8"); // ������Ƿ������ĺ�˱���
		response.setContentType("text/html;charset=utf8"); // �������������ı���

		// ���ս���movies_list.jsp�����������Ϣ��ͨ��HttpServletRequest�����������������Ϣ
		// String userName = (String) request.getSession().getAttribute("");
		String userName = "冼世达";
		String grade = request.getParameter("grade");
		// String remark=request.getParameter("remark");
		String content = request.getParameter("content");
		String time = request.getParameter("time");

		// �����յ���Ϣ�����comment������
		Comment comment = new Comment();
		comment.setUserName(userName);
		comment.setGrade(grade);
		// comment.setRemark(remark);
		comment.setContent(content);
		comment.setCommentTime(time);

		// ��user��������ݣ�����һ����δ��ݡ�
		try {
			MovieServiceImpl.getMovieServiceImpl().addComment(comment);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.getRequestDispatcher("queryCommentCtrl").forward(request, response);

	}

}
