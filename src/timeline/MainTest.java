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
 * @author Khandaa
 */
public class MainTest {
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

         System.out.println("User,Text,Lang,Source,CreatedAt,CurrentUserRetweetId,"
                 + "FavoriteCount,GeoLocation,Id,InReplyToScreenName,InReplyToStatusId,InReplyToUserId,"
                 + "Place,QuotedStatus,QuotedStatusId,RetweetCount");
         
        for(Status st : status) {
            // Field Guide - https://dev.twitter.com/overview/api/tweets
            System.out.print(st.getUser().getName());
            System.out.print(";");
            System.out.print(st.getText());
            System.out.print(";");
            System.out.print(st.getLang());
            System.out.print(";");
            System.out.print(st.getSource());
            System.out.print(";");
            System.out.print(st.getCreatedAt()); 
            System.out.print(";");
            System.out.print(st.getCurrentUserRetweetId()); 
            System.out.print(";");
            System.out.print(st.getFavoriteCount()); 
            System.out.print(";");
            System.out.print(st.getGeoLocation());
            System.out.print(";");
            System.out.print(st.getId());
            System.out.print(";");
            System.out.print(st.getInReplyToScreenName()); 
            System.out.print(";");
            System.out.print(st.getInReplyToStatusId()); 
            System.out.print(";");
            System.out.print(st.getInReplyToUserId()); 
            System.out.print(";");
            System.out.print(st.getPlace()); 
            System.out.print(";");
            System.out.print(st.getQuotedStatus()); 
            System.out.print(";");
            System.out.print(st.getQuotedStatusId()); 
            System.out.print(";");
            System.out.print(st.getRetweetCount()); 
            System.out.println("");
        }
        
    }

}