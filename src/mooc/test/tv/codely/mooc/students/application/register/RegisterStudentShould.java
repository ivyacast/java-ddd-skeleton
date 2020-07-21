package tv.codely.mooc.students.application.register;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.students.StudentModuleUnitTestCase;
import tv.codely.mooc.students.domain.Student;
import tv.codely.mooc.students.domain.StudentMother;

class RegisterStudentShould extends StudentModuleUnitTestCase {

    RegisterStudent register;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        register = new RegisterStudent(repository);
    }

    @Test
    void save_a_valid_student() {
        RegisterStudentRequest request = RegisterStudentRequestMother.random();

        Student student = StudentMother.fromRequest(request);

        register.register(request);

        shouldHaveSaved(student);
    }
}
