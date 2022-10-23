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

import com.soumojitghoshspring.rmsBackend.entity.TableType;
import com.soumojitghoshspring.rmsBackend.service.intrface.TableTypeService;

@RestController
@RequestMapping("/api")
public class TableTypeRestController {

	@Autowired
	TableTypeService tableTypeService;
	
	@GetMapping("/table-types")
	public List<TableType> getAll(){
		return tableTypeService.getAll();
	}
	
	@GetMapping("/table-types/{tableTypeId}")
	public TableType get(@PathVariable int tableTypeId) {
		TableType tableType = tableTypeService.get(tableTypeId);
		
		return tableType;
	}
	
	@PostMapping("/table-types")
	public ResponseEntity<TableType> save(@RequestBody TableType tableType) {
		tableTypeService.save(tableType);
		
		return new ResponseEntity<>(tableType,HttpStatus.OK);
	}
	
	@PutMapping("/table-types")
	public ResponseEntity<TableType> update(@RequestBody TableType tableType) {
		tableTypeService.save(tableType);
		
		return new ResponseEntity<>(tableType,HttpStatus.OK);
	}
	
	@DeleteMapping("/table-types/{tableTypeId}")
	public ResponseEntity<String> delete(@PathVariable int tableTypeId) {
		tableTypeService.delete(tableTypeId);
		
		return new ResponseEntity<>("Table type deleted with id:"+tableTypeId,HttpStatus.OK);
	}
	
}
