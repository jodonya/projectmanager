package com.asal.projectmanager.daoimp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.engine.jdbc.LobCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.asal.projectmanager.dao.AbstractJpaDao;
import com.asal.projectmanager.dao.CompanyPhotoDao;
import com.asal.projectmanager.domain.Company;
import com.asal.projectmanager.domain.CompanyPhoto;
import com.asal.projectmanager.web.controller.ProjectManagerSession;

@Repository
public class CompanyPhotoDaoJpaImp extends AbstractJpaDao<CompanyPhoto>
		implements CompanyPhotoDao {
	
	@Autowired
	ProjectManagerSession projectManagerSession;
	
	protected static Logger logger = Logger.getLogger(CompanyPhotoDaoJpaImp.class);
	

	public CompanyPhotoDaoJpaImp(){
		setClazz(CompanyPhoto.class);
		setProjectManagerSession(projectManagerSession);
	}
	
	@Transactional
	public List<CompanyPhoto> findByCompany(Company company) {
		EntityManager em = super.entityManager;
		Query q = em
				.createQuery(" from CompanyPhoto cphoto WHERE (cphoto.company = :company) ORDER BY  id DESC ");// .getResultList();
		q.setParameter("company", company);
		return q.getResultList();
	}

	@Transactional
	public CompanyPhoto findOneByCompany(Company company) {
		CompanyPhoto photo = null;
		Query q = super.entityManager.createQuery(" SELECT photo from  CompanyPhoto photo WHERE (photo.company = :company) ");
		q.setParameter("company", company);
		
		if (!q.getResultList().isEmpty())
			photo = (CompanyPhoto)q.getResultList().get(0);
		
		return photo;
	}
	
	/***
	 * From True Photo
	 * **/
	
	@Transactional
	public void addPhoto(Company company, MultipartFile file) {
		//String photoName = file.getOriginalFilename();
		CompanyPhoto photo = new CompanyPhoto();
		Blob blob =  null;
		
		photo.setName(file.getOriginalFilename());
		photo.setContentType(file.getContentType());
		photo.setLength((int)file.getSize());
		photo.setDescription(company.getName()+" Profile Photo");
		photo.setCompany(company);
		
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
	public void addThumbNail(CompanyPhoto photo, File file){
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

	@Transactional
	public List<CompanyPhoto> listPhoto() {
		logger.info("Created by "+projectManagerSession.getUser().getFirstName());
		return super.entityManager.createQuery(" from CompanyPhoto cp   ORDER BY cp.id DESC ").getResultList();
	}

	public void removePhoto(Long id) {
		deleteById(id);
	}

	@Transactional
	public void updatePhoto(CompanyPhoto photo) {
		Session session = (Session)entityManager.getDelegate();
		
		photo.setUpdatedBy(projectManagerSession.getUser());
		photo.setUpdated(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		session.saveOrUpdate(photo);
	}


	@Transactional
	public CompanyPhoto getPhoto(String name) {
		// TODO Auto-generated method stub
		CompanyPhoto photo = null;
		Query q = entityManager.createQuery("SELECT cp FROM CompanyPhoto cp WHERE cp.name = :name");// "SELECT p FROM Photo p WHERE p.name = :name";
		q.setParameter("name", name);
		
		if (!q.getResultList().isEmpty())
			photo =  (CompanyPhoto)q.getResultList().get(0);
		return photo;
	}


	@Transactional
	public Long getProfilePhotoId(Company company) {
		CompanyPhoto photo = null;
		Query q = entityManager.createQuery("SELECT cp FROM CompanyPhoto cp WHERE cp.company = :company and p.isProfilePhoto = true");// "SELECT p FROM Photo p WHERE p.name = :name";
		q.setParameter("company", company);
		
		Long profilePhotoId = null;
		if (!q.getResultList().isEmpty())
		{
			photo =  (CompanyPhoto)q.getResultList().get(0);
			profilePhotoId = photo.getId();
		}
		
		
		return profilePhotoId;
	}

	@Transactional
	public CompanyPhoto getPhoto(Long id) {
		return findOne(id);
	}

}
