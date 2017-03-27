package pre_prova;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/preProva")
public class servlet_pre_prova extends HttpServlet  {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		String num1 = String.valueOf("Digite o Primeiro Numero: ");
		String num2 = String.valueOf("Digite o Segundo Numero: ");
		req.getParameter(num1);
		req.getParameter(num2);
		 
	}

}
