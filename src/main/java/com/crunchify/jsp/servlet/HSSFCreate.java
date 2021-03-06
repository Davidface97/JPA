package com.crunchify.jsp.servlet;

import edu.co.sergio.mundo.dao.ServiciosDAO;
import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.formula.FormulaParseException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellRangeAddress;

public class HSSFCreate extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void destroy() {
    }

    /**
     * Processes requests for both HTTP GET and POST methods.
     *
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        ServiciosDAO dao = new ServiciosDAO();
        response.setContentType("application/vnd.ms-excel");
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("new sheet");
        ArrayList Users = new ArrayList();
        Users = dao.ArrayUsers();
        ArrayList Lotes = new ArrayList();
        Lotes = dao.ArrayLotes();
        ArrayList Prod = new ArrayList();
        Prod = dao.ArrayProd();
        int celda = 0;
        String cadena = "";
        int cellindex = 0;                
      
        Map<String, Object[]> data = new HashMap<String, Object[]>();
        data.put("1", new Object[]{"", "", "Usuarios", "", ""});
        data.put("2", new Object[]{"", "ID", "", "Nombre", ""});
        celda = 3;
        cadena = Integer.toString(celda);
        for (int i = 0; i < Users.size(); i++) {
            data.put(cadena, new Object[]{"", Users.get(i), "", Users.get(i), ""});
            celda++;
            cadena= Integer.toString(celda);
        }
        celda = celda + 1;
        cadena = Integer.toString(celda);
        data.put(cadena, new Object[]{"", "", "Lotes", "", ""});
        celda = celda + 1;
        cadena = Integer.toString(celda);
        data.put(cadena, new Object[]{"", "ID", "", "Nom. Lote", ""});

        celda = celda + 1;
        cadena= Integer.toString(celda);
        for (int x = 0; x < Lotes.size(); x++) {
            data.put(cadena, new Object[]{"", Lotes.get(x), "", Lotes.get(x), ""});
            celda++;
            cadena= Integer.toString(celda);
        }

        celda = celda + 1;
        cadena= Integer.toString(celda);
        data.put(cadena, new Object[]{"", "", "Productos", "", ""});
        celda = celda + 1;
        cadena= Integer.toString(celda);
        data.put(cadena, new Object[]{"", "ID", "Cant.", "Nom. Lote", ""});
        celda = celda + 1;
        cadena= Integer.toString(celda);
        for (int y = 0; y < Lotes.size(); y++) {
            data.put(cadena, new Object[]{"", Users.get(y), "", Users.get(y), "", "", "", "", "", "", "", "", "", ""});
            celda++;
            cadena= Integer.toString(celda);
        }

        data.put("4", new Object[]{3d, "Dean", 700000d});
        
        
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset) {
            Row row = sheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof Date) {
                    cell.setCellValue((Date) obj);
                } else if (obj instanceof Boolean) {
                    cell.setCellValue((Boolean) obj);
                } else if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                } else if (obj instanceof Double) {
                    cell.setCellValue((Double) obj);
                }
            }
        }

        // Write the output 
        OutputStream out = response.getOutputStream();
        wb.write(out);
        out.close();
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP POST method.
     *
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Example to create a workbook in a servlet using HSSF";
    }
}
