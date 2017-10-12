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

    @RequestMapping("/contractorProfiles")
    public List<ContractorProfile> getContractorProfiles(@RequestParam(value="categoryId") int categoryId)
    {
        return contractorProfiles;
    }
}
