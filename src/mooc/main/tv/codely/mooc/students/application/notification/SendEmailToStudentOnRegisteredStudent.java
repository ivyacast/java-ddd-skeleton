package tv.codely.mooc.students.application.notification;

import org.springframework.context.event.EventListener;
import tv.codely.mooc.notifications.application.send_email_student_registered.RegisterStudentEmailSender;
import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.student.RegisteredStudentDomainEvent;

@Service
public class SendEmailToStudentOnRegisteredStudent {
    private final RegisterStudentEmailSender sender;

    public SendEmailToStudentOnRegisteredStudent(RegisterStudentEmailSender sender) {
        this.sender = sender;
    }

    @EventListener
    public void on(RegisteredStudentDomainEvent event) {
        sender.send();
        System.out.println("Send email to student");
    }
}
