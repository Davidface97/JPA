package com.crunchify.jsp.servlet;

import edu.co.sergio.mundo.dao.ServiciosDAO;
import java.awt.Color;
import java.awt.Paint;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.TextAnchor;

public class BarServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("image/png");
        OutputStream outputStream = response.getOutputStream();
        JFreeChart chart = getChart();
        int width = 500;
        int height = 350;
        ChartUtilities.writeChartAsPNG(outputStream, chart, width, height);


    }

    public JFreeChart getChart() {

            ServiciosDAO dao= new ServiciosDAO();
            ArrayList Result= new ArrayList();
            Result=dao.EspacioDisp();
            
            int x= (Integer)Result.get(0);
            int x2= (Integer)Result.get(1);
            
        
        DefaultPieDataset dataset = new DefaultPieDataset();
        //Crear la capa de servicios que se enlace con el DAO
        dataset.setValue("Espacio Disponible = "+ Integer.toString(x2), x2);
        dataset.setValue("Espacio Ocupado = "+ Integer.toString(x), x);
        //dataset.setValue("Yugo", 44.2);
        
        boolean textoinferior = true;
        boolean tool = true;
        boolean urls = false;
        
        JFreeChart chart = ChartFactory.createPieChart("Espacio en Bodega", dataset, textoinferior, tool, urls);
        
        
        return chart;
    }

}