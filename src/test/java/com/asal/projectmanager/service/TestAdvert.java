package com.asal.projectmanager.service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.domain.Advert;
import com.asal.projectmanager.domain.Company;
import com.asal.projectmanager.web.controller.ProjectManagerSession;

@RunWith(SpringJUnit4ClassRunner.class)
/**@ContextConfiguration("/applicationContextTest.xml") **/
@ContextConfiguration({"/applicationContextTest.xml"})
@Transactional
public class TestAdvert {
	protected static Logger logger = Logger.getLogger(TestAdvert.class);
	@Autowired
	ProjectManagerSession projectManagerSession;
	
	@Autowired
	CompanyService companyService;

	@Autowired
	AdvertService advertService;
	
	//private MockMvc mockMvc
	
	@Before
	@Transactional
	public void initializeBusinessAndAddTwoAdverts(){
		
		
		//this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		
		Company company = new Company();
		company.setName("Tujulishe");
		companyService.add(company);
		
		company = companyService.findCompany("Tujulishe");
		
		logger.info("##### Added "+company.getName());
		
		//Add Advert
		Advert advert = new Advert();
		advert.setName("Data Clerk");
		advert.setCompany(company);
		Calendar expiryCal = Calendar.getInstance();
		expiryCal.add(Calendar.DATE, 10);
		advert.setDeadLine(new Timestamp(expiryCal.getTimeInMillis()));

		Calendar calendar = Calendar.getInstance();

		//calendar.add(field, amount)
		advertService.add(advert);
		
		
		
		advert.setName("Secretary");
		calendar.add(Calendar.DATE, -1); //Added yesterday
		advert.setCreated(new Timestamp(calendar.getTimeInMillis()));
		
		advertService.add(advert);
		
		
		//Under One week
		calendar = Calendar.getInstance();
		advert.setName("CTO");
		calendar.add(Calendar.DATE, -4);
		advert.setCreated(new Timestamp(calendar.getTimeInMillis()));
		advertService.add(advert);
		
		//Under 2 weeks
		calendar = Calendar.getInstance();
		advert.setName("Sales Rep");
		calendar.add(Calendar.DATE, -11);
		advert.setCreated(new Timestamp(calendar.getTimeInMillis()));
		advertService.add(advert);
		
		//Under one month
		calendar = Calendar.getInstance();
		advert.setName("Market Manager");
		calendar.add(Calendar.DATE, -24);
		advert.setCreated(new Timestamp(calendar.getTimeInMillis()));
		advertService.add(advert);
		

		//Over one month
		calendar = Calendar.getInstance();
		advert.setName("Market Manager");
		calendar.add(Calendar.MONTH, -2);
		advert.setCreated(new Timestamp(calendar.getTimeInMillis()));
		advertService.add(advert);
		
		logger.info("##### Added "+advertService.count()+" Adverts " );
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		for (Advert anadvert : advertService.findAll()) {
			logger.info("$$$$$$$$$$$$$$ Added : " + dateFormat.format(anadvert.getCreated().getTime())+" Expiry: "+ dateFormat.format(anadvert.getDeadLine().getTime()));
		}

		
		
	}

	@Test
	@Transactional
	public void testTodayAdverts() {
		logger.info("HHHHHHHHHHH "+advertService.getTodayAdverts().size());
		
		Assert.assertTrue(advertService.getTodayAdverts().size() == 1);
	}

	@Test
	@Transactional
	public void testYesterdayAdverts() {
		logger.info("DDDDDDDDDD "+advertService.getYesterdayAdverts().size());
		Assert.assertTrue(advertService.getYesterdayAdverts().size() == 1);
	}

	@Test
	@Transactional
	public void testPastWeekAdvert() {
		Assert.assertTrue(advertService.getPastWeekAdvert().size() == 1);
	}

	@Test
	@Transactional
	public void testPast2WeeksAdverts() {
		Assert.assertTrue(advertService.getPast2WeeksAdverts().size() == 1);
	}

	@Test
	@Transactional
	public void testOneMonthOldAdverts() {
		Assert.assertTrue(advertService.getOneMonthOldAdverts().size() == 1);
	}

	@Test
	@Transactional
	public void testOlderThanOneMonthAdverts() {
		Assert.assertTrue(advertService.getOlderThanOneMonthAdverts().size() == 1);
	}

	@Test
	@Transactional
	public void testTodayAdvertsCount() {
		Assert.assertTrue(advertService.getTodayAdvertsCount() == 1);
	}

	@Test
	@Transactional
	public void testYesterdayAdvertsCount() {
		Assert.assertTrue(advertService.getYesterdayAdvertsCount() == 1);
	}

	@Test
	@Transactional
	public void testPastWeekAdvertCount() {
		Assert.assertTrue(advertService.getPastWeekAdvertCount() == 1);
	}

	@Test
	@Transactional
	public void testPast2WeeksAdvertsCount() {
		Assert.assertTrue(advertService.getPast2WeeksAdvertsCount() == 1);
	}

	@Test
	@Transactional
	public void testOneMonthOldAdvertsCount() {
		Assert.assertTrue(advertService.getOneMonthOldAdvertsCount() == 1);
	}

	@Test
	@Transactional
	public void testOlderThanOneMonthAdvertsCount() {
		Assert.assertTrue(advertService.getOlderThanOneMonthAdvertsCount() == 1);
	}
	
	@Test
	@Transactional
	public void testAllAdverts(){
		Assert.assertTrue(advertService.count() == 6);
	}

}
