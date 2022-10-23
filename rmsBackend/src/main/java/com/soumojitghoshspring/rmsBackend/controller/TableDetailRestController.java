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

import com.soumojitghoshspring.rmsBackend.entity.TableDetail;
import com.soumojitghoshspring.rmsBackend.service.intrface.TableDetailService;

@RestController
@RequestMapping("/api")
public class TableDetailRestController {

	@Autowired
	private TableDetailService tableDetailService;
	
	@GetMapping("/table-details")
	public List<TableDetail> getAll(){
		List<TableDetail> tableDetails = tableDetailService.getAll();
		
		return tableDetails;
	}
	
	@GetMapping("/table-details/{tableDetailId}")
	public TableDetail get(@PathVariable int tableDetailId) {
		TableDetail tableDetail = tableDetailService.get(tableDetailId);
		return tableDetail;
	}
	
	@PostMapping("/table-details")
	public ResponseEntity<TableDetail> save(@RequestBody TableDetail tableDetail) {
		tableDetailService.save(tableDetail);
		return new ResponseEntity<>(tableDetail,HttpStatus.OK);
	}
	
	@PutMapping("/table-details")
	public ResponseEntity<TableDetail> update(@RequestBody TableDetail tableDetail) {
		tableDetailService.save(tableDetail);
		return new ResponseEntity<>(tableDetail,HttpStatus.OK);
	}
	
	@DeleteMapping("/table-details/{tableDetailId}")
	public ResponseEntity<String> delete(@PathVariable int tableDetailId){
		tableDetailService.delete(tableDetailId);
		return new ResponseEntity<>("Table detail deleted with id:"+tableDetailId,HttpStatus.OK);
	}
}
