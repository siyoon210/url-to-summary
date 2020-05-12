package me.siyoon.urltosummary;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class JsoupTest {
    private final static String URL = "https://sports.news.naver.com/news.nhn?oid=001";

    @Test
    public void test() throws IOException {
        final Document document = Jsoup.connect(URL).get();
        final Elements metaElements = document.head().select("meta");
        final List<String> property = metaElements.eachAttr("property");
    }
}
