package fixit.dataloaders.api;

import com.vividsolutions.jts.geom.Geometry;
import fixit.model.Address;
import fixit.model.Review;

import java.sql.Timestamp;
import java.util.List;

public interface IAddressLoader {
    List<Address> getAddress(IConnectionProvider connectionProvider, int profileId);
    void addAddress(IConnectionProvider connectionProvider,
                    String zipCode,
                    Geometry location,
                    String city,
                    String state,
                    String country,
                    String streetAddress,
                    int profileId,
                    Timestamp creationDate);
    void editAddress(IConnectionProvider connectionProvider, int addressId, double score, String comment, boolean recommended,
                    Timestamp modificationDate);
    void deleteAddress(IConnectionProvider connectionProvider, int addressId);
}
