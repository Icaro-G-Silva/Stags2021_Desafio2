package classes;

import java.util.ArrayList;
import java.util.List;

import headers.Actions;

public class PF extends Client implements Actions {
    //Attributes
    private String identifier;
    private List<Client> pfList = new ArrayList<Client>();

    //Constructors
    public PF(){}

    //Getter
    public String getIdentifier() {return identifier;}
    public void setIdentifier(String identifier) {this.identifier = identifier;}

    //Methods
    @Override
    public void register(String name, String phone, String email, String identifier) {
        Client pf = new Client(name, phone, email, identifier);
        this.pfList.add(pf);
    }
    @Override
    public void list() {
        System.out.println("Padrão de exibição:\nNOME\t|\tCPF\t|\tEMAIL\t\t|\tTELEFONE\n\n");
        for (Client pf : pfList) viewData(pf);
    }
}
