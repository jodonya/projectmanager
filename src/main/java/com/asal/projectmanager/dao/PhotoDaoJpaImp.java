package com.asal.projectmanager.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.engine.jdbc.LobCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.asal.projectmanager.domain.Photo;
import com.asal.projectmanager.web.controller.ProjectManagerSession;

@Repository
@Transactional
public class PhotoDaoJpaImp extends AbstractJpaDao<Photo> implements PhotoDao {
	
	protected static Logger logger = Logger.getLogger(PhotoDaoJpaImp.class);
	
	@Autowired
	ProjectManagerSession projectManagerSession;
	
	
	public PhotoDaoJpaImp(){
		setClazz(Photo.class);
		setProjectManagerSession(projectManagerSession);
	}
	

	@Transactional
	public void addPhoto(MultipartFile file) {
		//String photoName = file.getOriginalFilename();
		Photo photo = new Photo();
		Blob blob =  null;
		photo.setName(file.getOriginalFilename());
		photo.setContentType(file.getContentType());
		photo.setLength((int)file.getSize());
		
		//LobCreator lobCreator = entityManager.getEntityManagerFactory()
		Session session = (Session)entityManager.getDelegate();
		try {
			LobCreator lobCreator = Hibernate.getLobCreator(session);
			blob = lobCreator.createBlob(file.getInputStream(), file.getSize());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		photo.setCreatedBy(projectManagerSession.getUser());
		photo.setCreated(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		
		photo.setContent(blob);
		
		session.save(photo);
		session.flush();
	//	session.
		
		//photo = this.
		
		
	}
	
	@Transactional
	public void addThumbNail(Photo photo, File file){
		Blob blob = null;
		Session session = (Session)entityManager.getDelegate();
		
		InputStream thumbnailInputStream = null;
		try {
			thumbnailInputStream = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		LobCreator lobCreator = Hibernate.getLobCreator(session);
		blob = lobCreator.createBlob(thumbnailInputStream, file.length());
		
		photo.setThumbLength(file.length());
		
		
		photo.setThumbNailContent(blob);
		session.update(photo);
		session.flush();
		
	}

	public List<Photo> listPhoto() {
		logger.info("Created by "+projectManagerSession.getUser().getFirstName());
		return super.entityManager.createQuery(" from Photo p WHERE p.createdBy.id="+projectManagerSession.getUser().getId()+"  ORDER BY p.id DESC ").getResultList();
	}

	public void removePhoto(Long id) {
		deleteById(id);
	}

	public Photo getPhoto(Long id) {
		return findOne(id);
	}

	@Transactional
	public void updatePhoto(Photo photo) {
		Session session = (Session)entityManager.getDelegate();
		
		photo.setUpdatedBy(projectManagerSession.getUser());
		photo.setUpdated(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		session.saveOrUpdate(photo);
	}


	@Transactional
	public Photo getPhoto(String name) {
		// TODO Auto-generated method stub
		Photo photo = null;
		Query q = entityManager.createQuery("SELECT p FROM Photo p WHERE p.name = :name");// "SELECT p FROM Photo p WHERE p.name = :name";
		q.setParameter("name", name);
		
		if (!q.getResultList().isEmpty())
			photo =  (Photo)q.getResultList().get(0);
		return photo;
	}


	@Transactional
	public Long getProfilePhotoId(Long userId) {
		Photo photo = null;
		Query q = entityManager.createQuery("SELECT p FROM Photo p WHERE p.createdBy = :userId and p.isProfilePhoto = true");// "SELECT p FROM Photo p WHERE p.name = :name";
		q.setParameter("userId", userId);
		
		Long profilePhotoId = null;
		if (!q.getResultList().isEmpty())
		{
			photo =  (Photo)q.getResultList().get(0);
			profilePhotoId = photo.getId();
		}
		
		
		return profilePhotoId;
	}

}
