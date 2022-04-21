package apiserver.async;
import org.springframework.scheduling.annotation.Async;

import org.springframework.stereotype.Component;
import apiserver.request.SetAsyncRequestSequenceRequestWithSource;
import apiserver.response.SetAsyncRequestSequenceResponse;
import apiserver.service.ApiService;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.beans.factory.annotation.Autowired;
import apiserver.request.SetAsyncRequestSequenceRequestWithSource;
import java.util.concurrent.Future;

@Component  
public class AsyncTask {

    @Autowired
    private ApiService asv;

    @Async("myAsync")
    public Future<SetAsyncRequestSequenceResponse> doAsync(SetAsyncRequestSequenceRequestWithSource request) throws InterruptedException {
        SetAsyncRequestSequenceResponse r = asv.setAsyncRequestsSequenceWithSource(request);
        return new AsyncResult<>(r);
    }
}  
