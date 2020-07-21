package tv.codely.mooc.students.domain;

import tv.codely.shared.domain.WordMother;

public final class StudentSurNameMother {
    public static StudentSurName create(String value) {
        return new StudentSurName(value);
    }

    public static StudentSurName random() {
        return create(WordMother.random());
    }
}
