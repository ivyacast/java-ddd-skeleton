package tv.codely.mooc.students.infrastructure;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.students.StudentModuleInfrastructureTestCase;
import tv.codely.mooc.students.domain.Student;
import tv.codely.mooc.students.domain.StudentIdMother;
import tv.codely.mooc.students.domain.StudentMother;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public class MySqlStudentRepositoryShould extends StudentModuleInfrastructureTestCase {
    @Test
    void save_a_valid_student() {
        Student student = StudentMother.random();
        mySqlStudentRepository.save(student);
    }

    @Test
    void search_an_existing_student() {
        Student student = StudentMother.random();

        mySqlStudentRepository.save(student);

        Assert.assertEquals(Optional.of(student), mySqlStudentRepository.search(student.id()));
    }

    @Test
    void not_find_a_non_existing_student() {
        Assert.assertFalse(mySqlStudentRepository.search(StudentIdMother.random()).isPresent());
    }
}
