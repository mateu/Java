import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.IOException;

public class SumGame extends HttpServlet {

	int my_score = 0;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String message, n1, n2, answer;

		message = request.getParameter("message");
		n1 = request.getParameter("n1");
		n2 = request.getParameter("n2");

		if (message != null) {
			answer = "";
			try {
				answer = request.getParameter("answer");
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (Integer.parseInt(answer) == Integer.parseInt(n1)
					+ Integer.parseInt(n2)) {
				my_score++;
				message = "Good job. Your score is now: " + my_score;
			} else {
				my_score--;
				message = "No, that was not the answer.  Your score is now: "
						+ my_score;
			}
			n1 = (int) (Math.random() * 100) + "";
			n2 = (int) (Math.random() * 100) + "";
		} else {
			message = "Welcome";
			n1 = (int) (Math.random() * 100) + "";
			n2 = (int) (Math.random() * 100) + "";
		}

		// The form used to submit answers
		String html_form = "<form>"
				+ message
				+ "<p>"
				+ "What is "
				+ n1
				+ " + "
				+ n2
				+ "? Type answer here: <input type='text' name='answer' size='4'> <p>"
				+ "Press <input type='submit' value='Proceed'> when ready to move on."
				+

				"<input type='hidden' name='message' value='message'>"
				+ "<input type='hidden' name='n1' value='" + n1 + "'>"
				+ "<input type='hidden' name='n2' value='" + n2 + "'>"
				+ "</form>";

		out.println("<html><head><title>Sum Game Servlet</title></head>");
		out.println("<body>");
		out.println(html_form);
		out.println("</body>\n</html>");
	}
}
