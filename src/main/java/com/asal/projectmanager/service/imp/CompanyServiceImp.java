package com.asal.projectmanager.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.dao.CompanyDao;
import com.asal.projectmanager.domain.Company;
import com.asal.projectmanager.service.CompanyService;

@Service
public class CompanyServiceImp implements CompanyService {

	@Autowired
	CompanyDao companyDao;
	
	@Transactional
	public void add(Company company) {
		companyDao.save(company);
	}

	@Transactional
	public List<Company> findAll() {
		return companyDao.findAll();
	}

	@Transactional
	public Company findById(Long id) {
		return companyDao.findOne(id);
	}

	@Transactional
	public void remove(Company company) {
		companyDao.delete(company);
		
	}

	@Transactional
	public void update(Company company) {
		companyDao.update(company);
	}

	@Transactional
	public Long count() {
		return companyDao.count();
	}

}
