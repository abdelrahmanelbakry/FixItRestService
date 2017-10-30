package fixit.dataloaders;

import com.mysema.query.support.Expressions;
import com.vividsolutions.jts.operation.distance.GeometryLocation;
import fixit.Qtypes.QAddress;
import fixit.Qtypes.QContractorprofile;
import com.mysema.query.sql.HSQLDBTemplates;
import com.mysema.query.sql.SQLQuery;
import com.mysema.query.sql.SQLTemplates;
import com.mysema.query.types.FactoryExpression;
import com.mysema.query.types.Projections;
import fixit.Qtypes.QGeographyColumns;
import fixit.model.ContractorProfile;
import org.geolatte.geom.GeometryType;
import org.postgis.Geometry;
import org.postgis.Point;

import java.sql.SQLException;
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

    //SELECT * FROM(
//    SELECT *,(((acos(sin((@latitude*pi()/180)) * sin((Latitude*pi()/180))+cos((@latitude*pi()/180)) * cos((Latitude*pi()/180))
//          * cos(((@longitude - Longitude)*pi()/180))))*180/pi())*60*1.1515*1.609344) as distance FROM Distances) t
//    WHERE distance <= @distance
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
