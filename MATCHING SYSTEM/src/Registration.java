public class Registration {
    public int registrationId;
    public String firstName;
    public String email;
    public String region;
    public String industry;
    public String jobPosition;
    public int desiredSalary;


    public Registration(int registrationId, String firstName, String email, String region, String industry, String JobPosition, int desiredSalary ) {
        this.registrationId = registrationId;
        this.firstName = firstName;
        this.email = email;
        this.region = region;
        this.industry = industry;
        this.jobPosition = JobPosition;
        this.desiredSalary = desiredSalary;
    }


}
