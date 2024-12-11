package org.example.school;

public class GraduateStudent extends Student {
    // NOTE: this *recreates* a new static field with same name as Student.passStore
    //       rather than *overriding*, which Java doesn't allow.
    //       Every
    static int passScore = 70;

    int thesisScore;

    public GraduateStudent(String name, int englishScore, int mathScore, int thesisScore) {
        // NOTE: in case that without a explicit super constructor call,
        //       Java implicitly call super's no-args constructor (i.e. `super()`)
        super(name, englishScore, mathScore);
        this.thesisScore = thesisScore;
    }

    @Override
    public int averageScore() {
        return (englishScore + mathScore + thesisScore) / 3;
    }
}
