package fixit.Controllers;

import com.google.common.collect.ImmutableList;
import fixit.dataloaders.impls.ContractorProfileLoader;
import fixit.dataloaders.api.IContractorProfileLoader;
import fixit.dataloaders.impls.PostgresConnectionProvider;
import fixit.model.Address;
import fixit.model.ContractorProfile;
import fixit.model.ContractorsVw;
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
    List<ContractorProfile> contractorProfiles;
    List<ContractorsVw> contractorsVws;
    private IContractorProfileLoader contractorProfileLoader = new ContractorProfileLoader();

    @RequestMapping("/getListOfContractorsBySubCategoryId")
    public List<ContractorsVw> getContractorsBySubCategoryId(@RequestParam(value="subCategoryId") int subCategoryId)
    {
        contractorsVws = loadMockContractors();
        return contractorsVws.stream()
                .filter(contractorsVw -> !contractorsVw.isDeleted &&
                                         contractorsVw.subCategoryId == subCategoryId)
                .collect(Collectors.toList());
    }

    @RequestMapping("/contractorProfilesByCategory")
    public List<ContractorProfile> getContractorProfilesByCategory(@RequestParam(value="categoryId") int categoryId)
    {
        contractorProfiles = new ArrayList<>();
        loadMockPofile();
        return contractorProfiles.stream()
                .filter(contractorsVw -> !contractorsVw.isDeleted &&
                        contractorsVw.categoryId == categoryId)
                .collect(Collectors.toList());
    }

    @RequestMapping("/contractorProfilesByCategoryAndSubCategoryId")
    public List<ContractorsVw> getContractorProfilesByCategoryAndSubCategoryId(@RequestParam(value="categoryId") int categoryId,
                                                                               @RequestParam(value="subCategoryId") int subCategoryId)
    {
        contractorsVws = loadMockContractors();
        return contractorsVws.stream()
                .filter(contractorsVw -> !contractorsVw.isDeleted &&
                        contractorsVw.categoryId == categoryId &&
                        contractorsVw.subCategoryId == subCategoryId)
                .collect(Collectors.toList());
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
    }

    @RequestMapping("/canLogin")
    public Boolean canLogin(@RequestParam(value="username") String username,
                            @RequestParam(value="password") String password)
    {
        contractorProfiles = new ArrayList<>();
        loadMockPofile();
        List<ContractorProfile> profiles = contractorProfiles.stream()
                .filter(profile -> profile.username.equalsIgnoreCase( username) && profile.password.equals(password))
                .collect(Collectors.toList());
        return profiles.size() > 0;
    }

    private void loadMockPofile()
    {
        contractorProfiles.add(new ContractorProfile(1, 1, 10, 4, 1,
                ImmutableList.of(), MembershipType.standard, 1, "ama727", "123456", false));
        contractorProfiles.add(new ContractorProfile(2, 1, 20, 1, 2,
                ImmutableList.of(), MembershipType.standard, 2, "ama727", "123456", false));
        contractorProfiles.add(new ContractorProfile(3, 1, 30, 5, 3,
                ImmutableList.of(), MembershipType.standard, 3, "ama727", "123456", false));
        contractorProfiles.add(new ContractorProfile(4, 2, 40, 2, 4,
                ImmutableList.of(), MembershipType.standard, 4, "ama727", "123456", false));
        contractorProfiles.add(new ContractorProfile(5, 2, 10, 0, 5,
                ImmutableList.of(), MembershipType.premium, 5, "ama727", "123456", false));
    }

    private List<ContractorsVw> loadMockContractors()
    {
        List<ContractorsVw> contractorsVws = new ArrayList<>();
        contractorsVws.add(new ContractorsVw(1, 1, 10.0, 3, MembershipType.standard,
                new Address(1, "2 Bells Turn", "St. Johns", "NL", "CA",
                        "A11DF2",100, 100,1,false),
                "fix it 1", false, "https://drive.google.com/file/d/1YcPiCFp90WupAj9GzmhOHTog4i16n6C8/view?usp=sharing", 1));
        contractorsVws.add(new ContractorsVw(2, 1, 100.0, 5, MembershipType.standard,
                new Address(1, "4 Bells Turn", "St. Johns", "NL", "CA",
                        "A11DF2",100, 100,1,false),
                "fix it 2", false, "https://drive.google.com/file/d/1YcPiCFp90WupAj9GzmhOHTog4i16n6C8/view?usp=sharing", 1));
        contractorsVws.add(new ContractorsVw(3, 2, 100.0, 5, MembershipType.standard,
                new Address(1, "4 Bells Turn", "St. Johns", "NL", "CA",
                        "A11DF2",100, 100,1,false),
                "fix it 2", false, "https://drive.google.com/file/d/1YcPiCFp90WupAj9GzmhOHTog4i16n6C8/view?usp=sharing", 2));
        return contractorsVws;
    }

}
