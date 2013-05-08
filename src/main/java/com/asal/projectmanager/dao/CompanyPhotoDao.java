package com.asal.projectmanager.dao;

import java.io.File;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.asal.projectmanager.domain.Company;
import com.asal.projectmanager.domain.CompanyPhoto;

public interface CompanyPhotoDao extends Dao<CompanyPhoto> {
	
	public void addPhoto(Company company, MultipartFile file);
	
	public void addThumbNail(CompanyPhoto companyPhoto, File file);

	public List<CompanyPhoto> listPhoto();

	public void removePhoto(Long id);

	public CompanyPhoto getPhoto(Long id);

	public void updatePhoto(CompanyPhoto photo);
	
	public CompanyPhoto getPhoto(String name);
	
	public Long getProfilePhotoId(Company company);

	public List<CompanyPhoto> findByCompany(Company company);
	public CompanyPhoto findOneByCompany(Company company);


}
