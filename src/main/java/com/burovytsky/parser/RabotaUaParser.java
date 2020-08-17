package com.burovytsky.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Constantine Burovytsky
 * @version 1
 * Class finds all vacancies for java developer.
 */
public class RabotaUaParser implements Parse {
    private final ArrayList<Vacancy> result = new ArrayList<>();

    /**
     * Gets vacancies.
     *
     * @param link link to java jobs page
     * @return the vacancies list
     */
    @Override
    public List<Vacancy> getVacancies(String link) {
        try {
            Document doc = Jsoup.connect(link).get();
            Elements cards = doc.select(".card-title");
            String vacancyLink;
            for (Element element : cards) {
                vacancyLink = element.child(0).attr("href");
                Vacancy vacancy = getVacancyDetail(vacancyLink);
                if (!vacancy.getName().contains("Middle")) {
                    result.add(vacancy);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Gets list.
     *
     * @return the list
     */
    public List<Vacancy> getList() {
        return result;
    }
    /**
     * Gets vacancy.
     *
     * @return vacancy with details
     */
    private Vacancy getVacancyDetail(String link) {
        StringBuilder fullLink = new StringBuilder();
        fullLink.append("https://rabota.ua").append(link);
        Document doc = null;
        try {
            doc = Jsoup.connect(fullLink.toString()).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert doc != null;
        String name = doc.select(".vacancy-ssr-title").text();
        String stringDate = doc.select(".vacancy-ssr-info").get(0).child(2).text();
        LocalDateTime date = new RabotaUaDateConverter().formatDate(stringDate);
        return new Vacancy(name, fullLink.toString(), date);
    }
}
