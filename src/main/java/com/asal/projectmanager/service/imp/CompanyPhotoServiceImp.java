package com.asal.projectmanager.service.imp;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.asal.projectmanager.dao.CompanyPhotoDao;
import com.asal.projectmanager.domain.Company;
import com.asal.projectmanager.domain.CompanyPhoto;
import com.asal.projectmanager.service.CompanyPhotoService;

@Service
public class CompanyPhotoServiceImp implements CompanyPhotoService {
	
	@Autowired
	CompanyPhotoDao companyPhotoDao;

	@Transactional
	public void add(CompanyPhoto photo) {
		companyPhotoDao.save(photo);
	}

	@Transactional
	public List<CompanyPhoto> findAll() {
		return companyPhotoDao.findAll();
	}

	@Transactional
	public CompanyPhoto findById(Long id) {
		return companyPhotoDao.findOne(id);
	}

	@Transactional
	public void remove(CompanyPhoto photo) {
		companyPhotoDao.delete(photo);
	}

	@Transactional
	public void update(CompanyPhoto photo) {
		companyPhotoDao.update(photo);
	}

	@Transactional
	public Long count() {
		return companyPhotoDao.count();
	}

	@Transactional
	public List<CompanyPhoto> findByCompany(Company company) {
		return companyPhotoDao.findByCompany(company);
	}

	@Transactional
	public CompanyPhoto findOneByCompany(Company company) {
		return companyPhotoDao.findOneByCompany(company);
	}
	
	/***
	 * From Photo Service
	 * **/

	@Transactional
	public void addThumbNail(CompanyPhoto photo, File file) {
		companyPhotoDao.addThumbNail(photo, file);
	}

	@Transactional
	public List<CompanyPhoto> listPhoto() {
		return companyPhotoDao.listPhoto();
	}

	@Transactional
	public void removePhoto(Long id) {
		companyPhotoDao.removePhoto(id);
	}

	@Transactional
	public CompanyPhoto getPhoto(Long id) {
		return companyPhotoDao.getPhoto(id);
	}

	@Transactional
	public CompanyPhoto getPhoto(String name) {
		return companyPhotoDao.getPhoto(name);
	}

	@Transactional
	public void updatePhoto(CompanyPhoto photo) {
		companyPhotoDao.update(photo);
	}

	@Transactional
	public Long getProfilePhotoId(Company company) {
		return companyPhotoDao.getProfilePhotoId(company);
	}

	@Transactional
	public void addPhoto(Company company, MultipartFile file) {
		companyPhotoDao.addPhoto(company, file);
	}

}
