package com.gdut.springdemo.crawler;

import com.google.gson.*;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by Jun on 2016/10/10.
 */
public class MyCrawler extends WebCrawler{

    private final static Pattern FILTERS = Pattern
            .compile(".*(\\.(css|js|bmp|gif|jpe?g|ico"
                      + "|png|tiff?|mid|mp2|mp3|mp4"
                      + "|wav|avi|mov|mpeg|ram|m4v|pdf"
                      + "|rm|smil|wmv|swf|wma|zip|rar|gz))$");

    private final static String URL_PREFIX = "https://item.jd.com";


    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        String href = url.getURL().toLowerCase();
        //不符合FILTERS的要求 且 以URL_PREFIX开头
        return !FILTERS.matcher(href).matches()
                && href.startsWith(URL_PREFIX);
    }

    @Override
    public void visit(Page page) {
        String url = page.getWebURL().getURL();
        System.out.println("URL: " + url);
        //https://item.jd.com/932299.html

        if (page.getParseData() instanceof HtmlParseData) {
            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
            String html = htmlParseData.getHtml();
            Document doc = Jsoup.parse(html, "UTF-8");

            //爬商品名
            String name = doc.select("div#name").text();

            String[] itemID = url.split("/|\\.html");
            String priceUrl = "http://p.3.cn/prices/mgets?skuIds=J_" + itemID[3] + ",J_&type=1";
            String priceJson = null;
            try {
                //忽略请求类型，返回的是json数据    用get请求返回的是html中包含json
                priceJson = Jsoup.connect(priceUrl)
                        .header("Accept", "*/*")
                        .header("Accept-Encoding", "gzip, deflate")
                        .header("Accept-Language","zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
                        .header("Content-Type", "application/json;charset=UTF-8")
                        .header("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:48.0) Gecko/20100101 Firefox/48.0")
                        .timeout(10000)
                        .ignoreContentType(true).execute().body();

            } catch (IOException e) {
                e.printStackTrace();
            }

            Gson gson = new Gson();
            List<Map<String,String>> jsonList = gson.fromJson(priceJson, List.class);
            Map<String,String> map = jsonList.get(0);
            String price = map.get("p");

            System.out.println("商品名：" + name);
            System.out.println("价格 ：" + price);
        }
    }
}
