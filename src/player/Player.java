package player;

public class Player {

    String Playername;
    int age;
    String address;
    long contactNumber;
    String emailId;
    char PlayerSymbol;

    // public Player(String Playername, int age, String address, long contactNo, String emailid, char PlayerSymbol)
    // {

    //     this.Playername = Playername;
    //     this.age = age;
    //     this.address = address;
    //     this.contactNo = contactNo;
    //     this.emaild = emailid;
    //     this.PlayerSymbol = PlayerSymbol;

    // }

    // public void setPlayerDetails(String Playername, int age, String address, long contactNumber, String emailid, char PlayerSymbol)
    // {
    //     this.Playername = Playername;
    //     this.age = age;
    //     this.address = address;
    //     this.contactNumber = contactNumber;
    //     this.emaild = emailid;
    //     this.PlayerSymbol = PlayerSymbol;

    // }

    public void setPlayerDetails(String Playername, int age)
    {
        this.Playername = Playername;
        this.age = age;
    }

    public void getPlayerInfo()
    {
        System.out.println("Player " + this.Playername);
        System.out.println("Age " + this.age);
    }

    public String getPlayerName(){
        return this.Playername;
    }

    public char getPlayerSymbol(){
        return this.PlayerSymbol;
    }

    public void setPlayerNameAndSymbol(String Playername, char PlayerSymbol)
    {
        this.Playername = Playername;
        this.PlayerSymbol = PlayerSymbol;
    }

    public void getPlayerNameAndSymbol(){
        System.out.println("Player : " + this.Playername);
        System.out.println("Choosen Character : " + this.PlayerSymbol);
    }
}