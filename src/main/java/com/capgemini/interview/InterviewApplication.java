
package com.capgemini.interview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@SpringBootApplication
@RestController
public class InterviewApplication {
	public static void main(String[] args) {
		SpringApplication.run(InterviewApplication.class, args);
	}

	private ApplianceResource applianceData;

	public InterviewApplication() {
		this.applianceData = new ApplianceResource();
	}

	/* Get all appliances */
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(value = "/appliance/list")
	public ResponseEntity<ArrayList<Appliance>> getApplianceList() {
		return new ResponseEntity<>(this.applianceData.getApplianceList(), HttpStatus.OK);
	}

	/* Create a new appliance */
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping(value = "/appliance", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Appliance>  createAppliance(@RequestBody Appliance appliance) {
		this.applianceData.add(appliance);
		return new ResponseEntity<>(appliance, HttpStatus.OK);
	}

	/* Update an existing appliance */
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping(value = "/appliance", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Appliance>  updateAppliance(@RequestParam("id") String id, @RequestBody Appliance body) {
		Appliance updated = this.applianceData.update(id, body);
		return new ResponseEntity<>(updated, HttpStatus.OK);
	}

	/* Delete an existing appliance */
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping(value = "/appliance")
	public ResponseEntity<String> deleteAppliance(@RequestParam("id") String id) {
		this.applianceData.remove(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
