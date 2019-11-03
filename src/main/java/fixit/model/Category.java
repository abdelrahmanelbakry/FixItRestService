package fixit.model;



//@Entity

public class Category
{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public final int id;
    public final String name;
    public final String iconURL;

    public Category(int id, String name, String iconURL)
    {
        this.id = id;
        this.name = name;
        this.iconURL = iconURL;
    }

}
