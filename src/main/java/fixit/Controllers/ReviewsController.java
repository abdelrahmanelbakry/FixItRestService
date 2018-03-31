package fixit.Controllers;


import fixit.dataloaders.api.IReviewLoader;
import fixit.dataloaders.impls.ReviewLoader;
import fixit.model.Review;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ReviewsController {
    List<Review> reviews;// = new ArrayList<>();
    private IReviewLoader reviewLoader = new ReviewLoader();

    @RequestMapping("/reviewsByProfileId")
    public List<Review> getReviewsByProfile(@RequestParam(value="profileId") int profileId)
    {
        reviews = new ArrayList<>();
        /// return addressLoader.getAddress(new PostgresConnectionProvider(),profileId);
        loadMockReviews();
        return reviews.stream().filter(review -> review.profileId == profileId)
                .collect(Collectors.toList());
    }

    private void loadMockReviews()
    {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        reviews.add(new Review(1, 1, "Very Bad Developer, Won't Recommend!", "Ahmed is an asshole!",false, 1,
                now, now, false, 1));
        reviews.add(new Review(2, 5, "Whom are you calling bad!!", "Ahmed is the Best",true, 1,
                Timestamp.valueOf(now.toLocalDateTime().plusDays(1)), now, false, 1));
        reviews.add(new Review(3, 4, "huh!", "Not too bad!",true, 1,
                now, now, false, 1));
        reviews.add(new Review(4, 1, "Plz avoid this fraud!", "His Name is not even Ahmed!", false, 1,
                now, now, false, 1));
    }
}
