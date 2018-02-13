package fixit.Controllers;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import fixit.dataloaders.api.IAddressLoader;
import fixit.dataloaders.impls.AddressLoader;
import fixit.dataloaders.impls.PostgresConnectionProvider;
import fixit.model.Address;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AddressController {
    List<Address> addresses = new ArrayList<>();
    private IAddressLoader addressLoader = new AddressLoader();

    @RequestMapping("/contractorProfilesByCategory")
    public List<Address> getAddressByProfileId(@RequestParam(value="profileId") int profileId)
    {
        return addressLoader.getAddress(new PostgresConnectionProvider(),profileId);
    }

    private void loadMockAddress()
    {
        addresses.add(new Address(1, "McFayden Street", "Torbay", "NL",
                "CA", "A1K1C2",
                GeometryFactory.createPointFromInternalCoord(new Coordinate(40,40,0),null),
                1, false));
        addresses.add(new Address(2, "McFayden Street", "Torbay", "NL",
                "CA", "A1K1C2",
                GeometryFactory.createPointFromInternalCoord(new Coordinate(40,40,0),null),
                1, false));
        addresses.add(new Address(3, "McFayden Street", "Torbay", "NL",
                "CA", "A1K1C2",
                GeometryFactory.createPointFromInternalCoord(new Coordinate(40,40,0),null),
                1, false));
        addresses.add(new Address(4, "McFayden Street", "Torbay", "NL",
                "CA", "A1K1C2",
                GeometryFactory.createPointFromInternalCoord(new Coordinate(40,40,0),null),
                1, false));
        addresses.add(new Address(5, "McFayden Street", "Torbay", "NL",
                "CA", "A1K1C2",
                GeometryFactory.createPointFromInternalCoord(new Coordinate(40,40,0),null),
                1, false));
        addresses.add(new Address(6, "McFayden Street", "Torbay", "NL",
                "CA", "A1K1C2",
                GeometryFactory.createPointFromInternalCoord(new Coordinate(40,40,0),null),
                1, false));
    }
}
