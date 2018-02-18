package fixit.Controllers;

import com.google.common.collect.ImmutableList;
import fixit.dataloaders.api.IMapAnnotationLoader;
import fixit.dataloaders.impls.MapAnnotationLoader;
import fixit.dataloaders.impls.PostgresConnectionProvider;
import fixit.model.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MapAnnotationController {

    List<MapAnnotation> annotations = new ArrayList<>();
    private IMapAnnotationLoader mapAnnotationLoader = new MapAnnotationLoader();

    @RequestMapping("/profilesByCategoryAndLocation")
    public List<MapAnnotation> getAddressByProfileId(@RequestParam(value="categoryId") int profileId,
                                               @RequestParam(value="long") long longtitude,
                                               @RequestParam(value="lat") long latitude)
    {
       /// return addressLoader.getAddress(new PostgresConnectionProvider(),profileId);
        loadMockAnnotations();
        return annotations;
    }

    private void loadMockAnnotations()
    {
        annotations.add(new MapAnnotation(1, 1, 10, 3,
                new ContactInfo(1, "FixIt1","690-6594","","", PreferredContactMethod.email),
                ImmutableList.of(), MembershipType.standard, new Address(1,"McFayden Street", "Torbay", "NL",
                "CA", "A1K1C2", 40,40, 1, false)));
        annotations.add(new MapAnnotation(1, 1, 10, 3,
                new ContactInfo(1, "FixIt2","690-6594","","", PreferredContactMethod.email),
                ImmutableList.of(), MembershipType.standard, new Address(1,"McFayden Street", "Torbay", "NL",
                "CA", "A1K1C2", 40,40, 1, false)));
        annotations.add(new MapAnnotation(1, 1, 10, 3,
                new ContactInfo(1, "FixIt3","690-6594","","", PreferredContactMethod.email),
                ImmutableList.of(), MembershipType.standard, new Address(1,"McFayden Street", "Torbay", "NL",
                "CA", "A1K1C2", 40,40, 1, false)));
        annotations.add(new MapAnnotation(1, 1, 10, 3,
                new ContactInfo(1, "FixIt4","690-6594","","", PreferredContactMethod.email),
                ImmutableList.of(), MembershipType.standard, new Address(1,"McFayden Street", "Torbay", "NL",
                "CA", "A1K1C2", 40,40, 1, false)));
        annotations.add(new MapAnnotation(1, 1, 10, 3,
                new ContactInfo(1, "FixIt5","690-6594","","", PreferredContactMethod.email),
                ImmutableList.of(), MembershipType.standard, new Address(1,"McFayden Street", "Torbay", "NL",
                "CA", "A1K1C2", 40,40, 1, false)));
    }
}