package classes;

import java.util.ArrayList;
import java.util.List;

import headers.Actions;

public class PJ extends Client implements Actions {
    //Attributes
    private String identifier;
    private List<Client> pjList = new ArrayList<Client>();

    //Constructors
    public PJ(){}

    //Getter
    public String getIdentifier() {return identifier;}
    public void setIdentifier(String identifier) {this.identifier = identifier;}

    //Methods
    @Override
    public void register(String name, String phone, String email, String identifier) {
        Client pj = new Client(name, phone, email, identifier);
        this.pjList.add(pj);
    }
    @Override
    public void list() {
        System.out.println("Padrão de exibição:\nNOME\t|\tCNPJ\t|\tEMAIL\t\t|\tTELEFONE\n\n");
        for (Client pj : pjList) viewData(pj);
    }
}
