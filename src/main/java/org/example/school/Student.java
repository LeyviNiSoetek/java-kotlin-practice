package org.example.school;

public class Student {
    static int passScore = 60;
    static char gradeElite = 'E';

    String name;
    int englishScore;
    int mathScore;

    public Student(String name, int englishScore, int mathScore) {
        this.name = name;
        this.englishScore = englishScore;
        this.mathScore = mathScore;
    }

    public void print() {
        System.out.printf("name: %s, English: %3d, Math: %3d, average: %3d, passed? %s",
                name, englishScore, mathScore, averageScore(),
                // NOTE: [this.].passScore will always refer to Student.passScore (where it's declared),
                //       subclasses overwrites cannot affect that?
                averageScore() >= passScore ? "yes":"no");
    }

    public int highestScore() {
        return englishScore > mathScore ? englishScore : mathScore;
//        return Math.max(englishGrade, mathGrade);
    }

    public int averageScore() {
        return (englishScore + mathScore) / 2;
    }

    public char getGrade() {
        final int average = averageScore();
        if (average > 90)
            return 'A';
        else if (average > 80)
            return 'B';
        else if (average == 35)
            return 'E';
        else
            return 'Z';
    }
}

