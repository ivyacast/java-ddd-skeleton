package tv.codely.mooc.students.domain;

import tv.codely.shared.domain.student.RegisteredStudentDomainEvent;

public class RegisteredStudentDomainEventMother {
    public static RegisteredStudentDomainEvent create(
        StudentId id,
        StudentName name,
        StudentSurName surName,
        StudentEmail email){
        return new RegisteredStudentDomainEvent(id.value(), name.value(), surName.value(), email.value());
    }

    public static RegisteredStudentDomainEvent fromStudent(Student student){
        return create(student.id(), student.name(), student.surname(), student.email());
    }

    public static RegisteredStudentDomainEvent random(){
        return create(
            StudentIdMother.random(),
            StudentNameMother.random(),
            StudentSurNameMother.random(),
            StudentEmailMother.random()
        );
    }
}
