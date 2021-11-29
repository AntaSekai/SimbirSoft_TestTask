
public class User {
    private final String name="Антон";
    private final String surname="Шаталин";
    private String address="testMail-java@yandex.ru";
    private String login="testMail-java";
    private String password="qaz123WSX456";

    public String getPassword() {
        return this.password;
    }

    public String getLogin() {
        return this.login;
    }

    public String getAddress(){
        return this.address;
    }

    public String getName(){
        return this.name;
    }

    public String getSurname(){
        return this.surname;
    }
}
