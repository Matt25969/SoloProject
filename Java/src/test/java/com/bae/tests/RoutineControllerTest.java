package com.bae.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.business.RoutineService;

import come.bae.rest.RoutineController;

@RunWith(MockitoJUnitRunner.class)
public class RoutineControllerTest {

	private String mockValue;
	private String mockValue2;

	@InjectMocks
	private RoutineController controller;
	// Class under test

	@Mock
	private RoutineService service;

	@Before
	public void setup() {
		controller.setService(service);
		mockValue = "testValue";
	}

	@Test
	public void testGetAllRoutines() {
		Mockito.when(service.getAllRoutines()).thenReturn(mockValue);
		Assert.assertEquals(mockValue, controller.getAllRoutines());
	}

	@Test
	public void testCreateRoutine() {
		Mockito.when(service.createRoutine(mockValue2)).thenReturn(mockValue);
		Assert.assertEquals(mockValue, controller.createRoutine(mockValue2));
		Mockito.verify(service).createRoutine(mockValue2);
	}

	@Test
	public void testDeleteRoutine() {
		Mockito.when(service.deleteRoutine(1)).thenReturn(mockValue);
		Assert.assertEquals(mockValue, controller.deleteRoutine(1));
		Mockito.verify(service).deleteRoutine(1);
	}

}