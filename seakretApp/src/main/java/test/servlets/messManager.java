package test.servlets;

import java.io.*;
import java.nio.file.Paths;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//this is the url extension to access the page
@WebServlet("/messManager")
public class messManager extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private String userName;
    private String message;
    private String destination;

    public messManager() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        File file = new File("../Users/" + request.getHeader("Username") + "/message.gif");
        if (file.exists()) {
            response.setStatus(200); //arg0.sendResponseHeaders(200, file.length());
            try ( OutputStream outputStream = response.getOutputStream()) {
                Files.copy(file.toPath(), outputStream);
                outputStream.close();
            }
        } else {
            PrintWriter out = response.getWriter();
            //On get request, display the text in the tags
            out.println("<html><body><h1 align='center'>"
                    + "No current messages.</h1> </body></html>");
        }
    }

    /**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub

        PrintWriter out = response.getWriter();
        response.setContentType("text/plain");

        StringBuilder buff = new StringBuilder();
        String line;
        BufferedReader reader = request.getReader();

        while ((line = reader.readLine()) != null) {
            buff.append(line);
        }

        message = buff.toString();
        userName = request.getHeader("Username");
        destination = request.getHeader("Destination");
        TextConverter tc = new TextConverter("jpeg");
        //Check if anything was properly read out of the request
        out.write(Paths.get("").toAbsolutePath().toString() + "\n");
        if (message == null) {
            response.setStatus(403);
            out.print("Error");
            return;
        }
        try {
            //Attempt to write out the Username and message sent in the request
            try {
                tc.toImage(message, destination);
            } catch (IOException c) {
                StackTraceElement[] stk = c.getStackTrace();
                for (StackTraceElement stk1 : stk) {
                    out.write("\n" + stk1);
                }
                out.write("\n Image failed");
            }
            out.write("User " + userName + " sent the message, \""
                    + message + "\", to " + destination + ".");
            response.setStatus(200);
            out.print("\nSuccess");
        } catch (Exception e) {
            response.setStatus(500);
            out.print("Error: " + e.getMessage());
            out.write("\nWe are here.");
        }
    }
}
