package com.asal.projectmanager.service;

import java.io.File;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.asal.projectmanager.domain.Company;
import com.asal.projectmanager.domain.CompanyPhoto;

public interface CompanyPhotoService extends AdvertBaseService<CompanyPhoto> {
	
	
	public void addPhoto(Company company, MultipartFile file);
	
	public List<CompanyPhoto> findByCompany(Company company);
	public CompanyPhoto findOneByCompany(Company company);
	
	public void addThumbNail(CompanyPhoto photo, File file);

	public List<CompanyPhoto> listPhoto();

	public void removePhoto(Long id);

	public CompanyPhoto getPhoto(Long id);

	public CompanyPhoto getPhoto(String name);

	public void updatePhoto(CompanyPhoto photo);
	
	public Long getProfilePhotoId(Company company);


}
