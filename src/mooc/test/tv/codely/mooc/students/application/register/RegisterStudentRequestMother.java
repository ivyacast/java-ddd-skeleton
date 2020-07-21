package tv.codely.mooc.students.application.register;

import tv.codely.mooc.students.domain.*;

public final class RegisterStudentRequestMother {
    public static RegisterStudentRequest create(StudentId id, StudentName name, StudentSurName surName, StudentEmail email) {
        return new RegisterStudentRequest(id.value(), name.value(), surName.value(), email.value());
    }

    public static RegisterStudentRequest random() {
        return create(
            StudentIdMother.random(),
            StudentNameMother.random(),
            StudentSurNameMother.random(),
            StudentEmailMother.random()
        );
    }
}
