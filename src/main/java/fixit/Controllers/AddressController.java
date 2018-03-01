package fixit.Controllers;

import fixit.dataloaders.api.IAddressLoader;
import fixit.dataloaders.impls.AddressLoader;
import fixit.model.Address;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AddressController
{
    List<Address> addresses ;//= new ArrayList<>();
    private IAddressLoader addressLoader = new AddressLoader();

    @RequestMapping("/getAddressByProfileId")
    public List<Address> getAddressByProfileId(@RequestParam(value="profileId") int profileId)
    {
        addresses = new ArrayList<>();
        loadMockAddress();
        return addresses.stream().filter(address -> address.profileId == profileId
                && !address.isDeleted)
                .collect(Collectors.toList());
     //   return addressLoader.getAddress(new PostgresConnectionProvider(),profileId);
    }

    private void loadMockAddress()
    {
        addresses.add(new Address(1, "McFayden Street", "Torbay", "NL",
                "CA", "A1K1C2", 40,40, 1, false));
        addresses.add(new Address(2, "McFayden Street", "Torbay", "NL",
                "CA", "A1K1C2",
                40,40, 1, false));
        addresses.add(new Address(3, "McFayden Street", "Torbay", "NL",
                "CA", "A1K1C2", 40,40, 1, false));
        addresses.add(new Address(4, "McFayden Street", "Torbay", "NL",
                "CA", "A1K1C2", 40,40, 2, false));
        addresses.add(new Address(5, "McFayden Street", "Torbay", "NL",
                "CA", "A1K1C2", 40,40, 2, false));
        addresses.add(new Address(6, "McFayden Street", "Torbay", "NL",
                "CA", "A1K1C2", 40,40, 1, true));
    }
}
