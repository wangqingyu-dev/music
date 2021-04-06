package com.example.demo.common.excel;

import com.example.demo.domain.Singer;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author wqy
 */
public class SingExcel {
    public static void exportCompanyExcel(List<Singer> singerList, HttpServletResponse response) {
        try {
            HSSFWorkbook wb = new HSSFWorkbook();

            HSSFSheet sheet = wb.createSheet("歌手信息列表");

            HSSFRow row = null;

            row = sheet.createRow(0);
            row.setHeight((short) (30 * 20));
            row.createCell(0).setCellValue("歌手信息列表");


            CellRangeAddress rowRegion = new CellRangeAddress(0, 0, 0, 2);
            sheet.addMergedRegion(rowRegion);
            row = sheet.createRow(1);
            row.setHeight((short) (22.50 * 20));//设置行高
            row.createCell(0).setCellValue("Id");//为第一个单元格设值
            row.createCell(1).setCellValue("男");//为第二个单元格设值
            row.createCell(2).setCellValue("名称");//为第三个单元格设值
            row.createCell(3).setCellValue("生日");
            row.createCell(4).setCellValue("简介");
            row.createCell(5).setCellValue("国家/地区");

            for (int i = 0; i < singerList.size(); i++) {
                row = sheet.createRow(i + 2);
                Singer company = singerList.get(i);
                row.createCell(0).setCellValue(company.getId());
                row.createCell(1).setCellValue(company.getSex());
                row.createCell(2).setCellValue(company.getName());
                row.createCell(3).setCellValue(company.getBirth());
                row.createCell(4).setCellValue(company.getIntroduction());
                row.createCell(5).setCellValue(company.getLocation());
            }
            sheet.setDefaultRowHeight((short) (16.5 * 20));
            //列宽自适应
            for (int i = 0; i <= 13; i++) {
                sheet.autoSizeColumn(i);
            }
            String title= "singer";
            String  fileName = new String(title.getBytes("GB2312"), "ISO_8859_1");
            fileName = URLEncoder.encode(fileName,"utf-8");

            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            OutputStream os = response.getOutputStream();
            response.setHeader("Content-disposition", "attachment;filename="+fileName+".xls");//默认Excel名称
            wb.write(os);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
