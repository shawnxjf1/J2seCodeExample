package com.person.excel;

import com.sun.rowset.internal.Row;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @描述:
 * @版权: Copyright (c) 2016-2018
 * @公司: lumi
 * @作者: 徐建峰
 * @创建日期: 2018-06
 * @创建时间: 20 下午4:27
 */
public class ExcelUtils {

    public static Map importExcel(MultipartFile importFile) {
        InputStream inputStream = null;
        HashMap<String, Object> resultMap = new HashMap<>(3);
        try {
            if (importFile == null) {
                resultMap.put("totalCountMsg", "导入文件为空,请检查!");
                return resultMap;
            }
            inputStream = importFile.getInputStream();
            //根据版本选择创建Workbook的方式
            Workbook wb = null;
            //根据文件名判断文件是2003版本还是2007版本
            if (importFile.getOriginalFilename().matches("^.+\\.(?i)(xlsx)$")) {
                wb = new XSSFWorkbook(inputStream);
            } else {
                wb = new HSSFWorkbook(inputStream);
            }
            return readExcelValue(wb);
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("totalCountMsg", "服务器繁忙！");
            return resultMap;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Map readExcelValue(Workbook wb) {
        HashMap<String, Object> resultMsgMap = new HashMap<>(4);
        List dataList = new ArrayList<ProviderCustomer>();
        StringBuffer totalImportMsg = new StringBuffer();
        Sheet sheet = wb.getSheetAt(0);
        int totalRows = sheet.getPhysicalNumberOfRows();
        //得到Excel的列数(前提是有行数)
        if (totalRows >= 2) {
            ////

            resultMsgMap.put("rowMsg", totalImportMsg.toString());
            resultMsgMap.put("totalCountMsg", "此次excel读取总行数" + (totalRows - 1) + ",有效识别" + dataList.size() + "条,");
            resultMsgMap.put("data", dataList);
        } else {
            resultMsgMap.put("totalCountMsg", "导入文件没有数据行,请检查!");
        }
        return resultMsgMap;
    }

    /**
     * 通用excel导出方法
     *
     * @param exportFileName    导出文件名
     * @param headerNameList    导出表头名集合
     * @param headerColumnsList 导出头对应的列名集合
     * @param dtoList           数据对象集合
     * @param dtoClass          数据类字节码
     * @param response
     */
    public static void exportExcel(String exportFileName, List<String> headerNameList, List<String> headerColumnsList,
                                   List dtoList, Class dtoClass, HttpServletResponse response) {
        OutputStream outputStream = null;
        try {
            // 声明一个工作薄以及工作表
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet sheet = wb.createSheet(exportFileName);
            sheet.setDefaultColumnWidth((short) 15);
            //表头--标题栏,并设置一个头样式
            HSSFRow headerRow = sheet.createRow(0);
            for (int i = 0; i < headerNameList.size(); i++) {
                headerRow.createCell(i).setCellValue(headerNameList.get(i));
            }
            HSSFCellStyle style = wb.createCellStyle();
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
            headerRow.setRowStyle(style);
            //根据列集合获取字段集合
            List<Field> fieldList = new ArrayList<>(headerColumnsList.size());
            headerColumnsList.forEach(column -> {
                addField(dtoClass, fieldList, column);
            });
            //填充数据行
            int dataSize = dtoList.size();
            if (dataSize > 0) {
                try {
                    for (int rowNum = 0; rowNum < dataSize; rowNum++) {
                        HSSFRow dataRow = sheet.createRow(rowNum + 1);
                        Object singleDto = dtoList.get(rowNum);
                        for (int columnNum = 0; columnNum < fieldList.size(); columnNum++) {
                            Object columnData = fieldList.get(columnNum).get(singleDto);
                            dataRow.createCell(columnNum).setCellValue(String.valueOf(columnData));
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            //设置响应内容并返回流
            outputStream = response.getOutputStream();
            response.reset();
            response.setHeader("Content-Disposition", "attachment;filename=" + new String(exportFileName.getBytes("gbk"), "iso8859-1") + ".xls");
            response.setContentType("application/msexcel; charset=UTF-8");
            wb.write(outputStream);
            wb.close();
            log.info(exportFileName + "导出成功!");
        } catch (Exception e) {
            log.error(exportFileName + "导出失败!");
            exportWarnMsg(response, "导出失败!");
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
