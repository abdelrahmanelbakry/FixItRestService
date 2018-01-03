package fixit.dataloaders.api;

import fixit.model.ContractorProfile;

import java.sql.Timestamp;
import java.util.List;

public interface IContractorProfileLoader {
    List<ContractorProfile> getContractorProfilesByCategory(IConnectionProvider connectionProvider, int categoryId);
    List<ContractorProfile> getContractorProfilesByLocation(IConnectionProvider connectionProvider, long longtitude,
                                                            long lattitude , int radius);
    List<ContractorProfile> getContractorProfilesByLocationAndCategory(IConnectionProvider connectionProvider, int categoryId,
                                                                       long longtitude, long lattitude, int radius);
    ContractorProfile getContractorProfileById(IConnectionProvider connectionProvider, int profileId);
    void addContractorProfile(IConnectionProvider connectionProvider, int categoryId, double hourlyRate, double overallScore,
                   int customerId, Timestamp creationDate);
    void editContractorProfile(IConnectionProvider connectionProvider, int profileId, int categoryId, double hourlyRate, double overallScore,
                    Timestamp modificationDate);
    void deleteContractorProfile(IConnectionProvider connectionProvider, int profileId);
}
