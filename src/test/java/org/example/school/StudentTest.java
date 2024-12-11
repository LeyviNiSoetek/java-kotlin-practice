package org.example.school;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StudentTest {
    @Test
    public void testHighestScore() {
        Student student = new Student("Name", 40, 80);
        Assertions.assertEquals(80, student.highestScore());
    }

    @Test
    public void testAverage() {
        Student student = new Student("Name", 40, 80);
        Assertions.assertEquals(60, student.averageScore());
    }
}
