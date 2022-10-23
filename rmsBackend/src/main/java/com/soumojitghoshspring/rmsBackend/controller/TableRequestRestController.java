package com.soumojitghoshspring.rmsBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import com.soumojitghoshspring.rmsBackend.entity.TableRequest;
import com.soumojitghoshspring.rmsBackend.service.intrface.TableRequestService;

@RestController
@RequestMapping("/api")
public class TableRequestRestController {

	@Autowired
	private TableRequestService requestService;
	
	@GetMapping("/table-requests")
	public List<TableRequest> findAll(){
		return requestService.getAll();
	}
	
	@GetMapping("/table-requests/{tableRequestId}")
	public TableRequest get(@PathVariable int tableRequestId) {
		return requestService.get(tableRequestId);
	}
	
	@PostMapping("/table-requests")
	public ResponseEntity<TableRequest> save(@RequestBody TableRequest tableRequest) {
		requestService.save(tableRequest);
		return new ResponseEntity<>(tableRequest,HttpStatus.OK);
	}
	
	@PutMapping("/table-requests")
	public ResponseEntity<TableRequest> update(@RequestBody TableRequest tableRequest) {
		requestService.save(tableRequest);
		return new ResponseEntity<>(tableRequest,HttpStatus.OK);
	}
	
	@DeleteMapping("/table-requests/{tableRequestId}")
	public ResponseEntity<String> delete(@PathVariable int tableRequestId) {
		requestService.delete(tableRequestId);
		return new ResponseEntity<>("Table request deleted for id:"+tableRequestId,HttpStatus.OK);
	}
	
}
