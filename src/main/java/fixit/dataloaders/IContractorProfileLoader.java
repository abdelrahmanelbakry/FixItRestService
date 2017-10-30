package fixit.dataloaders;

import fixit.model.ContractorProfile;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IContractorProfileLoader {
    List<ContractorProfile> getContractorProfilesByCategory(IConnectionProvider connectionProvider, int categoryId);
    List<ContractorProfile> getContractorProfilesByLocation(IConnectionProvider connectionProvider, long longtitude,
                                                            long lattitude , int radius);
    List<ContractorProfile> getContractorProfilesByLocationAndCategory(IConnectionProvider connectionProvider, int categoryId,
                                                                       long longtitude, long lattitude, int radius);
    ContractorProfile getContractorProfileById(IConnectionProvider connectionProvider, int profileId);

}
