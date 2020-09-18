/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.servlet.model;

/**
 *
 * @author USUARIO
 */
public class Todo {
   private int userId=1;
   private int id=1;
   private String tittle="delectus aut autem";
   private boolean completed=false;
   
   public Todo(){
   } 
   
   public int getUserId()
   {
       return userId;
   }
   public int getId()
   {
       return id;
   }
   public String getTitle()
   {
       return tittle;
   }
   public boolean getCompleted()
   {
       return false;
   }
   public void setUserId(int userId)
   {
       this.userId=userId;
   }
   public void setId (int id)
   {
       this.userId=id;
   }
   public void setTittle(String tittle)
   {
       this.tittle=tittle;
   }
   public void setCompleted(boolean completed)
   {
       this.completed=completed;
   }
}
