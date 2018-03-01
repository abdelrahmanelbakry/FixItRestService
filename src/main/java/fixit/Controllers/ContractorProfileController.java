package fixit.Controllers;

import com.google.common.collect.ImmutableList;
import fixit.dataloaders.impls.ContractorProfileLoader;
import fixit.dataloaders.api.IContractorProfileLoader;
import fixit.dataloaders.impls.PostgresConnectionProvider;
import fixit.model.ContractorProfile;
import fixit.model.MembershipType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ContractorProfileController
{
    List<ContractorProfile> contractorProfiles;// = new ArrayList<>();
    private IContractorProfileLoader contractorProfileLoader = new ContractorProfileLoader();

    @RequestMapping("/contractorProfilesByCategory")
    public List<ContractorProfile> getContractorProfilesByCategory(@RequestParam(value="categoryId") int categoryId)
    {
        contractorProfiles = new ArrayList<>();
        loadMockPofile();
        return contractorProfiles;
        //return contractorProfileLoader.getContractorProfilesByCategory(new PostgresConnectionProvider(),categoryId);
    }

    @RequestMapping("/contractorProfilesByLocation")
    public List<ContractorProfile> getContractorProfilesByLocation(@RequestParam(value ="longtitude") long longtitude,
                                                                   @RequestParam(value ="lattitude") long lattitude,
                                                                   @RequestParam(value ="radius") int radius)
    {
        return contractorProfileLoader.getContractorProfilesByLocation(new PostgresConnectionProvider(),
                longtitude, lattitude, radius);
    }

    @RequestMapping("/contractorProfilesByLocationAndCategory")
    public List<ContractorProfile> getContractorProfilesByLocationAndCategory(@RequestParam(value="categoryId") int categoryId,
                                                                   @RequestParam(value ="longtitude") long longtitude,
                                                                   @RequestParam(value ="lattitude") long lattitude,
                                                                   @RequestParam(value ="radius") int radius)
    {
        return contractorProfileLoader.getContractorProfilesByLocationAndCategory(new PostgresConnectionProvider(),
                categoryId, longtitude, lattitude, radius);
    }

    @RequestMapping("/contractorProfile")
    public ContractorProfile getContractorProfileById(@RequestParam(value="profileId") int profileId)
    {
        contractorProfiles = new ArrayList<>();
        loadMockPofile();
        List<ContractorProfile> profiles = contractorProfiles.stream()
                .filter(profile -> profile.id == profileId)
                .collect(Collectors.toList());
        return profiles.get(0);
        // return contractorProfileLoader.getContractorProfileById(new PostgresConnectionProvider(), profileId);
    }

    private void loadMockPofile()
    {
        contractorProfiles.add(new ContractorProfile(1, 1, 10, 4, 1,
                ImmutableList.of(), MembershipType.standard, 1, false));
        contractorProfiles.add(new ContractorProfile(2, 1, 20, 1, 2,
                ImmutableList.of(), MembershipType.standard, 2, false));
        contractorProfiles.add(new ContractorProfile(3, 1, 30, 5, 3,
                ImmutableList.of(), MembershipType.standard, 3, false));
        contractorProfiles.add(new ContractorProfile(4, 2, 40, 2, 4,
                ImmutableList.of(), MembershipType.standard, 4, false));
        contractorProfiles.add(new ContractorProfile(5, 2, 10, 0, 5,
                ImmutableList.of(), MembershipType.premium, 5, false));
    }

}
