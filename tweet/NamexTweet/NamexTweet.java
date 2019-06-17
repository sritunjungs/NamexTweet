import java.io.IOException;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class NamexTweet {
    private final static String CONSUMER_KEY = "kBhlOTcWI66SosJuO4m0EYmWv";
    private final static String CONSUMER_KEY_SECRET = "FeSTNjfic80sLlY8GN61sNVtQKGcJ7kQJEG70LSEoU2Cw4PP3h";

    public void start() throws TwitterException, IOException {

	Twitter twitter = new TwitterFactory().getInstance();
	twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

	// here's the difference
	String accessToken = getSavedAccessToken();
	String accessTokenSecret = getSavedAccessTokenSecret();
	AccessToken oathAccessToken = new AccessToken(accessToken,
		accessTokenSecret);

	twitter.setOAuthAccessToken(oathAccessToken);
	// end of difference

	twitter.updateStatus("Haloooooooo test test");

	System.out.println("\nMy Timeline:");

	// I'm reading your timeline
	ResponseList<Status> list = twitter.getHomeTimeline();
	for (Status each : list) {

	    System.out.println("Sent by: @" + each.getUser().getScreenName()
		    + " - " + each.getUser().getName() + "\n" + each.getText()
		    + "\n");
	}

    }

    private String getSavedAccessTokenSecret() {
	// consider this is method to get your previously saved Access Token
	// Secret
	return "0DSsk0JbQZgEkzsN1HXYnzcm4vNZFUHHifHCuf8hqZKkm";
    }

    private String getSavedAccessToken() {
	// consider this is method to get your previously saved Access Token
	return "1140707412170555393-UT8SyHR6fkqavDXNKPQX9wY2IqW2fj";
    }

    public static void main(String[] args) throws Exception {
	new NamexTweet().start();
    }
}