package fixit.Controllers;

import fixit.dataloaders.api.IContactInfoLoader;
import fixit.dataloaders.impls.ContactInfoLoader;
import fixit.model.ContactInfo;
import fixit.model.PreferredContactMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ContactInfoController
{
    List<ContactInfo> contactInfo;// = new ArrayList<>();
    private IContactInfoLoader contactInfoLoader = new ContactInfoLoader();

    @RequestMapping("/contactInfoById")
    public ContactInfo getContactInfoById(@RequestParam(value="contactInfoId") int contactInfoId)
    {
        contactInfo = new ArrayList<>();
        loadMockContactInfo();
        List<ContactInfo> contacts = contactInfo.stream()
                .filter(contactInfo1 -> contactInfo1.id == contactInfoId)
                .collect(Collectors.toList());
        return contacts.get(0);
        //return contractorProfileLoader.getContractorProfilesByCategory(new PostgresConnectionProvider(),categoryId);
    }

    private void loadMockContactInfo()
    {
        contactInfo.add(new ContactInfo(1, "FixIt1", "709-690-6594", "", "ama727@mun.ca",
                        PreferredContactMethod.phone));
        contactInfo.add(new ContactInfo(2, "FixIt2", "709-690-6595", "", "ama727@mun.ca",
                        PreferredContactMethod.phone));
        contactInfo.add(new ContactInfo(3, "FixIt3", "709-690-6596", "", "ama727@mun.ca",
                        PreferredContactMethod.phone));
        contactInfo.add(new ContactInfo(4, "FixIt4", "709-690-6597", "", "ama727@mun.ca",
                        PreferredContactMethod.phone));
    }

}
