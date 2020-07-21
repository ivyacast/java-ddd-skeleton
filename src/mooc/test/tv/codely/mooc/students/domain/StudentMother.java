package tv.codely.mooc.students.domain;

import tv.codely.mooc.students.application.register.RegisterStudentRequest;

public class StudentMother {
    public static Student create(StudentId id, StudentName name, StudentSurName surName, StudentEmail email) {
        return new Student(id, name, surName, email);
    }

    public static Student fromRequest(RegisterStudentRequest request) {
        return create(
            StudentIdMother.create(request.id()),
            StudentNameMother.create(request.name()),
            StudentSurNameMother.create(request.surname()),
            StudentEmailMother.create(request.email())
        );
    }

    public static Student random() {
        return create(
            StudentIdMother.random(),
            StudentNameMother.random(),
            StudentSurNameMother.random(),
            StudentEmailMother.random()
        );
    }
}
