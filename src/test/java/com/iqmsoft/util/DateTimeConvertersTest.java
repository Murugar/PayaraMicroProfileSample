package com.iqmsoft.util;

import org.junit.Test;
import static org.junit.Assert.*;
import static com.iqmsoft.util.DateTimeConverters.*;
import static org.hamcrest.CoreMatchers.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;

public class DateTimeConvertersTest {

    @Test
    public void LocalDate1() {
        assertThat(str2LocalDate("2017/01/02"), is(LocalDate.of(2017, 1, 2)));
    }
    @Test(expected = DateTimeParseException.class)
    public void LocaDate2(){
        assertThat(str2LocalDate("2017/1/2"), is(LocalDate.of(2017, 1, 2)));
    }

    @Test
    public void LocalDate3() {
        assertThat(str2LocalDate("2017/1/2", DateTimeFormatter.ofPattern("yyyy/M/d")), is(LocalDate.of(2017, 1, 2)));
    }

    @Test
    public void LocalDate4() {
        assertThat(localDate2str(LocalDate.of(2017, 1, 2)), is("2017/01/02"));
    }

    @Test
    public void localDate() {
        assertThat(localDate2str(LocalDate.of(2017, 1, 2), DateTimeFormatter.ofPattern("yyyy/M/d")), is("2017/1/2"));
    }

    @Test
    public void localDatesqlDate() {
        Calendar cal = Calendar.getInstance();
        cal.set(2017, 0, 2, 0, 0, 0);
        cal.set(Calendar.MILLISECOND, 0);
        java.sql.Date sqlDate = new java.sql.Date(cal.getTimeInMillis());

        assertThat(localDate2SqlDate(LocalDate.of(2017, 1, 2)), is(sqlDate));
    }

    @Test
    public void sqlDate2() {
        Calendar cal = Calendar.getInstance();
        cal.set(2017, 0, 2, 0, 0, 0);
        cal.set(Calendar.MILLISECOND, 0);
        java.sql.Date sqlDate = new java.sql.Date(cal.getTimeInMillis());

        assertThat(sqlDate2localDate(sqlDate), is(LocalDate.of(2017, 1, 2)));
    }
    
}
