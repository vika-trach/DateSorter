package org.example;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DateSorter {
    /**
     * The implementation of this method should sort dates.
     * The output should be in the following order:
     * Dates with an 'r' in the month,
     * sorted ascending (first to last),
     * then dates without an 'r' in the month,
     * sorted descending (last to first).
     * For example, October dates would come before May dates,
     * because October has an 'r' in it.
     * thus: (2004-07-01, 2005-01-02, 2007-01-01, 2032-05-03)
     * would sort to
     * (2005-01-02, 2007-01-01, 2032-05-03, 2004-07-01)
     *
     * @param unsortedDates - an unsorted list of dates
     * @return the collection of dates now sorted as per the spec
     */

    private final String sortParameter;

    public DateSorter(String sortParameter) {
        this.sortParameter = sortParameter;
    }

    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        if(unsortedDates == null || unsortedDates.contains(null)){
            throw new IllegalArgumentException("///");
        }
        Collection<LocalDate> monthWithSortParam = unsortedDates.stream()
                .filter(date -> isContainsSortParameter(date.getMonth()))
                .sorted()
                .collect(Collectors.toList());

        Collection<LocalDate> monthWithoutSortParam = unsortedDates.stream()
                .filter(date -> !isContainsSortParameter(date.getMonth()))
                .sorted(Comparator.reverseOrder())
                .toList();

        monthWithSortParam.addAll(monthWithoutSortParam);

        return monthWithSortParam;
    }

    public boolean isContainsSortParameter(Month month){
        return month.toString().toLowerCase().contains(sortParameter.toLowerCase());
    }
}