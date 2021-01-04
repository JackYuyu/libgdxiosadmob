package com.mygdx.game;


import java.util.Arrays;

import org.robovm.apple.uikit.UIApplication;
import org.robovm.objc.annotation.CustomClass;
import org.robovm.pods.google.mobileads.*;

@CustomClass("ViewController")
public class ViewController implements AdsDisplayInterface {
 private GADInterstitial interstitial;
 
 private GADInterstitial createAndLoadInterstitial() {
     //Ad Unit ID of your interstital, from your adMob account. Use the TEST one for now
     GADInterstitial interstitial = new GADInterstitial("ca-app-pub-1646290229432780/6391598788");
     interstitial.setDelegate(new GADInterstitialDelegateAdapter() {
         @Override
         public void didDismissScreen(GADInterstitial ad) {
             ViewController.this.interstitial = createAndLoadInterstitial();
         }
     });
     interstitial.loadRequest(createRequest());
     return interstitial;
 }
 
 private GADRequest createRequest() {
     GADRequest request = new GADRequest();
     // To test on your devices, add their UDIDs here:
//     request.setTestDevices(Arrays.asList(GADRequest.getSimulatorID()));
     return request;
 }
 
 @Override
 public void loadAds() {
     interstitial = createAndLoadInterstitial();
 }
 
 @Override
 public void showAds() {
     if (interstitial.isReady()) {
         interstitial.present(UIApplication.getSharedApplication().getKeyWindow().getRootViewController());
     } else {
         System.out.println("Interstitial not ready!");
     }
 }
 
}