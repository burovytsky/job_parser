package com.burovytsky.parser;

import java.time.LocalDateTime;
import java.util.Objects;


/**
 * @author Constantine Burovytsky
 * @version 1
 * Vacancy model.
 */
public class Vacancy {

    private String name;
    private String link;
    private LocalDateTime date;

    /**
     * Instantiates a new Vacancy.
     *
     * @param name the name
     * @param link the link
     * @param date the date
     */
    public Vacancy(String name, String link, LocalDateTime date) {
        this.name = name;
        this.link = link;
        this.date = date;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets link.
     *
     * @return the link
     */
    public String getLink() {
        return link;
    }

    /**
     * Sets link.
     *
     * @param link the link
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vacancy vacancy = (Vacancy) o;
        return Objects.equals(name, vacancy.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, link, date);
    }

    @Override
    public String toString() {
        return "Vacancy{" +
                "name='" + name + '\'' +
                ", link='" + link + '\'' +
                ", date=" + date +
                '}';
    }
}
