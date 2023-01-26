public class Vacancy {
    public int vacancyId;
    public String company;
    public String email;
    public String region;
    public String industry;
    public String jobPosition;
    public int startSalary;
    public int endSalary;


    public Vacancy(int vacancyId, String company, String email, String region, String industry, String JobPosition, int StartSalary, int EndSalary ) {
        this.vacancyId = vacancyId;
        this.company = company;
        this.email = email;
        this.region = region;
        this.industry = industry;
        this.jobPosition = JobPosition;
        this.startSalary = StartSalary;
        this.endSalary = EndSalary;
    }


}
