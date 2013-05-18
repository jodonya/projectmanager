package com.asal.projectmanager.service;

import com.asal.projectmanager.domain.Company;

public interface CompanyService extends AdvertBaseService<Company> {
	public Company findCompany(String name);

}
