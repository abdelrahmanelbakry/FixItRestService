package fixit.model;



//@Entity

public class Category
{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public final int id;
    public final String name;

    public Category(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

}
