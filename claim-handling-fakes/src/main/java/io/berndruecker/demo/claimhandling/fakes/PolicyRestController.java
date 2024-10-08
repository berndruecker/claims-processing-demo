package io.berndruecker.demo.claimhandling.fakes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Random;

@RestController
public class PolicyRestController {

    public long policyNumber = new Random().nextLong(99999999l);

    @GetMapping("/policy/{policyId}")
    public Policy findPolicy(@PathVariable String policyId) {
        return new Policy().setId(policyId).setCustomerId("17100002").setCoverageType("EXTENDED").setStartDate(new Date()).setMuchMoreInformation("Yes - that would indeed be helpful :-)");
    }

    @GetMapping("/policy/newNumber")
    public String generatePolicyNumber() {
        String generatedPolicyNumber = String.valueOf(policyNumber++);
        System.out.println("NEW POLICY NUMBER: " + generatedPolicyNumber);
        return generatedPolicyNumber;
    }
}
