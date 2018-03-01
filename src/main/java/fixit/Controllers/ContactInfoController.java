package fixit.Controllers;

import fixit.dataloaders.api.IContactInfoLoader;
import fixit.dataloaders.impls.ContactInfoLoader;
import fixit.model.ContactInfo;
import fixit.model.PreferredContactMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactInfoController
{
    ContactInfo contactInfo;// = new ArrayList<>();
    private IContactInfoLoader contactInfoLoader = new ContactInfoLoader();

    @RequestMapping("/contactInfoById")
    public ContactInfo getContactInfoById(@RequestParam(value="contactInfoId") int contactInfoId)
    {
        contactInfo = loadMockContactInfo();
        return contactInfo;
        //return contractorProfileLoader.getContractorProfilesByCategory(new PostgresConnectionProvider(),categoryId);
    }

    private ContactInfo loadMockContactInfo()
    {
        return new ContactInfo(1,"FixIt1", "709-690-6594","","ama727@mun.ca",
                PreferredContactMethod.phone);
    }
}
