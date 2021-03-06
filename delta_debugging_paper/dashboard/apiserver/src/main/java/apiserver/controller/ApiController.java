package apiserver.controller;

import apiserver.response.SetUnsetServiceRequestSuspendResponse;
import apiserver.request.*;
import apiserver.response.*;
import apiserver.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApiController {

    @Autowired
    private ApiService apiv;

    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/hello", method= RequestMethod.GET)
    public String hello(){
        return "hello api-server";
    }

    //Get the available clusters
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/getClusters", method= RequestMethod.GET)
    public GetClustersResponse getClusters(){
        return apiv.getClusters();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/setServiceRequestSuspend", method= RequestMethod.POST)
    public SetUnsetServiceRequestSuspendResponse setServiceRequestSuspend(
            @RequestBody SetUnsetServiceRequestSuspendRequest request){

        System.out.println("[=====] /api/setServiceRequestSuspend");
        System.out.println("[=====] svcName:" + request.getSvc());

        return apiv.setServiceRequestSuspend(request);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/setServiceRequestSuspendWithSourceSvc", method= RequestMethod.POST)
    public SetUnsetServiceRequestSuspendResponse setServiceRequestSuspendWithSourceSvc(
            @RequestBody SetUnsetServiceRequestSuspendRequest request){

        System.out.println("[=====] /api/setServiceRequestSuspendWithSourceSvc");
        System.out.println("[=====] svcName:" + request.getSvc());
        System.out.println("[=====] sourceSvcName:" + request.getSourceSvcName());

        return apiv.setServiceRequestSuspendWithSource(request);
    }


    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/unsetServiceRequestSuspend", method= RequestMethod.POST)
    public SetUnsetServiceRequestSuspendResponse unsetServiceRequestSuspend(
            @RequestBody SetUnsetServiceRequestSuspendRequest request){

        System.out.println("[=====] /api/unsetServiceRequestSuspend");
        System.out.println("[=====] svcName:" + request.getSvc());

        return apiv.unsetServiceRequestSuspend(request);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/setAsyncRequestSequence", method= RequestMethod.POST)
    public SetAsyncRequestSequenceResponse setAsyncRequestSequenceResponse(
            @RequestBody SetAsyncRequestSequenceRequest request){

        System.out.println("[=====] /api/setAsyncRequestSequence");
        System.out.println("[=====] svc Number:" + request.getSvcList().size());

        return apiv.setAsyncRequestsSequence(request);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/setAsyncRequestSequenceWithSrc", method = RequestMethod.POST)
    public SetAsyncRequestSequenceResponse setAsyncRequestSequenceResponseWithSrc(
            @RequestBody SetAsyncRequestSequenceRequestWithSource request){

        System.out.println("[=====] /api/setAsyncRequestSequence");
        System.out.println("[=====] src Name:" + request.getSourceName());
        System.out.println("[=====] svc Name:" + request.getSvcList().size());

        return apiv.setAsyncRequestsSequenceWithSource(request);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/unsuspendAllRequests", method = RequestMethod.POST)
    public SetAsyncRequestSequenceResponse unsuspendAllRequests(
            @RequestBody SetAsyncRequestSequenceRequestWithSource request){

        System.out.println("[=====] /api/unsuspendAllRequests");
        System.out.println("[=====] src Name:" + request.getSourceName());
        System.out.println("[=====] svc Name:" + request.getSvcList().size());

        return apiv.unsuspendAllRequest(request);
    }


    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/setAsyncRequestSequenceWithSrcCombineWithFullSuspend", method = RequestMethod.POST)
    public SetAsyncRequestSequenceResponse setAsyncRequestSequenceWithSrcCombineWithFullSuspend(
            @RequestBody SetAsyncRequestSequenceRequestWithSource request){

        System.out.println("[=====] /api/setAsyncRequestSequenceWithSrcCombineWithFullSuspend");
        System.out.println("[=====] src Name:" + request.getSourceName());
        System.out.println("[=====] svc Name:" + request.getSvcList().size());

        return apiv.setAsyncRequestSequenceWithSrcCombineWithFullSuspend(request);
    }


    //Set the replicas of running service
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/setReplicas", method= RequestMethod.POST)
    public SetServiceReplicasResponse setServiceReplica(@RequestBody SetServiceReplicasRequest setServiceReplicasRequest){
        return apiv.setServiceReplica(setServiceReplicasRequest);
    }

    //Get the list of all current services: include name and replicas
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/getServicesList/{clusterName}", method= RequestMethod.GET)
    public GetServicesListResponse getServicesList(@PathVariable String clusterName){
        return apiv.getServicesList(clusterName);
    }

    //Get the service config: currently cpu and memory only
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/getServicesAndConfig/{clusterName}", method= RequestMethod.GET)
    public GetServicesAndConfigResponse getServicesAndConfig(@PathVariable String clusterName){
        return apiv.getServicesAndConfig(clusterName);
    }

    //Get the number of replicas of services
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/getServicesReplicas", method= RequestMethod.POST)
    public GetServiceReplicasResponse getServicesReplicas(@RequestBody GetServiceReplicasRequest getServiceReplicasRequest){
        return apiv.getServicesReplicas(getServiceReplicasRequest);
    }

    //Service delta: Reserve only the services contained in the list
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/reserveServiceByList", method= RequestMethod.POST)
    public ReserveServiceByListResponse reserveServiceByList(@RequestBody ReserveServiceRequest reserveServiceRequest){
        return apiv.reserveServiceByList(reserveServiceRequest);
    }

    //Node delta: Set to run on single node
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/runOnSingleNode/{clusterName}", method= RequestMethod.GET)
    public SetRunOnSingleNodeResponse setRunOnSingleNode(@PathVariable String clusterName){
        return apiv.setRunOnSingleNode(clusterName);
    }

    //Get the list of all current nodes info
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/getNodesList/{clusterName}", method= RequestMethod.GET)
    public GetNodesListResponse getNodesList(@PathVariable String clusterName){
        return apiv.getNodesList(clusterName);
    }

    //Delete the node in the list
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/deleteNodeByList", method= RequestMethod.POST)
    public DeltaNodeByListResponse deleteNodeByList(@RequestBody DeltaNodeRequest deltaNodeRequest){
        return apiv.deleteNodeByList(deltaNodeRequest);
    }

    //Reserve the node in the list
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/reserveNodeByList", method= RequestMethod.POST)
    public DeltaNodeByListResponse reserveNodeByList(@RequestBody DeltaNodeRequest deltaNodeRequest){
        return apiv.reserveNodeByList(deltaNodeRequest);
    }

    //Get the list of all current pods info
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/getPodsList/{clusterName}", method= RequestMethod.GET)
    public GetPodsListResponse getPodsList(@PathVariable String clusterName){
        return apiv.getPodsListAPI(clusterName);
    }

    //Get all of the log of current pods
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/getPodsLog/{clusterName}", method= RequestMethod.GET)
    public GetPodsLogResponse getPodsLog(@PathVariable String clusterName){
        return apiv.getPodsLog(clusterName);
    }

    //Get the log of the specific pod
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/getSinglePodLog", method= RequestMethod.POST)
    public GetSinglePodLogResponse getSinglePodLog(@RequestBody GetSinglePodLogRequest getSinglePodLogRequest){
        return apiv.getSinglePodLog(getSinglePodLogRequest);
    }

    //Restart the zipkin pod
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/restartService/{clusterName}", method= RequestMethod.GET)
    public RestartServiceResponse restartService(@PathVariable String clusterName){
        return apiv.restartService(clusterName);
    }

    //Config the container resource
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/deltaCMResource", method= RequestMethod.POST)
    public DeltaCMResourceResponse deltaCMResource(@RequestBody DeltaCMResourceRequest deltaCMResourceRequest){
        return apiv.deltaCMResource(deltaCMResourceRequest);
    }

    //Get the endpoints of all services
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/getServiceWithEndpoints/{clusterName}", method= RequestMethod.GET)
    public ServiceWithEndpointsResponse getServiceWithEndpoints(@PathVariable String clusterName){
        return apiv.getServiceWithEndpoints(clusterName);
    }

    //Get the endpoints of specific services
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/getSpecificServiceWithEndpoints", method= RequestMethod.POST)
    public ServiceWithEndpointsResponse getSpecificServiceWithEndpoints(@RequestBody ReserveServiceRequest reserveServiceRequest) {
        return apiv.getSpecificServiceWithEndpoints(reserveServiceRequest);
    }

    //Delta all: currently instance and config
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/deltaAll", method= RequestMethod.POST)
    public SimpleResponse deltaAll(@RequestBody DeltaAllRequest deltaAllRequest) {
        return apiv.deltaAll(deltaAllRequest);
    }
}
