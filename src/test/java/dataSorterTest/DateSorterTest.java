package dataSorterTest;

import org.example.DateSorter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DateSorterTest {
    private DateSorter dateSorter;
    private List<LocalDate> simpleListToSort;
    private List<LocalDate> simpleSortedList;
    private List<LocalDate> complexListToSort;
    private List<LocalDate> complexSortedList;

    @BeforeEach
    void setUp() {
        dateSorter = new DateSorter("r");

        simpleListToSort = Arrays.asList(
                LocalDate.of(2005, 6, 7),
                LocalDate.of(2003, 6, 21),
                LocalDate.of(2008, 12, 3),
                LocalDate.of(2005, 1, 3)
        );

        simpleSortedList = Arrays.asList(
                LocalDate.of(2005, 1, 3),
                LocalDate.of(2008, 12, 3),
                LocalDate.of(2005, 6, 7),
                LocalDate.of(2003, 6, 21)
        );

        complexListToSort = Arrays.asList(
                LocalDate.of(2024, Month.JANUARY, 2),
                LocalDate.of(2023, Month.SEPTEMBER, 15),
                LocalDate.of(2003, Month.APRIL, 10),
                LocalDate.of(2023, Month.DECEMBER, 5),
                LocalDate.of(2023, Month.MAY, 1),
                LocalDate.of(2003, Month.JANUARY, 25),
                LocalDate.of(2023, Month.AUGUST, 20),
                LocalDate.of(2014, Month.MAY, 11)
        );

        complexSortedList = Arrays.asList(
                LocalDate.of(2003, Month.JANUARY, 25),
                LocalDate.of(2003, Month.APRIL, 10),
                LocalDate.of(2023, Month.SEPTEMBER, 15),
                LocalDate.of(2023, Month.DECEMBER, 5),
                LocalDate.of(2024, Month.JANUARY, 2),
                LocalDate.of(2023, Month.AUGUST, 20),
                LocalDate.of(2023, Month.MAY, 1),
                LocalDate.of(2014, Month.MAY, 11)
        );
    }

    @Test
    void sortDates_SimpleData_Ok() {
        List<LocalDate> actual = (List<LocalDate>) dateSorter.sortDates(simpleListToSort);
        assertEquals(simpleSortedList, actual);
    }

    @Test
    void sortDates_DatesWithNull_NotOk() {
        List<LocalDate> datesWithNull = new ArrayList<>(simpleListToSort);
        datesWithNull.add(null);
        assertThrows(IllegalArgumentException.class, () -> dateSorter.sortDates(datesWithNull));
    }

    @Test
    void sortDates_ComplexData_Ok() {
        List<LocalDate> actual = (List<LocalDate>) dateSorter.sortDates(complexListToSort);
        assertEquals(complexSortedList, actual);
    }

    @Test
    void sortDates_NullInput_NotOk() {
        assertThrows(IllegalArgumentException.class, () -> dateSorter.sortDates(null));
    }

    @Test
    void sortEmptyList() {
        List<LocalDate> result = (List<LocalDate>) dateSorter.sortDates(new ArrayList<>());
        assertTrue(result.isEmpty());
    }
}