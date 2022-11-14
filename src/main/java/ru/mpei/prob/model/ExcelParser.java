package ru.mpei.prob.model;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Map;

public class ExcelParser {

    public String findFixDay(String fileName, Map<String, LocalDate> fixedDays) throws InvalidFormatException, IOException {
        OPCPackage pkg = OPCPackage.open(new File(fileName));
        XSSFWorkbook wb = new XSSFWorkbook(pkg);

        XSSFSheet sheet = wb.getSheetAt(0);
        String mrid = fileName.split("\\.")[0];
        XSSFRow row;
        XSSFCell cell;

        int rows; // No of rows
        rows = sheet.getPhysicalNumberOfRows();

        int cols = 0; // No of columns
        int tmp = 0;

        // This trick ensures that we get the data properly even if it doesn't start from first few rows
        for (int i = 0; i < 10 || i < rows; i++) {
            row = sheet.getRow(i);
            if (row != null) {
                tmp = sheet.getRow(i).getPhysicalNumberOfCells();
                if (tmp > cols) cols = tmp;
            }
        }

        int dateColumn = 0;
        int repairColumn = 0;

        for (int rowNumber = 0; rowNumber < rows; rowNumber++) {
            String s;
            LocalDate fixedDay = null;
            for (int cellNumber = 0; cellNumber < cols; cellNumber++) {
                row = sheet.getRow(rowNumber);
                cell = row.getCell((short) cellNumber);
                if (cell != null) {
                    if (cell.toString().contains("Data")) {
                        dateColumn = cellNumber;
                    }
                    if (cell.toString().contains("Ремонт")) {
                        repairColumn = cellNumber;
                    }
                    if (cellNumber == dateColumn && rowNumber != 0) {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        s = sdf.format(cell.getDateCellValue());
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
                        fixedDay = LocalDate.parse(s, formatter);
                    } else if (cellNumber == repairColumn && rowNumber != 0) {
                        if (cell.toString().contains("1")) {
                            fixedDays.put(mrid, fixedDay);
                        }
                    }
                }
            }
        }
        return mrid;
    }

}
