package com.asal.projectmanager.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.asal.projectmanager.dao.PhotoDao;
import com.asal.projectmanager.domain.Photo;

@Service
@Transactional
public class PhotoServiceImp implements PhotoService {

	@Autowired
	PhotoDao photoDao;

	@Transactional
	public void addPhoto(MultipartFile file) {
		photoDao.addPhoto(file);
	}

	@Transactional
	public List<Photo> listPhoto() {
		return photoDao.listPhoto();
	}

	@Transactional
	public void removePhoto(Long id) {
		photoDao.removePhoto(id);
	}

	public Photo getPhoto(Long id) {
		return photoDao.getPhoto(id);
	}

	@Transactional
	public void updatePhoto(Photo photo) {
		photoDao.updatePhoto(photo);
	}

	public Photo getPhoto(String name) {
		return photoDao.getPhoto(name);
	}

	public void addThumbNail(Photo photo, File file) {
		photoDao.addThumbNail(photo, file);
	}

	public Long getProfilePhotoId(Long userId) {
		return photoDao.getProfilePhotoId(userId);
	}

}
