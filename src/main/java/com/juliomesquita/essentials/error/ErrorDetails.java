package com.juliomesquita.essentials.error;

public class ErrorDetails {
    private String title;
    private int status;
    private String details;
    private long timestamp;
    private String message;

    public ErrorDetails(String title, int status, String details, long timestamp, String message) {
        this.title = title;
        this.status = status;
        this.details = details;
        this.timestamp = timestamp;
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public int getStatus() {
        return status;
    }

    public String getDetails() {
        return details;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String title;
        private int status;
        private String details;
        private long timestamp;
        private String message;
        private Builder() {}

        public Builder title(String val) {
            title = val;
            return this;
        }

        public Builder status(int val) {
            status = val;
            return this;
        }

        public Builder details(String val) {
            details = val;
            return this;
        }

        public Builder timestamp(long val) {
            timestamp = val;
            return this;
        }

        public Builder message(String val) {
            message = val;
            return this;
        }

        public ErrorDetails build() {
            return new ErrorDetails(
                    this.title,
                    this.status,
                    this.details,
                    this.timestamp,
                    this.message
            );
        }
    }
}
