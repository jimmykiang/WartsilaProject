package com.wartsila.tracker.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wartsila.tracker.data.Data;
import com.wartsila.tracker.domain.VehicleNotFoundException;
import com.wartsila.tracker.domain.VehiclePosition;

@RestController
public class PositionReportsController 
{
	@Autowired
	private Data data;
	
	@RequestMapping(method=RequestMethod.GET,value="/vehicles/{vehicleName}")
	public ResponseEntity<VehiclePosition> getLatestReportForVehicle(@PathVariable String vehicleName)
	{
		try 
		{
			VehiclePosition position = data.getLatestPositionFor(vehicleName);
			return new ResponseEntity<VehiclePosition>(position, HttpStatus.OK);
		} 
		catch (VehicleNotFoundException e) 
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/history/{vehicleName}")
	public Collection<VehiclePosition> getEntireHistoryForVehicle(@PathVariable String vehicleName) throws VehicleNotFoundException
	{
		return this.data.getHistoryFor(vehicleName);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/vehicles/")
	public Collection<VehiclePosition> getAllPositions()
	{
		return data.getLatestPositionsOfAllVehicles();
	}
}
