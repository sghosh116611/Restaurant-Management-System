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

import com.soumojitghoshspring.rmsBackend.entity.TableBook;
import com.soumojitghoshspring.rmsBackend.service.intrface.TableBookService;

@RestController
@RequestMapping("/api")
public class TableBookController {

	@Autowired
	private TableBookService tableBookService;

	@GetMapping("/table-books")
	public List<TableBook> getAll() {
		return tableBookService.getAll();
	}

	@GetMapping("/table-books/{tableBookId}")
	public TableBook get(@PathVariable int tableBookId) {
		return tableBookService.get(tableBookId);
	}

	@PostMapping("/table-books")
	public ResponseEntity<TableBook> save(@RequestBody TableBook tableBook) {
		tableBookService.save(tableBook);

		return new ResponseEntity<>(tableBook, HttpStatus.OK);
	}
	
	@PutMapping("/table-books")
	public ResponseEntity<TableBook> update(@RequestBody TableBook tableBook) {
		tableBookService.save(tableBook);

		return new ResponseEntity<>(tableBook, HttpStatus.OK);
	}
	
	@DeleteMapping("/table-books/{tableBookId}")
	public ResponseEntity<String> delete(@PathVariable int tableBookId)
	{
		tableBookService.delete(tableBookId);

		return new ResponseEntity<>("Table Book deleted with id:" + tableBookId, HttpStatus.OK);
	}
	

}
