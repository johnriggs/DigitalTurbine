package com.johnriggs.digitalturbine;

import com.johnriggs.digitalturbine.horizontal.model.Ad;
import com.johnriggs.digitalturbine.vertical.ads.presenter.AdsPresenter;
import com.johnriggs.digitalturbine.vertical.ads.presenter.AdsPresenterImpl;
import com.johnriggs.digitalturbine.vertical.ads.repository.AdsRepository;
import com.johnriggs.digitalturbine.vertical.ads.view.AdsView;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import rx.subjects.PublishSubject;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by johnriggs on 7/28/17.
 */

public class AdsPresenterTest {
    AdsRepository mockRepo;
    AdsView mockView;
    AdsPresenter presenter;

    List<Ad> testAds = new ArrayList<>();
    Ad testAd = new Ad();
    PublishSubject<List<Ad>> testSubject = PublishSubject.create();

    @Before
    public void setup() {
        mockRepo = mock(AdsRepository.class);
        mockView = mock(AdsView.class);

        when(mockRepo.getAdsReceivedSubject()).thenReturn(testSubject);

        presenter = new AdsPresenterImpl(mockRepo);
    }

    @Test
    public void setViewShouldRequestsAdsFromRepo() {
        presenter.setView(mockView);
        verify(mockRepo, times(1)).getAdsFromApi();
    }

    @Test
    public void shouldHandleAdsWhenReceived() {
        presenter.setView(mockView);
        presenter.onAdsReceived(testAds);
        verify(mockRepo, times(1)).saveAdsToRealm(testAds);
        verify(mockView, times(1)).setupAdsRecyclerView();
    }

    @Test
    public void shouldLaunchActivityWhenAdClicked() {
        presenter.setView(mockView);
        presenter.onAdsListItemClicked(testAd);
        verify(mockView, times(1)).launchToDetailsView(testAd.getAppId());
    }

    @Test
    public void verifyAdsNotNullWhenRequested(){
        presenter.setView(mockView);
        presenter.onAdsReceived(testAds);
        assert(presenter.getAdsList() != null);
    }

    @Test
    public void verifyPublishSubjectNotNullWhenRequested(){
        presenter.setView(mockView);
        assert(presenter.getAdsReceivedSubject() != null);
    }
}
