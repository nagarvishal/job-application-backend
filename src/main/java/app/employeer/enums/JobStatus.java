package app.employeer.enums;

public enum JobStatus {
    OPEN("open"),
    CLOSED("closed"),
    DRAFT("draft");

    private final String value;

    JobStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    /**
     * Returns a JobStatus from a string (case-insensitive),
     * or throws an IllegalArgumentException if invalid.
     */
    public static JobStatus fromString(String status) {
        for (JobStatus s : JobStatus.values()) {
            if (s.value.equalsIgnoreCase(status)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Invalid JobStatus: " + status);
    }
}
