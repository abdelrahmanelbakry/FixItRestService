package fixit.dataloaders.impls;

import fixit.Qtypes.QCategory;
import com.mysema.query.sql.HSQLDBTemplates;
import com.mysema.query.sql.SQLQuery;
import com.mysema.query.sql.SQLTemplates;
import com.mysema.query.types.FactoryExpression;
import com.mysema.query.types.Projections;
import fixit.dataloaders.api.ICategoryLoader;
import fixit.dataloaders.api.IConnectionProvider;
import fixit.model.Category;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryLoader implements ICategoryLoader
{
    QCategory category = QCategory.category;

    @Override
    public List<Category> getCategories(IConnectionProvider connectionProvider)
    {
        List<Category> categories = new ArrayList<>();
        try {
            SQLTemplates dialect = new HSQLDBTemplates();
            SQLQuery query = new SQLQuery( connectionProvider.getConnection(), dialect);
            categories = query.from(category).list(mapCategories());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    private FactoryExpression<Category> mapCategories() {
        return Projections.constructor(Category.class,
                category.id,
                category.name);
    }
}
