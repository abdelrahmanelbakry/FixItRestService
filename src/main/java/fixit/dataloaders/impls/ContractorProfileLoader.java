package fixit.dataloaders.impls;

import com.mysema.query.sql.dml.SQLUpdateClause;
import com.mysema.query.support.Expressions;
import fixit.Qtypes.QAddress;
import fixit.Qtypes.QContractorprofile;
import com.mysema.query.sql.HSQLDBTemplates;
import com.mysema.query.sql.SQLQuery;
import com.mysema.query.sql.SQLTemplates;
import com.mysema.query.types.FactoryExpression;
import com.mysema.query.types.Projections;
import fixit.dataloaders.api.IConnectionProvider;
import fixit.dataloaders.api.IContractorProfileLoader;
import fixit.model.ContractorProfile;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ContractorProfileLoader implements IContractorProfileLoader {
    QContractorprofile contractorProfiletb = QContractorprofile.contractorprofile;
    QAddress addresstb = QAddress.address;

    @Override
    public List<ContractorProfile> getContractorProfilesByCategory(IConnectionProvider connectionProvider, int categoryId) {
        List<ContractorProfile> profileList = new ArrayList<>();
        try {
            SQLTemplates dialect = new HSQLDBTemplates();
            SQLQuery query = new SQLQuery( connectionProvider.getConnection(), dialect);
            profileList = query.from(contractorProfiletb)
                    .where(contractorProfiletb.categoryid.eq(categoryId))
                    .list(mapContractorProfile());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profileList;
    }

    @Override
    public List<ContractorProfile> getContractorProfilesByLocation(IConnectionProvider connectionProvider, long longtitude,
                                                                   long lattitude, int radius) {
        List<ContractorProfile> profileList = new ArrayList<>();
        try {
            SQLTemplates dialect = new HSQLDBTemplates();
            SQLQuery query = new SQLQuery( connectionProvider.getConnection(), dialect);
            profileList = query.from(contractorProfiletb)
                    .innerJoin(addresstb)
                    .where(contractorProfiletb.id.eq(addresstb.id)
                        .and(Expressions.booleanTemplate("ST_DWithin({0}, ST_MakePoint({1}, {2}), {3})",
                                addresstb.location, longtitude, lattitude, radius)))
                    .list(mapContractorProfile());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profileList;
    }

    @Override
    public List<ContractorProfile> getContractorProfilesByLocationAndCategory(IConnectionProvider connectionProvider,
                                                                              int categoryId,
                                                                              long longtitude,
                                                                              long lattitude,
                                                                              int radius)
    {
        List<ContractorProfile> profileList = new ArrayList<>();
        try {
            SQLTemplates dialect = new HSQLDBTemplates();
            SQLQuery query = new SQLQuery( connectionProvider.getConnection(), dialect);
            profileList = query.from(contractorProfiletb)
                    .innerJoin(addresstb)
                    .where(contractorProfiletb.id.eq(addresstb.id)
                            .and(contractorProfiletb.categoryid.eq(categoryId))
                            .and(Expressions.booleanTemplate("ST_DWithin({0}, ST_MakePoint({1}, {2}), {3})",
                                    addresstb.location, longtitude, lattitude, radius)))
                    .list(mapContractorProfile());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profileList;
    }

    @Override
    public ContractorProfile getContractorProfileById(IConnectionProvider connectionProvider, int profileId) {
        ContractorProfile contractorProfile = null;
        try {
            SQLTemplates dialect = new HSQLDBTemplates();
            SQLQuery query = new SQLQuery( connectionProvider.getConnection(), dialect);
            contractorProfile = query.from(contractorProfiletb)
                    .where(contractorProfiletb.id.eq(profileId))
                    .uniqueResult(mapContractorProfile());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contractorProfile;
    }

    @Override
    public void addContractorProfile(IConnectionProvider connectionProvider, int categoryId, double hourlyRate, double overallScore, int customerId, Timestamp creationDate) {

    }

    @Override
    public void editContractorProfile(IConnectionProvider connectionProvider, int profileId, int categoryId, double hourlyRate, double overallScore, Timestamp modificationDate) {

    }

    @Override
    public void deleteContractorProfile(IConnectionProvider connectionProvider, int profileId) {
//        try {
//            SQLTemplates dialect = new HSQLDBTemplates();
//            new SQLUpdateClause(connectionProvider.getConnection(), dialect, contractorProfiletb)
//                    .set(contractorProfiletb.isdeleted, true)
//                    .where(contractorProfiletb.id.eq(profileId))
//                    .execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return;
    }

    private FactoryExpression<ContractorProfile> mapContractorProfile() {
        return Projections.constructor(ContractorProfile.class,
                contractorProfiletb.id,
                contractorProfiletb.categoryid,
                contractorProfiletb.hourlyrate,
                contractorProfiletb.overallscore,
                contractorProfiletb.contactinfoid,
                contractorProfiletb.reviewids,
                contractorProfiletb.memebershiptype,
                contractorProfiletb.addressid);
    }
}
