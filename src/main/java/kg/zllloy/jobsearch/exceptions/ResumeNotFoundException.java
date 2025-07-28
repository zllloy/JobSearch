package kg.zllloy.jobsearch.exceptions;

public class ResumeNotFoundException extends RuntimeException {
    public ResumeNotFoundException() {
        super("Resume not found");
    }
}
