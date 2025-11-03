package app.employeer.enums;

public enum JobType {
    FULL_TIME("full-time"),
    PART_TIME("part-time"),
    INTERNSHIP("internship"),
    CONTRACT("contract");

    private final String value;

    JobType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}