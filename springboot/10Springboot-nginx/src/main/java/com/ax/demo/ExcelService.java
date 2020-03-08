package com.ax.demo;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**`
 * 导出Excel
 */
@Service
public class ExcelService {

    public void exportExcel(HttpServletResponse response) throws Exception {
        HSSFWorkbook workbook = new HSSFWorkbook();
        /*表格内每页的名称*/
        HSSFSheet sheet = workbook.createSheet("碳排放月报表(纳入交易)");
        createTitle(workbook, sheet);
        HSSFRow row = sheet.createRow(2);
        row.setHeightInPoints(18);
        row.createCell(0).setCellValue("装机容量");
        row.createCell(1).setCellValue("MW");
        row.createCell(2).setCellValue("11");
        row.createCell(3).setCellValue("12");
        row.createCell(4).setCellValue("23");
        /*下载的文件名称*/
        String fileName = "导出excel例子.xls";

        //生成excel文件
        buildExcelFile(fileName, workbook);

        //浏览器下载excel
        buildExcelDocument(fileName, workbook, response);
    }

    //创建表头
    private void createTitle(HSSFWorkbook workbook, HSSFSheet sheet) {
        //合并单元格
        //参数1：起始行 参数2：终止行 参数3：起始列 参数4：终止列
        CellRangeAddress region1 = new CellRangeAddress(0, 1, 0, 0);
        sheet.addMergedRegion(region1);
        HSSFRow row = sheet.createRow(0);
        //设置行高
        row.setHeightInPoints(18);
        //设置列宽度
        sheet.setColumnWidth(0, 30 * 256);
        //设置为居中加粗
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        HSSFCell cell;
        cell = row.createCell(0);
        cell.setCellValue("指标名称");
        cell.setCellStyle(style);

        cell = row.createCell(1);
        cell.setCellValue("单位");
        cell.setCellStyle(style);

        cell = row.createCell(2);
        cell.setCellValue("本月实际");
        cell.setCellStyle(style);

        cell = row.createCell(5);
        cell.setCellValue("全厂小计");
        cell.setCellStyle(style);
    }

    //生成excel文件
    public void buildExcelFile(String filename, HSSFWorkbook workbook) throws Exception {

        FileOutputStream fos = new FileOutputStream(filename);
        workbook.write(fos);
        fos.flush();
        fos.close();
    }

    //浏览器下载excel
    public void buildExcelDocument(String fileName, HSSFWorkbook workbook, HttpServletResponse response) throws Exception {


        /*火狐浏览器乱码，用这个编解码*/
        fileName = new String(fileName.getBytes(), "ISO8859-1");

//        fileName = URLEncoder.encode(fileName, "UTF-8");

        response.reset();
        // ContentType 可以不设置
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);

        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }

}
