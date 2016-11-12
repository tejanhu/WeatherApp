/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp.controller;

import winterwell.jtwitter.OAuthSignpostClient;
import static winterwell.jtwitter.OAuthSignpostClient.JTWITTER_OAUTH_KEY;
import static winterwell.jtwitter.OAuthSignpostClient.JTWITTER_OAUTH_SECRET;
import winterwell.jtwitter.Twitter;

/**
 *
 * @author LatinoWolofKid
 */
public class testing {
    private static Object client;

    public static void main(String[] args) {

        // Make an oauth client (you'll want to change this bit)
        OAuthSignpostClient oauthClient = new OAuthSignpostClient(JTWITTER_OAUTH_KEY,
                JTWITTER_OAUTH_SECRET, "oob");

        // Open the authorisation page in the user's browser. On a desktop, we can do that like this:
        oauthClient.authorizeDesktop();
// get the pin
        String v = oauthClient.askUser("Please enter the verification PIN from Twitter");
        oauthClient.setAuthorizationCode(v);
// Store the authorisation token details for future use
        String[] accessToken = client.getAccessToken();
// Next time we can use new OAuthSignpostClient(OAUTH_KEY, OAUTH_SECRET, 
//      accessToken[0], accessToken[1]) to avoid authenticating again.

// 2. Make a Twitter object
        Twitter twitter = new Twitter("my-name", oauthClient);
// Print Daniel Winterstein's status
        System.out.println(twitter.getStatus("winterstein"));
// Set my status
        twitter.setStatus("Messing about in Java");

    }

}
