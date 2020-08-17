package com.burovytsky.parser;

import java.util.List;

/**
 * The interface Parse.
 */
public interface Parse {
    /**
     * Gets vacancies.
     *
     * @param link the link
     * @return the vacancies
     */
    List<Vacancy> getVacancies(String link);
}
