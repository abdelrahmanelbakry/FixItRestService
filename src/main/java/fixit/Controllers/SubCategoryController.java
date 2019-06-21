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
public class SubCategoryController {
    private static final List<Category> subCategories = Arrays.asList(new Category(1,"Mechanic-Sub2"),
            new Category(2,"Mechanic-Sub1"));
    private ICategoryLoader subCategoryLoader = new CategoryLoader();

    @RequestMapping(value = "/subcategory", method = RequestMethod.GET, produces = "application/json")
    public List<Category> getSubCategories() {
        //categoryLoader.getCategories(new PostgresConnectionProvider());
        return subCategories;
    }
}
