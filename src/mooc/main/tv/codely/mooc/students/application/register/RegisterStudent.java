package tv.codely.mooc.students.application.register;

import tv.codely.mooc.students.domain.*;
import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.bus.event.EventBus;

@Service
public class RegisterStudent {
    private final StudentRepository repository;
    private final EventBus eventBus;

    public RegisterStudent(StudentRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    public void register(RegisterStudentRequest request) {
        StudentId id = new StudentId(request.id());
        StudentName name = new StudentName(request.name());
        StudentSurName surName = new StudentSurName(request.surname());
        StudentEmail email = new StudentEmail(request.email());

        Student student = Student.register(id, name, surName, email);

        repository.save(student);
        eventBus.publish(student.pullDomainEvents());
    }
}
