package fixit;

import fixit.dataloaders.impls.ContractorProfileLoader;
import fixit.dataloaders.api.IContractorProfileLoader;
import fixit.dataloaders.impls.PostgresConnectionProvider;
import fixit.model.ContractorProfile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

public class ContractorProfileController
{
    List<ContractorProfile> contractorProfiles = new ArrayList<>();
    private IContractorProfileLoader contractorProfileLoader = new ContractorProfileLoader();

    @RequestMapping("/contractorProfilesByCategory")
    public List<ContractorProfile> getContractorProfilesByCategory(@RequestParam(value="categoryId") int categoryId)
    {
        return contractorProfileLoader.getContractorProfilesByCategory(new PostgresConnectionProvider(),categoryId);
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
        return contractorProfileLoader.getContractorProfileById(new PostgresConnectionProvider(), profileId);
    }
}
