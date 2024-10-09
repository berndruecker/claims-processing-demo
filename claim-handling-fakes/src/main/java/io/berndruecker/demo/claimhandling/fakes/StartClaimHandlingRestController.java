package io.berndruecker.demo.claimhandling.fakes;

import java.util.HashMap;

import io.camunda.zeebe.client.api.response.ProcessInstanceEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;

import io.camunda.zeebe.client.ZeebeClient;

@RestController
public class StartClaimHandlingRestController {

  @Autowired
  private ZeebeClient client;

  //@Value("${recipient.demo.email}")
  //private String recipientDemoEmail;

  @Value("${operate.base.url}")
  private String operateBaseUrl;

  @PutMapping("/claim")
  public ResponseEntity<String> startClaimHandling() {
    long processInstanceKey = startProcessInstance();
    String operateUrl = operateBaseUrl + processInstanceKey;
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(operateUrl);
  }

  public long startProcessInstance() {
    HashMap<String, Object> variables = new HashMap<String, Object>();
    //variables.put("automaticProcessing", true);
    //variables.put("someInput", "yeah");
    //variables.put("customerName", "Bernd Ruecker");
    //variables.put("customerEmail", recipientDemoEmail);

    ProcessInstanceEvent processClaimHandling = client.newCreateInstanceCommand() //
            .bpmnProcessId("processClaimHandling") //
            .latestVersion() //
            .variables(variables) //
            .send().join();

    return processClaimHandling.getProcessInstanceKey();
  }

  public static class CustomerOnboardingResponse {
  }
}
