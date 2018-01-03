package fixit.dataloaders.api;

import fixit.model.Category;

import java.util.List;

public interface ICategoryLoader
{
    List<Category> getCategories(IConnectionProvider connectionProvider);
}
