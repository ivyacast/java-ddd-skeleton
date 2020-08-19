package tv.codely.shared.domain.student;

import jdk.vm.ci.code.Register;
import tv.codely.shared.domain.bus.event.DomainEvent;
import tv.codely.shared.domain.course.CourseCreatedDomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public final class RegisteredStudentDomainEvent extends DomainEvent {
    private final String name;
    private final String surName;
    private final String email;

    public RegisteredStudentDomainEvent() {
        super(null);

        this.name     = null;
        this.surName = null;
        this.email = null;
    }

    public RegisteredStudentDomainEvent(String aggregateId, String name, String surName, String email) {
        super(aggregateId);
        this.name = name;
        this.surName = surName;
        this.email = email;
    }

    public RegisteredStudentDomainEvent(
        String aggregateId,
        String eventId,
        String occurredOn,
        String name,
        String surName,
        String email
    ) {
        super(aggregateId, eventId, occurredOn);
        this.name     = name;
        this.surName = surName;
        this.email = email;
    }
    @Override
    public String eventName() {
        return "student.registered";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("name", name);
            put("surName", surName);
            put("email", email);
        }};
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new RegisteredStudentDomainEvent(
            aggregateId,
            eventId,
            occurredOn,
            (String) body.get("name"),
            (String) body.get("surName"),
            (String) body.get("email")
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisteredStudentDomainEvent that = (RegisteredStudentDomainEvent) o;
        return Objects.equals(name, that.name) &&
            Objects.equals(surName, that.surName) &&
            Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surName, email);
    }
}
