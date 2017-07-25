/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline;

import java.util.Arrays;
import java.util.List;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author 985892
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws TwitterException {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
            .setOAuthConsumerKey("maGjE9qB3RTWWXvdrJYQcOKnK")
            .setOAuthConsumerSecret("4zTIgEO7gsPyS9EirBWPvCjoLyjYxPWO77k3gFYIdvV6BlcBk4")
            .setOAuthAccessToken("48235933-PfKSaIMnNYqWkiBVwvqSaebkCovIkWxar9XYyr5xv")
            .setOAuthAccessTokenSecret("tfSKcMsJiOBuxMZNqdTdtKYfcq9ZWTD7iimkCxEnTisRF");

        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter4j.Twitter twitter  = tf.getInstance();
        List<Status> status = twitter.getHomeTimeline();

        for(Status st : status) {
            // Field Guide - https://dev.twitter.com/overview/api/tweets
            System.out.println("User: " + st.getUser().getName());
            System.out.println("Text: " + st.getText());
            System.out.println("Lang: " + st.getLang());
            System.out.println("Source: " + st.getSource());
            System.out.println("Scope: " + Arrays.asList(st.getScopes())); 
            System.out.println("Contributors: " + Arrays.asList(st.getContributors())); 
            System.out.println("CreatedAt: " + st.getCreatedAt()); 
            System.out.println("CurrentUserRetweetId: " + st.getCurrentUserRetweetId()); 
            System.out.println("FavoriteCount: " + st.getFavoriteCount()); 
            System.out.println("GeoLocation: " + st.getGeoLocation()); 
            System.out.println("Id: " + st.getId()); 
            System.out.println("InReplyToScreenName: " + st.getInReplyToScreenName()); 
            System.out.println("InReplyToStatusId: " + st.getInReplyToStatusId()); 
            System.out.println("InReplyToUserId: " + st.getInReplyToUserId()); 
            System.out.println("Place: " + st.getPlace()); 
            System.out.println("QuotedStatus: " + st.getQuotedStatus()); 
            System.out.println("QuotedStatusId: " + st.getQuotedStatusId()); 
            System.out.println("RetweetCount: " + st.getRetweetCount()); 
            System.out.println("RetweetedStatus: " + st.getRetweetedStatus()); 
            System.out.println("Scopes[]: " + Arrays.asList(st.getScopes())); 
            System.out.println("WithheldInCountries[]: " + st.getWithheldInCountries()); 
            System.out.println("---------------------------------------------");
        }
        
    }
    
}
