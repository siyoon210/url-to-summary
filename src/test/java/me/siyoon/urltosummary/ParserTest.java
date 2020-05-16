package me.siyoon.urltosummary;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.opengraph.MetaElement;
import org.opengraph.OpenGraph;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ParserTest {
    private final static String URL = "https://sports.news.naver.com/news.nhn?oid=001";

    @Test
    public void jsoupTest() throws IOException {
        final Document document = Jsoup.connect(URL).get();
        final Elements metaElements = document.head().select("meta");
        final List<String> property = metaElements.eachAttr("property");
        System.out.println("property = " + property.toString());
    }

    @Test
    public void ogTest() throws Exception {
        OpenGraph testPage = new OpenGraph(URL, true);

        String title = testPage.getContent("title");
        System.out.println("title = " + title);
        String type = testPage.getContent("type");
        System.out.println("type = " + type);
        System.out.println("testPage.getBaseType() = " + testPage.getBaseType());
        System.out.println("testPage.getProperties() = " + Arrays.toString(testPage.getProperties()));
        final MetaElement[] titles = testPage.getProperties("title");
        for (MetaElement metaElement : titles) {
            System.out.println("metaElement = " + metaElement);
        }
    }
}
