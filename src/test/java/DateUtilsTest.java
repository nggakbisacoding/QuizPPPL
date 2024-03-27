import org.example.DateUtils;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DateUtilsTest {
    public ArrayList<DateUtils> dates;

    @BeforeAll
    public void initialization() {
        dates = new ArrayList<>();
    }

    @BeforeEach
    public void init() {
        DateUtils d1 = new DateUtils();
        dates.add(d1);
    }

    @Test
    @Order(1)
    public void isLeapYearTest() {
        Assertions.assertTrue(dates.getFirst().isLeapYear(2024));
        Assertions.assertFalse(dates.getFirst().isLeapYear(2003));
    }

    @Test
    @Order(2)
    public void getDaysInMonthTest() {
        Assertions.assertEquals(dates.getFirst().getDaysInMonth(2003, 2), 28);
        Assertions.assertEquals(dates.getFirst().getDaysInMonth(2024, 2), 29);
    }

    @Test
    @Order(3)
    public void isLapYearandgetDaysInMonthTest() {
        Assertions.assertEquals(dates.getFirst().getDaysInMonth(2004,2), 29);
        Assertions.assertEquals(dates.getFirst().getDaysInMonth(2004,1), 31);
    }

    @AfterEach
    public void clean() {
        dates.clear();
    }
}
