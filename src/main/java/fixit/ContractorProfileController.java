package fixit;

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

    @RequestMapping("/contractorProfilesByCategory")
    public List<ContractorProfile> getContractorProfilesByCategory(@RequestParam(value="categoryId") int categoryId)
    {
        return contractorProfiles;
    }

    @RequestMapping("/contractorProfilesByLocation")
    public List<ContractorProfile> getContractorProfilesByLocation(@RequestParam(value ="longtitude") long longtitude,
                                                                   @RequestParam(value ="lattitude") long lattitude)
    {
        return contractorProfiles;
    }

    @RequestMapping("/contractorProfilesByLocationAndCategory")
    public List<ContractorProfile> getContractorProfilesByLocationAndCategory(@RequestParam(value="categoryId") int categoryId,
                                                                   @RequestParam(value ="longtitude") long longtitude,
                                                                   @RequestParam(value ="lattitude") long lattitude)
    {
        return contractorProfiles;
    }

    @RequestMapping("/contractorProfile")
    public ContractorProfile getContractorProfileById(@RequestParam(value="profileId") int profileId)
    {
        return new ContractorProfile(1,1,1,2, 1, null,null,1);
    }
}
