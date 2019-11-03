package fixit.dataloaders.impls;

import com.mysema.query.sql.HSQLDBTemplates;
import com.mysema.query.sql.SQLQuery;
import com.mysema.query.sql.SQLTemplates;
import com.mysema.query.types.FactoryExpression;
import com.mysema.query.types.Projections;
import com.vividsolutions.jts.geom.Geometry;
import fixit.Qtypes.QAddress;
import fixit.dataloaders.api.IAddressLoader;
import fixit.dataloaders.api.IConnectionProvider;
import fixit.model.Address;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AddressLoader implements IAddressLoader
{
    QAddress address = QAddress.address;

    @Override
    public List<Address> getAddress(IConnectionProvider connectionProvider, int profileId) {
        List<Address> addresses = new ArrayList<>();
        try {
            SQLTemplates dialect = new HSQLDBTemplates();
            SQLQuery query = new SQLQuery( connectionProvider.getConnection(), dialect);
            addresses = query.from(address)
                    .where(address.id.eq(profileId))
                    .list(mapAddress());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addresses;
    }


    @Override
    public void addAddress(IConnectionProvider connectionProvider,
                           String zipCode,
                           Geometry location,
                           String city,
                           String state,
                           String country,
                           String streetAddress,
                           int profileId,
                           Timestamp creationDate) {
//        try {
////            SQLTemplates dialect = new HSQLDBTemplates();
////            new SQLInsertClause(connectionProvider.getConnection(), dialect, address)
////                    .values(comment, score, recommended, customerId, creationDate,
////                            creationDate, false, profileId)
////                    .execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return ;
    }

    @Override
    public void editAddress(IConnectionProvider connectionProvider, int addressId, double score, String comment, boolean recommended, Timestamp modificationDate) {

    }

    @Override
    public void deleteAddress(IConnectionProvider connectionProvider, int addressId) {

    }


    private FactoryExpression<Address> mapAddress() {
        return Projections.constructor(Address.class,
                address.id);
//                address.categoryid,
//                address.hourlyrate,
//                address.overallscore,
//                address.contactinfoid,
//                address.reviewids,
//                address.memebershiptype,
//                address.addressid);
    }
}
