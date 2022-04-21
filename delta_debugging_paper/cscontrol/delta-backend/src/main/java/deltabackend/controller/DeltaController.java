package deltabackend.controller;

import deltabackend.domain.api.request.DeltaNodeRequest;
import deltabackend.domain.api.response.DeltaNodeByListResponse;
import deltabackend.domain.configDelta.ConfigDeltaRequest;
import deltabackend.domain.instanceDelta.DeltaRequest;
import deltabackend.domain.instanceDelta.SimpleInstanceRequest;
import deltabackend.domain.mixerDelta.MixerDeltaRequest;
import deltabackend.domain.nodeDelta.NodeDeltaRequest;
import deltabackend.domain.sequenceDelta.SequenceDeltaRequest;
import deltabackend.domain.serviceDelta.ExtractServiceRequest;
import deltabackend.domain.serviceDelta.ReserveServiceResponse;
import deltabackend.domain.serviceDelta.ServiceDeltaRequest;
import deltabackend.service.DeltaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.*;

@RestController
public class DeltaController {

    @Autowired
    private DeltaService deltaService;

    @CrossOrigin(origins = "*")
    @RequestMapping(value="/welcome", method = RequestMethod.GET)
    public String welcome() {
        return "Hello, Welcome!";
    }

    @MessageMapping("/msg/delta")
    public void delta(DeltaRequest message) throws Exception {
        deltaService.delta(message);
    }

    @MessageMapping("/msg/simpleSetInstance")
    public void simpleSetInstance(SimpleInstanceRequest message) throws Exception {
        deltaService.simpleSetInstance(message);
    }

    //////////////////////////////////////// Delta Service ////////////////////////////////////////
    @MessageMapping("/msg/serviceDelta")
    public void serviceDelta(ServiceDeltaRequest message) throws Exception {
        deltaService.serviceDelta(message);
    }

    //////////////////////////////////////// Delta Node ////////////////////////////////////////
    @MessageMapping("/msg/nodeDelta")
    public void nodeDelta(NodeDeltaRequest message) throws Exception {
        deltaService.nodeDelta(message);
    }

    @MessageMapping("/msg/configDelta")
    public void configDelta(ConfigDeltaRequest message) throws Exception {
        deltaService.configDelta(message);
    }

    @MessageMapping("/msg/simpleSetOrignal")
    public void simpleSetOrignal(ConfigDeltaRequest message) throws Exception {
        deltaService.simpleSetOrignal(message);
    }

    ///////////////////////////// Delta Sequence ///////////////////////////////////
    @MessageMapping("/msg/sequenceDelta")
    public void sequenceDelta(SequenceDeltaRequest message) throws Exception {
        deltaService.sequenceDelta(message);
    }

    ///////////////////////////// Delta Mixer ///////////////////////////////////
    @MessageMapping("/msg/mixerDelta")
    public void mixerDelta(MixerDeltaRequest message) throws Exception {
        deltaService.mixerDelta(message);
    }
}
