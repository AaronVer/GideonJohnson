package servlets;

//A lot of imports should be added here, check Github
import com.revature.model.Artist;
//import com.revature.service.ArtistService;
//import com.revature.service.PaintingService;

//Figure out the correct import path to work for me

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
// This should work but doesn't since my Pom file isn't set up right
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

//@WebServlet("/add")

public class AddServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
        PrintWriter out = responce.getWriter();
        out.println("Welcome to the Addition Servlet!");

        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));
        out.println(num1 + " + " + num2 + " = " + (num1 + num2));

        out.println("Here are my favorite paintings: ");
        //ArtistService as = new ArtistService();
        //
    }
}



