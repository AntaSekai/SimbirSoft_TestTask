
public class User {
    private final String name="Антон";
    private final String surname="Шаталин";
    private String email ="testMail-java@yandex.ru";
    private String login="testMail-java";
    private String password="qaz123WSX456";

    public String getPassword() {
        return this.password;
    }

    public String getLogin() {
        return this.login;
    }

    public String getEmail(){
        return this.email;
    }

    public String getName(){
        return this.name;
    }

    public String getSurname(){
        return this.surname;
    }
}
