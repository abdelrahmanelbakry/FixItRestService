package fixit;

import fixit.model.Category;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController
{
    private static final List<Category> categories = new ArrayList<>();

    @RequestMapping("/category")
    public List<Category> getCategories() {
        return categories;
    }
}
