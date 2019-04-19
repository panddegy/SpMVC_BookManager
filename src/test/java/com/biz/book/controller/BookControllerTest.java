package com.biz.book.controller;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.biz.book.service.BookService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"/WEB-INF/spring/testServlet/*-context.xml"})
public class BookControllerTest {

	@Autowired
	BookService bookService;
	
	@Test
	public void testViewBookList() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertBookModelBookVO() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertBookModelBookVOHttpServletRequest() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateBookModelLongBookVO() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateBookModelBookVOHttpServletRequest() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteBook() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindBook() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchBook() {
		fail("Not yet implemented");
	}

}
