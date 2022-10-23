package com.soumojitghoshspring.rmsBackend.service.intrface;

import java.util.List;

import com.soumojitghoshspring.rmsBackend.entity.TableRequest;

public interface TableRequestService {

	public List<TableRequest> getAll();

	public TableRequest get(int tableRequestId);

	public void save(TableRequest tableRequest);

	public void delete(int tableRequestId);

}
