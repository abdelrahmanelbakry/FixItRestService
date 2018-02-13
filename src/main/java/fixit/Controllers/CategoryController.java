package fixit.Controllers;

import fixit.dataloaders.api.ICategoryLoader;
import fixit.dataloaders.impls.CategoryLoader;
import fixit.model.Category;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CategoryController
{
    private static final List<Category> categories = Arrays.asList(new Category(1,"Plumping"),
            new Category(2,"Mechanic"));
    private ICategoryLoader categoryLoader = new CategoryLoader();

    @RequestMapping(value = "/category"
    , method = RequestMethod.GET,
    produces = "application/json")
    public List<Category> getCategories() {
        //categoryLoader.getCategories(new PostgresConnectionProvider());
        return categories;
    }
}
