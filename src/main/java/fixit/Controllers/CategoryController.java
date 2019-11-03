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
    private static final List<Category> categories = Arrays.asList(new Category(1,"Plumping", "https://drive.google.com/file/d/1NuVl72n4N-1SS6RJbp8UPk_xyUzDL9hY/view?usp=sharing"),
            new Category(2,"Mechanic", "https://drive.google.com/file/d/1o-95F7u1j5hjXE6iTp4G3Qayj2OCnxSs/view?usp=sharing"));
    private ICategoryLoader categoryLoader = new CategoryLoader();

    @RequestMapping(value = "/category", method = RequestMethod.GET, produces = "application/json")
    public List<Category> getCategories() {
        //categoryLoader.getCategories(new PostgresConnectionProvider());
        return categories;
    }
}
