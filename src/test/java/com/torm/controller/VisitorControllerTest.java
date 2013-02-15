package com.torm.controller;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;

import com.torm.domain.Visitor;

public class VisitorControllerTest {

	private VisitorController controller;

	@Before
	public void setup() {
		controller = new VisitorController();
	}

	@Test
	public void createRequest() {
		Model modelMock = Mockito.mock(Model.class);
		Visitor visitorMock = Mockito.mock(Visitor.class);

		String view = controller.createRequest(visitorMock, modelMock);

		Assert.assertEquals("visitor/display", view);

		Mockito.verify(modelMock).addAttribute("visitor", visitorMock);
		Mockito.verify(visitorMock).persist();
	}
	
	@Test
	public void createRequestForm(){
//		Model modelMock = Mockito.mock(Model.class);
//		Staff staffMock = Mockito.mock(Staff.class);
//
//		String view = controller.createRequestForm(staffMock, modelMock);
//
//		Assert.assertEquals("visitor/create", view);
//
//		Mockito.verify(modelMock).addAttribute("staffList", staffMock);
	}
	
	

}
