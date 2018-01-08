package fixit;

import fixit.dataloaders.impls.CategoryLoader;
import fixit.dataloaders.api.ICategoryLoader;
import fixit.dataloaders.impls.PostgresConnectionProvider;
import fixit.model.Category;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class CategoryController
{
    private static final List<Category> categories = new ArrayList<>();
    private ICategoryLoader categoryLoader = new CategoryLoader();

    @RequestMapping(value = "/category"
    , method = RequestMethod.GET,
    produces = "application/json")
    public List<Category> getCategories() {
        //categoryLoader.getCategories(new PostgresConnectionProvider());
        categories.add(new Category(1,"Plumping"));
        categories.add(new Category(2,"Mechanic"));
        return categories;
    }
}
