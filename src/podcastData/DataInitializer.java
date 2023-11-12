/*-----------------------------------------------------------------------------------------
 * NAME : DataInitializer.java
 * VER  : v0.1
 * PROJ : Akara
 * CODE CLEAN? : Yes
 *-----------------------------------------------------------------------------------------
 *                      H      I      S      T      O      R      Y
 *-----------------------------------------------------------------------------------------
 *   DATE        AUTHOR         DESCRIPTION
 * ----------  --------------  ------------------------------------------------------------
 * 2022-07-05   Nuth Vireak     creation
 * ----------  --------------  ------------------------------------------------------------
 * 2022-08-03   Nuth Vireak     Modification
 *---------------------------------------------------------------------------------------*/

package podcastData;

import com.github.javafaker.Faker;
import model.Podcast;
import model.RandomGenre;
import model.RandomImage;
import model.RandomSoundPodcast;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataInitializer {

    Faker faker = new Faker();

    List<String> titleList = Stream.generate(() -> faker.name().title()).distinct().limit(1000).collect(Collectors.toList());

    public List<Podcast> podcastList() {

        List<Podcast> podcastList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Podcast podcast = new Podcast();
            podcast.setId(i);


            podcast.setTitle(titleList.get(i));


            podcast.setDescription(faker.lorem().paragraph());
            podcast.setCover(randomImage());
            podcast.setGenre(randomGenre());
            podcast.setPodcaster(faker.artist().name());
            podcast.setDuration(String.valueOf(faker.random().nextInt(30, 60)));
            podcast.setPodcastUrl(randomSoundPodcast());
            podcast.setCreatedAt(faker.business().creditCardExpiry());
            podcast.setUpdatedAt(faker.business().creditCardExpiry());
            podcast.setWasPlayed(faker.random().nextBoolean());
            podcast.setViewCount(Integer.parseInt(faker.phoneNumber().subscriberNumber()));
            podcast.setCreatedAt(faker.backToTheFuture().date());
            podcastList.add(podcast);
        }

        return podcastList;
    }

    public String randomGenre() {
        int randomNumber = (int) (Math.random() * RandomGenre.values().length);
        return RandomGenre.values()[randomNumber].toString();
    }

    public String randomImage() {
        int randomNumber = (int) (Math.random() * RandomImage.values().length);
        return RandomImage.values()[randomNumber].getImageUrl();
    }

    public String randomSoundPodcast() {
        int randomNumber = (int) (Math.random() * RandomSoundPodcast.values().length);
        return RandomSoundPodcast.values()[randomNumber].getSoundPodcastUrl();
    }
}
