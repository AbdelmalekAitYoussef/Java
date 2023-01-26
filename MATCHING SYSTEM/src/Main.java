import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Registration> registrationList =  new ArrayList<Registration>();
    private static ArrayList<Vacancy> vacancyList = new ArrayList<Vacancy>();
    private Match[] Match;

    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/schema";
        String username="root";
        String password="Abdel123";



        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url,username,password);

            Statement vacanciesStatement=connection.createStatement();

            ResultSet vacanciesRS=vacanciesStatement.executeQuery("select * from vacancies");

            Statement registrationsStatement=connection.createStatement();

            ResultSet registrationsRS =registrationsStatement.executeQuery("select * from registrations");

            Statement matchStatement = connection.createStatement();


            while (vacanciesRS.next()){
                int vacancyId = vacanciesRS.getInt("vacancyId");
                String company = vacanciesRS.getString("company");
                String email = vacanciesRS.getString("email");
                String region = vacanciesRS.getString("region");
                String industry = vacanciesRS.getString("industry");
                String jobPosition = vacanciesRS.getString("jobPosition");
                int StartSalary = vacanciesRS.getInt("StartSalary");
                int Endsalary = vacanciesRS.getInt("Endsalary");


                Vacancy vacancy = new Vacancy(vacancyId,company,email,region,industry,jobPosition,StartSalary,Endsalary );
                vacancyList.add(vacancy);
                // new vacancy object()
                // Vacancy vacancy = new Vacancy();
                // vacancy.setRegistrationId(vacanciesRS.getInt("vacancyId"))
                //int a = vacanciesRS.getInt("vacancyId");
                //System.out.print(vacanciesRS.getInt("vacancyId")+vacanciesRS.getInt("company")+vacanciesRS.getInt("email")+registrationsRS.getInt("region")+vacanciesRS.getInt("industry")+vacanciesRS.getInt("jobPosition")+vacanciesRS.getInt("StartSalary")+vacanciesRS.getInt("EndSalary"));
            }
            while (registrationsRS.next()){
                    int registrationId = registrationsRS.getInt("registrationId");
                    String firstName = registrationsRS.getString("firstName");
                    String email = registrationsRS.getString("email");
                    String region = registrationsRS.getString("region");
                    String industry = registrationsRS.getString("industry");
                    String jobPosition = registrationsRS.getString("jobPosition");
                    int desiredSalary = registrationsRS.getInt("desiredSalary");

                    Registration registration = new Registration(registrationId,firstName,email,region,industry,jobPosition,desiredSalary);
                    registrationList.add(registration);
                    //System.out.println(registrationsRS.getInt("registrationId")+ ""+registrationsRS.getInt("firstName")+registrationsRS.getInt("email")+registrationsRS.getInt("region")+registrationsRS.getInt("industry")+registrationsRS.getInt("jobPosition")+registrationsRS.getInt("desiredSalary"));
            }
            


        int procent = 0;

        for (Registration reg : registrationList) {
            for (Vacancy vac : vacancyList){
                if (reg.region.equalsIgnoreCase(vac.region)){
                    procent += 25;
                    System.out.println("Region is a match! Added 25 to match percentage!");

                }
                if (reg.industry.equalsIgnoreCase(vac.industry)){
                    procent += 25;
                    System.out.println("Industry is a match! Added 25 to match percentage!");
                }
                if ( reg.jobPosition.equalsIgnoreCase(vac.jobPosition)) {
                    procent += 25;
                    System.out.println("JobPosition is a match! Added 25 to match percentage!");
                }
                if (reg.desiredSalary>vac.startSalary&&reg.desiredSalary<vac.endSalary){
                    procent += 25;
                    System.out.println("Salary is inbetween start salary and end salary! Added 25 to match percentage!");
            }
                matchStatement.executeUpdate("INSERT INTO `match` (registrationId, vacancyId, percentage) VALUES ("+reg.registrationId+", "+vac.vacancyId+", "+procent+");");

        }

        }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }}


