package com.wartsila;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Date;

import org.junit.Test;

import com.wartsila.tracker.domain.VehicleBuilder;
import com.wartsila.tracker.domain.VehiclePosition;

public class VehiclePositionTests {

	private static final Date TIMESTAMP = TestUtils.getDateFrom("Wed Feb 01 10:26:12 BST 2017");

	@Test
	public void testEqualityOfVehiclePositions()
	{
		VehiclePosition one = new VehicleBuilder().withName("truck").withTimestamp(TIMESTAMP).build();
		VehiclePosition two = new VehicleBuilder().withName("truck").withTimestamp(TIMESTAMP).build();
		assertEquals(one, two);
	}
	
	@Test
	public void testNonEquality()
	{
		VehiclePosition one = new VehicleBuilder().withName("truck").withTimestamp(TestUtils.getDateFrom("Wed Feb 01 10:26:11 BST 2017")).build();
		VehiclePosition two = new VehicleBuilder().withName("truck").withTimestamp(TIMESTAMP).build();
		assertNotEquals(one, two);
	}
	
	@Test
	public void testDifferentVehiclesAreNeverEqual()
	{
		VehiclePosition one = new VehicleBuilder().withName("truck").withTimestamp(TIMESTAMP).build();
		VehiclePosition two = new VehicleBuilder().withName("truckdifferent").withTimestamp(TIMESTAMP).build();
		assertNotEquals(one, two);
	}
	
	
	
}
