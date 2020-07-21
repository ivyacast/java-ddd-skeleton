package tv.codely.mooc.students.infrastructure;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.students.StudentModuleInfrastructureTestCase;
import tv.codely.mooc.students.domain.Student;
import tv.codely.mooc.students.domain.StudentIdMother;
import tv.codely.mooc.students.domain.StudentMother;

import java.util.Optional;

class InMemoryStudentRepositoryShould extends StudentModuleInfrastructureTestCase {
    @Test
    void save_a_valid_student() {
        Student student = StudentMother.random();
        repository.save(student);
    }

    @Test
    void search_an_existing_student() {
        Student student = StudentMother.random();

        repository.save(student);

        Assert.assertEquals(Optional.of(student), repository.search(student.id()));
    }

    @Test
    void not_find_a_non_existing_student() {
        Assert.assertFalse(repository.search(StudentIdMother.random()).isPresent());
    }
}
