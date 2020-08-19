package tv.codely.mooc.notifications.application.send_email_student_registered;

import tv.codely.mooc.notifications.domain.EmailSender;
import tv.codely.shared.domain.Service;

@Service
public class RegisterStudentEmailSender {
    private final EmailSender sender;

    public RegisterStudentEmailSender(EmailSender sender) {
        this.sender = sender;
    }

    public void send(){
        sender.send(null);
    }
}
