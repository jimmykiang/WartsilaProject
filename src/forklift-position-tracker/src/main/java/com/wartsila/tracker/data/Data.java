package com.wartsila.tracker.data;

import java.util.Collection;

import com.wartsila.tracker.domain.VehicleNotFoundException;
import com.wartsila.tracker.domain.VehiclePosition;

public interface Data {

	void updatePosition(VehiclePosition position);

	VehiclePosition getLatestPositionFor(String vehicleName) throws VehicleNotFoundException;

	void addAllReports(VehiclePosition[] allReports);

	Collection<VehiclePosition> getLatestPositionsOfAllVehicles();

	Collection<VehiclePosition> getHistoryFor(String vehicleName) throws VehicleNotFoundException;
}
