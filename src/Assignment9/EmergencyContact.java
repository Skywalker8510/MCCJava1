package Assignment9;

public class EmergencyContact {

    private String name;
    private String relationship;
    private String phone;


    public EmergencyContact(String n, String r, String p)
    {
        name = n;
        phone = p;
        relationship = r;
    }

    public String getName()
    {
        return name;
    }

    public String getPhone()
    {
        return phone;
    }

    public String getRelationship()
    {
        return relationship;
    }

    public void setName(String n)
    {
        name = n;
    }

    public void setPhone(String p)
    {
        phone = p;
    }

    public void setRelationship(String r)
    {
        relationship = r;
    }

    public void printContact()
    {
        System.out.println("Name: " + name);
        System.out.println("Relationship: " + relationship);
        System.out.println("Phone Number: " + phone);
    }

}
