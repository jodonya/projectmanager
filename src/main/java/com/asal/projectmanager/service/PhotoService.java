package com.asal.projectmanager.service;

import java.io.File;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.asal.projectmanager.domain.Photo;

public interface PhotoService {
	
	public void addPhoto(MultipartFile file);
	
	public void addThumbNail(Photo photo, File file);

	public List<Photo> listPhoto();

	public void removePhoto(Long id);

	public Photo getPhoto(Long id);

	public Photo getPhoto(String name);

	public void updatePhoto(Photo photo);
	
	public Long getProfilePhotoId(Long userId);

}
