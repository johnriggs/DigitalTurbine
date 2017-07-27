package com.johnriggs.digitalturbine.horizontal.controllers;

import com.johnriggs.digitalturbine.horizontal.model.Ad;

import java.util.List;

import rx.subjects.PublishSubject;

/**
 * Created by johnriggs on 7/27/17.
 */

public class RxController {
    private static RxController controller;

    private PublishSubject<List<Ad>> adsReceivedSubject;

    private RxController(){
        adsReceivedSubject = PublishSubject.create();
    }

    public static RxController getController(){
        if (controller == null){
            controller = new RxController();
        }

        return controller;
    }

    public PublishSubject<List<Ad>> getAdsReceivedSubject() {
        return adsReceivedSubject;
    }

    public void notifyAdsReceived(List<Ad> ads){
        adsReceivedSubject.onNext(ads);
    }
}
