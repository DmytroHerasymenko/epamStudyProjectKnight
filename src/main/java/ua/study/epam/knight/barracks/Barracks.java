package ua.study.epam.knight.barracks;

import ua.study.epam.knight.Knight;
import ua.study.epam.knight.gender.Gender;

/**
 * Created by dima on 14.02.17.
 */
public interface Barracks {
    Knight createKnight(Gender gender, String name);
}
