package com.shawn.html2pdf;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupUtils {

    /**
     * 使用背景：由于itextPdf5对于html元素进行严格校验，所以tag必须close,所以需要调用这里的函数把html严格转换成xhtml<br>
     * @param htmlText
     * @return
     */
    public static String clearHtmlToXhtml(String htmlText)
    {
        org.jsoup.nodes.Document doc = Jsoup.parse(htmlText);
        doc.outputSettings().syntax( Document.OutputSettings.Syntax.xml);
        //doc.select("a").unwrap();
        String xhtmlTex = doc.html();
        return xhtmlTex;
    }
}
