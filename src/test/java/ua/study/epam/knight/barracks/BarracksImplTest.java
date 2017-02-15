package ua.study.epam.knight.barracks;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import ua.study.epam.knight.Knight;
import ua.study.epam.knight.gender.Gender;

import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

/**
 * Created by dima on 15.02.17.
 */
public class BarracksImplTest {
    Barracks barracks = BarracksImpl.instance();

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Test
    public void createKnightTest() throws Exception {
        /*Knight knight = barracks.createKnight(Gender.MALE);
        systemInMock.provideLines("Dmytro");

        assertEquals("Dmytro", knight.getName());*/

    }

}