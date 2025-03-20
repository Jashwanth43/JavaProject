package feb22AdvServlets;  

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
@WebServlet("/image")
public class ImagesServlets extends HttpServlet {
	static {
		System.out.println("tightern your seatbealts");
	}
	public void init() {
		System.out.println("getting initiated");
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException {
		response.setContentType("application/pdf"); //for pdf file
		//response.setContentType("image/jpg");
		ServletOutputStream sos=response.getOutputStream();
		String path=getServletContext().getRealPath("test.pdf");
		File file=new File(path);
		FileInputStream fir=new FileInputStream(file);
		byte[]b =new byte[(int) file.length()];
		fir.read(b); 
		sos.write(b);
		
		sos.flush();
		fir.close();
		sos.close();
		
	}
}
