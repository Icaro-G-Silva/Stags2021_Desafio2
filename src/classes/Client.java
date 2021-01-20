package classes;

public class Client {
    //Attributes
    private String name;
    private String phone;
    private String email;
    private String identifier;

    //Constructors
    public Client(){}
    public Client(String name, String phone, String email, String identifier) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.identifier = identifier;
    }

    //Getters/Setters
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getIdentifier() {return identifier;}
    public void setIdentifier(String identifier) {this.identifier = identifier;}

    //Methods - Sharing with Children
    public void viewData(Client client) {
        System.out.printf("%s\t|\t%s\t|\t", client.getName(), client.getIdentifier());
        System.out.printf("%s\t\t|\t%s\n", client.getEmail(), client.getPhone());
        System.out.println();
    }
}
