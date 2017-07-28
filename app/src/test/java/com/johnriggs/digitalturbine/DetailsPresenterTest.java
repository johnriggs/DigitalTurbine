package com.johnriggs.digitalturbine;

import com.johnriggs.digitalturbine.horizontal.utils.JsonToListHelper;
import com.johnriggs.digitalturbine.vertical.details.model.DetailItem;
import com.johnriggs.digitalturbine.vertical.details.presenter.DetailsPresenter;
import com.johnriggs.digitalturbine.vertical.details.presenter.DetailsPresenterImpl;
import com.johnriggs.digitalturbine.vertical.details.repository.DetailsRepository;
import com.johnriggs.digitalturbine.vertical.details.view.DetailsView;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by johnriggs on 7/28/17.
 */

public class DetailsPresenterTest {
    DetailsRepository mockRepo;
    DetailsView mockView;
    DetailsPresenter presenter;
    static JsonToListHelper mockHelper;

    List<DetailItem> testDetails = new ArrayList<>();
    String testAppId = "testAppId";

    @Before
    public void setup() {
        mockRepo = mock(DetailsRepository.class);
        mockView = mock(DetailsView.class);
        mockHelper = mock(JsonToListHelper.class);

        when(mockRepo.getDetailItems(testAppId)).thenReturn(testDetails);

        presenter = new DetailsPresenterImpl(mockRepo);
    }

    @Test
    public void setAppIdShouldSetRecyclerView() {
        presenter.setView(mockView);
        presenter.setAppId(testAppId);
        verify(mockView, times(1)).setupAdsRecyclerView();
    }

    @Test
    public void verifyDetailsItemsNotNullWhenRequested() {
        presenter.setView(mockView);
        presenter.setAppId(testAppId);
        assert(presenter.getDetailItems() != null);
    }
}
