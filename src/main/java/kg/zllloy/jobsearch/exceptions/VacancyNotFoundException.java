package kg.zllloy.jobsearch.exceptions;

public class VacancyNotFoundException extends RuntimeException {
    public VacancyNotFoundException() {
        super("Vacancy not found");
    }
}
