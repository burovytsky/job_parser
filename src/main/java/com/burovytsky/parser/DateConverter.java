package com.burovytsky.parser;

import java.time.LocalDateTime;

/**
 * The interface Date converter.
 */
interface DateConverter {
    /**
     * Format date local date time.
     *
     * @param date the date
     * @return the local date time
     */
    LocalDateTime formatDate(String date);
}
