package Parser;

public class Document {
    private static String lastname;
    private static String firstname;
    private static String nationality;
    private static String yearOfBirth;
    private static String yearOfDeath;
    private static String title;

    private static StringBuilder sb = new StringBuilder();

    public static String getLastname() {
        return lastname;
    }

    public static void setLastname(String lastname) {
        Document.lastname = lastname;
    }

    public static String getFirstname() {
        return firstname;
    }

    public static void setFirstname(String firstname) {
        Document.firstname = firstname;
    }

    public static String getNationality() {
        return nationality;
    }

    public static void setNationality(String nationality) {
        Document.nationality = nationality;
    }

    public static String getYearOfBirth() {
        return yearOfBirth;
    }

    public static void setYearOfBirth(String yearOfBirth) {
        Document.yearOfBirth = yearOfBirth;
    }

    public static String getYearOfDeath() {
        return yearOfDeath;
    }

    public static void setYearOfDeath(String yearOfDeath) {
        Document.yearOfDeath = yearOfDeath;
    }

    public static String getTitle() {
        return title;
    }

    public static void setTitle(String title) {
        Document.title = title;
    }


    public static StringBuilder getSb() {
        return sb;
    }

    public static void addToPoem(String line) {
        Document.sb.append(line);
    }
}
