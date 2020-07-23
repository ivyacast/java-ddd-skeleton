package tv.codely.mooc.students.infrastructure;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import tv.codely.mooc.students.domain.Student;
import tv.codely.mooc.students.domain.StudentId;
import tv.codely.mooc.students.domain.StudentRepository;
import tv.codely.shared.domain.Service;
import tv.codely.shared.infrastructure.hibernate.HibernateRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional("mooc-transaction_manager")
public class MySqlStudentRepository extends HibernateRepository<Student> implements StudentRepository {
    public MySqlStudentRepository(@Qualifier("mooc-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, Student.class);
    }

    @Override
    public List<Student> searchAll() {
        return all();
    }

    @Override
    public Optional<Student> search(StudentId id) {
        return byId(id);
    }

    @Override
    public void save(Student student) {
        persist(student);
    }
}
