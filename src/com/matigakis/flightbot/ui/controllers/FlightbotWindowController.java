package com.matigakis.flightbot.ui.controllers;

import javax.swing.SwingUtilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.matigakis.fgcontrol.fdm.FDMData;
import com.matigakis.flightbot.aircraft.Aircraft;
import com.matigakis.flightbot.ui.views.FlightbotView;

/**
 * The FlightbotWindowController is responsible of controlling the main FlightBot application
 * window.
 */
public class FlightbotWindowController implements FlightbotViewController{
	private static final Logger LOGGER = LoggerFactory.getLogger(FlightbotWindowController.class);
	
	private FlightbotView flightbotView;
	private Aircraft aircraft;
		
	private FlightbotWindowController(){
	}
	
	public FlightbotWindowController(Aircraft aircraft){
		this.aircraft = aircraft;
	}
	
	public void attachView(FlightbotView flightbotView){
		this.flightbotView = flightbotView;
	}
	
	/**
	 * Shut down FlightBot
	 */
	@Override
	public void exit() {
		LOGGER.info("Shutting down FlightBot");
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				flightbotView.close();
			}
		});
		
		System.exit(0);
	}

	@Override
	public void updateAircraftState(FDMData fdmData) {
		aircraft.updateFromFDMData(fdmData);
	}
}
