package files;

import java.io.Serializable;


public class Time implements Serializable {

    private static final long serialVersionUID = 1L;
    int year, month, day;
    int hour, minute;

    public Time(int y, int mo, int d, int h, int m)
    {
        year = y;
        month = mo;
        day = d;
        hour = h;
        minute = m;
    }
}
