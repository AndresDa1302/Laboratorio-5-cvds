/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.servlet;

import edu.eci.cvds.servlet.model.Todo;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author javier lopez
 * @author Andres Davila
 */
@WebServlet(
    urlPatterns = "/andresJavier"
)
public class Servlets extends  HttpServlet {
    private ArrayList<Todo> todos = new ArrayList<Todo>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer responseWriter = resp.getWriter();
        Optional<String> optName = Optional.ofNullable(req.getParameter("id"));
        String name = optName.isPresent() && !optName.get().isEmpty() ? optName.get() : "";
        try{
            int id = Integer.parseInt(name);
            Todo todo = Service.getTodo(id);
            todos.add(todo);
            responseWriter.write(Service.todosToHTMLTable(todos));
            responseWriter.flush();

        
        }catch(NumberFormatException e){

            resp.setStatus(HttpServletResponse.	SC_BAD_REQUEST);
        
    
            
        }catch(MalformedURLException e){
            
            resp.setStatus(HttpServletResponse.	SC_INTERNAL_SERVER_ERROR);

            
        }catch(FileNotFoundException e){
  
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            responseWriter.write("No existe un item con el identificador dado.");
            responseWriter.flush();
        
        }catch(Exception e){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            
        }
        
 
        
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Writer responseWriter = resp.getWriter();
        Optional<String> optName = Optional.ofNullable(req.getParameter("id"));
        String name = optName.isPresent() && !optName.get().isEmpty() ? optName.get() : "";
        try{
            int id = Integer.parseInt(name);
            Todo todo = Service.getTodo(id);
            todos.add(todo);
            resp.setStatus(HttpServletResponse.SC_OK);
            responseWriter.write(Service.todosToHTMLTable(todos));
            responseWriter.flush();

            
        
        }catch(NumberFormatException e){

            resp.setStatus(HttpServletResponse.	SC_BAD_REQUEST);
        
    
            
        }catch(MalformedURLException e){
            
            resp.setStatus(HttpServletResponse.	SC_INTERNAL_SERVER_ERROR);

            
        }catch(FileNotFoundException e){
  
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            responseWriter.write("No existe un item con el identificador dado.");
            responseWriter.flush();
        
        }catch(Exception e){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            
        }  
    }
    
}