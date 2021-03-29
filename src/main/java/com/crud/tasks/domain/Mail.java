package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class Mail {
    private final String mailTo;
    private final String subject;
    private final String message;
    private String toCC;

    public Mail (final String mailTo, final String subject, final String message, final String toCC) {
        this.mailTo = mailTo;
        this.subject = subject;
        this.message = message;
        this.toCC = toCC;
    }

    public Mail(String mailTo, String subject, String message) {
        this.mailTo = mailTo;
        this.subject = subject;
        this.message = message;
    }

    public static class MailBuilder {
        private String mailTo;
        private String subjects;
        private String message;
        private String toCC = new String();

        public MailBuilder mailTo(String mailTo) {
            this.mailTo = mailTo;
            return this;
        }

        public MailBuilder subjects(String subjects) {
            this.subjects = subjects;
            return this;
        }

        public MailBuilder message(String message) {
            this.message = message;
            return this;
        }

        public MailBuilder toCC(String toCC) {
            this.toCC = toCC;
            return this;
        }

        public Mail build() {
            return new Mail(mailTo, subjects, message, toCC);
        }
    }
}