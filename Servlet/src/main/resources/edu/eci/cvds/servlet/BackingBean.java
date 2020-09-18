/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.eci.cvds.servlet;


import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Andres felipe davila
 * @author Javier Lopez
 */


@ManagedBean(name = "calculadoraBean")
@SessionScoped
public class BackingBean implements Serializable{
    
    private ArrayList<Double> numeros= new ArrayList<Double>();
  
    public BackingBean() {
        
    }

    public ArrayList<Double> getNumeros() {
        return numeros;
    }

    public void setNumeros(ArrayList<Double> numeros) {
        this.numeros = numeros;
    }
    
    
    
    public double calculateMean(ArrayList<Double> numberList)
    {
        double number=0;
        for(int i=0;i<numberList.size();i++)
        {
            number+=numberList.get(i);
        }
        number=number/numberList.size();
        return number;
    }
    public double calculateStandardDeviation(ArrayList<Double> numberList)
    {
        double number=calculateVariance(numberList);
        number=Math.sqrt(number);
        return number;
    }
    public double calculateVariance(ArrayList<Double> numberList)
    {
       double number=calculateMean(numberList);
       double var=0;
       for(int i=0;i<numberList.size();i++)
       {
           double range;
           
           range=Math.pow(numberList.get(i)-number,2);
           var = var+range;
       }
       var= var/numberList.size();
      
       return var;
    }
    public double calculateMode(ArrayList<Double> numberList)
    {
        double moda = numberList.get(0);
	double estado= numberList.get(0);
	int maximo = 0;
	for(int i=0;i<numberList.size();i++)
	{
		int cont=0;
		if(estado==numberList.get(i))
		{
			cont++;
		}else
		{
			if(cont>maximo)
			{
				maximo = cont;
				moda = numberList.get(i);
			}
			estado = numberList.get(i);
		}
	}
	return moda;
    }
    public void restart()
    {
    
    }
}