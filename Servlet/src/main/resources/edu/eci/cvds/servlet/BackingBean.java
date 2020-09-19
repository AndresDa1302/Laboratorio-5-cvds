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
    public double moda;
    public double varianza;
    public double desStan;
    public double media;
  
    public BackingBean() {
        
    }

    public ArrayList<Double> getNumeros() {
        return numeros;
    }

    public void setNumeros(ArrayList<Double> numeros) {
        this.numeros = numeros;
    }

    public Double getModa() {
        return moda;
    }

    public void setModa(Double moda) {
        this.moda = moda;
    }

    public Double getVarianza() {
        return varianza;
    }

    public void setVarianza(Double varianza) {
        this.varianza = varianza;
    }

    public Double getDesStan() {
        return desStan;
    }

    public void setDesStan(Double desStan) {
        this.desStan = desStan;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }
    
    public double calculateMean(ArrayList<Double> numberList)
    {
        media=0;
        for(int i=0;i<numberList.size();i++)
        {
            media+=numberList.get(i);
        }
        media=media/numberList.size();
        return media;
    }
    public double calculateStandardDeviation(ArrayList<Double> numberList)
    {
        desStan=calculateVariance(numberList);
        desStan=Math.sqrt(desStan);
        return desStan;
    }
    public double calculateVariance(ArrayList<Double> numberList)
    {
       double number=calculateMean(numberList);
       varianza=0;
       for(int i=0;i<numberList.size();i++)
       {
           double range;
           
           range=Math.pow(numberList.get(i)-number,2);
           varianza = varianza+range;
       }
       varianza= varianza/numberList.size();
      
       return varianza;
    }
    public double calculateMode(ArrayList<Double> numberList)
    {
        moda = numberList.get(0);
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