package fixit.Controllers;

import fixit.dataloaders.api.IContactInfoLoader;
import fixit.dataloaders.impls.ContactInfoLoader;
import fixit.model.AboutContractorInfo;
import fixit.model.PreferredContactMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ContactInfoController
{
    List<AboutContractorInfo> aboutContractorInfo;// = new ArrayList<>();
    private IContactInfoLoader contactInfoLoader = new ContactInfoLoader();

    @RequestMapping("/contactInfoById")
    public AboutContractorInfo getContactInfoById(@RequestParam(value="contactInfoId") int contactInfoId)
    {
        aboutContractorInfo = new ArrayList<>();
        loadMockContactInfo();
        List<AboutContractorInfo> contacts = aboutContractorInfo.stream()
                .filter(aboutContractorInfo1 -> aboutContractorInfo1.id == contactInfoId)
                .collect(Collectors.toList());
        return contacts.get(0);
        //return contractorProfileLoader.getContractorProfilesByCategory(new PostgresConnectionProvider(),categoryId);
    }

    private void loadMockContactInfo()
    {
        aboutContractorInfo.add(new AboutContractorInfo(1, "FixIt1", "709-690-6594", "", "ama727@mun.ca",
                "About Fix it 1, it is the first fix it app mock", PreferredContactMethod.phone));
        aboutContractorInfo.add(new AboutContractorInfo(2, "FixIt2", "709-690-6595", "", "ama727@mun.ca",
                "About Fix it 2, it is the first fix it app mock", PreferredContactMethod.phone));
        aboutContractorInfo.add(new AboutContractorInfo(3, "FixIt3", "709-690-6596", "", "ama727@mun.ca",
                "About Fix it 3, it is the first fix it app mock", PreferredContactMethod.phone));
        aboutContractorInfo.add(new AboutContractorInfo(4, "FixIt4", "709-690-6597", "", "ama727@mun.ca",
                "About Fix it 4, it is the first fix it app mock", PreferredContactMethod.phone));
    }

}
