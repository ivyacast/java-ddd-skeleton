package tv.codely.mooc.students;

import org.springframework.beans.factory.annotation.Autowired;
import tv.codely.mooc.MoocContextInfrastructureTestCase;
import tv.codely.mooc.students.infrastructure.InMemoryStudentRepository;

public abstract class StudentModuleInfrastructureTestCase extends MoocContextInfrastructureTestCase {
    @Autowired
    protected InMemoryStudentRepository repository;
}
