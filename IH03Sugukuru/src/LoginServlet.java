
/**
 * Author : I.Asakawa
 * Created date : 2016/11/08
 * 
 * description : ログイン処理
 */

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

		/* 文字化け対策 */
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		/* jspString */
		String strjsp = "";
		String errorMsg= "";
		boolean flg;

		/* 値取得 */
		String employee_code = request.getParameter("code");
		String pass = request.getParameter("pass");

		/* sessionスタート */
		HttpSession session = request.getSession(true);

		/* ユーザの確認（DB接続） */
		if (employee_code.equals("admin")) {
			if (pass.equals("pass")) {
				flg = true;
			} else {
				flg = false;
			}
		} else {
			flg = false;
		}
		/* ユーザ確認 end */

		if(flg){
			strjsp = "index.jsp";
			session.setAttribute("code", employee_code);
		}else{
			strjsp = "login.jsp";
			errorMsg = "従業員コード・パスワードのいずれかが<br>間違っています";
			request.setAttribute("error", errorMsg);
		}
		
		
		/* ページ遷移 */
		RequestDispatcher rd = request.getRequestDispatcher("./" + strjsp);
		rd.forward(request, response);
	}

}
