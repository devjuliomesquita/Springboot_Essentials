package com.juliomesquita.essentials.error;

public class ValidationsErrorDetails extends ErrorDetails {
    private String field;
    private String fieldMessage;

    public ValidationsErrorDetails(String title, int status, String details, long timestamp, String message, String field, String fieldMessage) {
        super(title, status, details, timestamp, message);
        this.field = field;
        this.fieldMessage = fieldMessage;
    }

    public String getField() {
        return field;
    }

    public String getFieldMessage() {
        return fieldMessage;
    }

    public static final class ValidationBuilder {
        private String title;
        private int status;
        private String details;
        private long timestamp;
        private String message;
        private String field;
        private String fieldMessage;

        private ValidationBuilder() {}

        public static ValidationBuilder builder() {
            return new ValidationBuilder();
        }
        public ValidationBuilder title(String val) {
            title = val;
            return this;
        }

        public ValidationBuilder status(int val) {
            status = val;
            return this;
        }

        public ValidationBuilder details(String val) {
            details = val;
            return this;
        }

        public ValidationBuilder timestamp(long val) {
            timestamp = val;
            return this;
        }

        public ValidationBuilder message(String val) {
            message = val;
            return this;
        }

        public ValidationBuilder field(String val) {
            field = val;
            return this;
        }

        public ValidationBuilder fieldMessage(String val) {
            fieldMessage = val;
            return this;
        }

        public ValidationsErrorDetails build() {
            return new ValidationsErrorDetails(
                    this.title,
                    this.status,
                    this.details,
                    this.timestamp,
                    this.message,
                    this.field,
                    this.fieldMessage
            );
        }
    }
}
