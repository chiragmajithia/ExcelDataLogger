package dataset;

import java.io.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.*;

/**
 *
 * @author Chirag
 */
public class Workbook
{

    String file_path;
    XSSFWorkbook workbook;

    public boolean createWorkbook(String file_name)
    {
        this.file_path = file_name;
        try
        {
            XSSFWorkbook workbook = new XSSFWorkbook();
            FileOutputStream out = new FileOutputStream(new File(file_name));
            workbook.write(out);
            out.close();
            this.workbook = workbook;
            System.out.println("Creating new worksheet");
        }
        catch (Exception e)
        {
            System.out.println("Error in creating file");
            return false;
        }//write operation workbook using file out object 
        System.out.println(" creating " + this.file_path + ".xlsx workbook done successfully");
        System.out.println("//number of shhets " + Integer.toString(workbook.getNumberOfSheets()));
        return true;
    }

    public boolean createSheet(String sheet_name)
    {
        boolean s = false;
        int indx = workbook.getSheetIndex(sheet_name);
        if (indx >= 0)
        {
            Sheet sheet = workbook.getSheet(sheet_name);
            System.out.println("Sheet exists at Index" + Integer.toString(indx));
        }
        else
        {
            System.out.println("Sheet Not Found");
            Sheet sheet = workbook.createSheet(sheet_name);
            System.out.println("New Sheet Created with name" + sheet_name);
        }
        return s;
    }
    
    public Object readCell(int r,int c)
    {
        Object obj = null;
        FileInputStream fsIP = null;
        try
        {
            fsIP = new FileInputStream(new File(file_path)); //Read the spreadsheet that needs to be updated
        }
        catch (FileNotFoundException ex)
        {
            Logger.getLogger(Workbook.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        XSSFSheet sheet = workbook.getSheetAt(0);       // first sheet
        XSSFRow row     = sheet.getRow(0);        // third row
        XSSFCell cell   = row.getCell(0);  // fourth cell
        
        if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING)
        {
            obj = cell.getStringCellValue();
        }
        return obj;
    }

    public boolean openWorkbook(String file_path)
    {
        this.file_path = file_path;
        System.out.println("Opening " + file_path + "..");
        File file = new File(file_path);
        System.out.println("File Path:=" + file.getAbsolutePath());
        FileInputStream fIP;
        XSSFWorkbook workbook = null;
        try
        {
            fIP = new FileInputStream(file);
            workbook = new XSSFWorkbook(fIP);
            if (file.isFile() && file.exists())
            {
                System.out.println("file open successfully.");
                this.workbook = workbook;
            }
        }
        catch (IOException ex)
        {
            Logger.getLogger(Workbook.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public boolean appendDatabase()
    {
       
        FileInputStream fsIP = null;
        try
        {
            fsIP = new FileInputStream(new File(file_path)); //Read the spreadsheet that needs to be updated
        }
        catch (FileNotFoundException ex)
        {
            Logger.getLogger(Workbook.class.getName()).log(Level.SEVERE, null, ex);
        }

        XSSFSheet worksheet = workbook.getSheetAt(0);//Access the worksheet, so that we can update / modify it.
        System.out.println("Sheet Name: =" + workbook.getSheetName(0) + "Sheet data := " + Integer.toString(worksheet.getLastRowNum()));

        int r = worksheet.getLastRowNum();
        System.out.println("Creating row at" + Integer.toString(r + 1));
        Cell cell = null; // declare a Cell object
        Row row = worksheet.createRow(r + 1);
        cell = worksheet.getRow(r + 1).createCell(1);   // Access the second cell in second row to update the value

        cell.setCellValue("Append " + Integer.toString(r + 1));  // Get current cell value value and overwrite the value
        try
        {
            fsIP.close(); //Close the InputStream
        }
        catch (IOException ex)
        {
            Logger.getLogger(Workbook.class.getName()).log(Level.SEVERE, null, ex);
        }

        FileOutputStream fsOP;
        try
        {
            fsOP = new FileOutputStream(new File(file_path)); //Open FileOutputStream to write updates
            workbook.write(fsOP); //write changes
            fsOP.close();
        }
        catch (IOException ex)
        {
            Logger.getLogger(Workbook.class.getName()).log(Level.SEVERE, null, ex);
        }

        //close the stream  
        return true;
    }

    public void appendDatabase(List<Object> data)
    {
        System.out.println("Printing Objects");
        FileInputStream fsIP = null;
        try
        {
            fsIP = new FileInputStream(new File(file_path)); //Read the spreadsheet that needs to be updated
        }
        catch (FileNotFoundException ex)
        {
            Logger.getLogger(Workbook.class.getName()).log(Level.SEVERE, null, ex);
        }

        XSSFSheet worksheet = workbook.getSheetAt(0);//Access the worksheet, so that we can update / modify it.
        System.out.println("Sheet Name: =" + workbook.getSheetName(0) + "Sheet data := " + Integer.toString(worksheet.getLastRowNum()));

        int r = worksheet.getLastRowNum();
        XSSFRow row = worksheet.createRow(r + 1);
        System.out.println("Creating row at" + Integer.toString(r + 1));
        int cnt = 0;
        System.out.println("Length of data := " + data.size());
        for (Object o : data)
        {
            Cell cell = row.createCell(cnt++);
            cell.setCellValue(o.toString());
            System.out.println(o.toString());
        }
        System.out.println("Priting Done");
        try
        {
            fsIP.close(); //Close the InputStream
        }
        catch (IOException ex)
        {
            Logger.getLogger(Workbook.class.getName()).log(Level.SEVERE, null, ex);
        }

        FileOutputStream fsOP;
        try
        {
            fsOP = new FileOutputStream(new File(file_path)); //Open FileOutputStream to write updates
            workbook.write(fsOP); //write changes
            fsOP.close();
        }
        catch (IOException ex)
        {
            Logger.getLogger(Workbook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addHeadings(String type, List<String[]> headings)
    {
        System.out.println("Printing Objects");
        FileInputStream fsIP = null;
        try
        {
            fsIP = new FileInputStream(new File(file_path)); //Read the spreadsheet that needs to be updated
        }
        catch (FileNotFoundException ex)
        {
            Logger.getLogger(Workbook.class.getName()).log(Level.SEVERE, null, ex);
        }

        XSSFSheet worksheet = workbook.getSheetAt(0);//Access the worksheet, so that we can update / modify it.
        System.out.println("Sheet Name: =" + workbook.getSheetName(0) + "Sheet data := " + Integer.toString(worksheet.getLastRowNum()));

        int r = 0;
        XSSFRow row = worksheet.createRow(r);
        System.out.println("Creating row at" + Integer.toString(r));
        Cell cell = row.createCell(0);
        row = worksheet.createRow(r + 1);
        cell.setCellValue(type);
        int cnt = 0;
        for (String[] o : headings)
        {
            for (String s : o)
            {
                cell = row.createCell(cnt++);
                cell.setCellValue(s);
                System.out.println(s);
            }
        }
        System.out.println("Priting Done");
        try
        {
            fsIP.close(); //Close the InputStream
        }
        catch (IOException ex)
        {
            Logger.getLogger(Workbook.class.getName()).log(Level.SEVERE, null, ex);
        }

        FileOutputStream fsOP;
        try
        {
            fsOP = new FileOutputStream(new File(file_path)); //Open FileOutputStream to write updates
            workbook.write(fsOP); //write changes
            fsOP.close();
        }
        catch (IOException ex)
        {
            Logger.getLogger(Workbook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
