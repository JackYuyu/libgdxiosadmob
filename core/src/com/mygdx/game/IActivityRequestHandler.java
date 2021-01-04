package com.mygdx.game;

public interface IActivityRequestHandler {
	void hideBanner();
    void showBanner();
    void showInterstitial();
    void showAds(boolean show);
    void initAds();
}
