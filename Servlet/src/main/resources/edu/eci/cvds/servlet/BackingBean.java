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
    
    private ArrayList<Double> numberList= new ArrayList<Double>();
    private double moda;
    private double varianza;
    private double desStan;
    private double media;

    
    public BackingBean() {
        
    }

    public ArrayList<Double> getNumeros() {
        return numberList;
    }

    public void setNumeros(ArrayList<Double> numeros) {
        this.numberList = numeros;
    }

    public double getModa() {
        return moda;
    }

    public void setModa(double moda) {
        this.moda = moda;
    }

    public double getVarianza() {
        return varianza;
    }

    public void setVarianza(double varianza) {
        this.varianza = varianza;
    }

    public double getDesStan() {
        return desStan;
    }

    public void setDesStan(double desStan) {
        this.desStan = desStan;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public void stringToArray(String valores)
    {
        String[] valList = valores.split("; ");

        for(String val: valList)
        {
            numberList.add(Double.parseDouble(val));
        }
    }
    
    public void calcularTodo(String valores)
    {
        calculateMean(valores);
        calculateStandardDeviation(valores);
        calculateVariance(valores);
        calculateMode(valores);
    }
    
    public double calculateMean(String valores)
    {
        stringToArray(valores);
        media=0;
        for(int i=0;i<numberList.size();i++)
        {
            media+=numberList.get(i);
        }
        media=media/numberList.size();
        
        return media;

    }
    public void calculateStandardDeviation(String valores)
    {
        desStan=calculateVariance(valores);
        desStan=Math.sqrt(desStan);
    }
    public double calculateVariance(String valores)
    {
       double number=calculateMean(valores);
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
    public void calculateMode(String valores)
    {
        stringToArray(valores);
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
			if(cont>=maximo)
			{
				maximo = cont;
				moda = numberList.get(i);
			}
			estado = numberList.get(i);
		}
	}
    }
    public void restart()
    {
        numberList.clear();
        moda=0;
        varianza=0;
        desStan=0;
        media=0;
    }
}