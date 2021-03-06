package com.matigakis.flightbot.ui.views.sensors;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

import com.matigakis.fgcontrol.fdm.Position;

/**
 * The GPSPanel shows information received from the gps.
 */
public class PositionPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private final JTextField longitudeText;
	private final JTextField latitudeText;
	private final JTextField altitudeText;
	private final JTextField altitudeAGLText;
	
	public PositionPanel(){
		super();
		
		Border border = BorderFactory.createTitledBorder("Position");
		setBorder(border);
		
		LayoutManager layout = new GridBagLayout();
		
		setLayout(layout);
		//setAlignmentX(RIGHT_ALIGNMENT);
		
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.NORTHWEST;
		c.fill = GridBagConstraints.NONE;
		
		c.weightx = 1.0;
		c.weighty = 1.0;
		
		JLabel longitudeLabel = new JLabel("Longitude (deg)");
		longitudeText = new JTextField(10);
		longitudeText.setEditable(false);
		c.gridx = 0;
		c.gridy = 0;
		add(longitudeLabel, c);
		c.gridx = 1;
		c.gridy = 0;
		add(longitudeText, c);
		
		JLabel latitudeLabel = new JLabel("Latitude (deg)");
		latitudeText = new JTextField(10);
		latitudeText.setEditable(false);
		c.gridx = 0;
		c.gridy = 1;
		add(latitudeLabel, c);
		c.gridx = 1;
		c.gridy = 1;
		add(latitudeText, c);
		
		JLabel altitudeLabel = new JLabel("Altitude (ft)");
		altitudeText = new JTextField(10);
		altitudeText.setEditable(false);
		c.gridx = 0;
		c.gridy = 2;
		add(altitudeLabel, c);
		c.gridx = 1;
		c.gridy = 2;
		add(altitudeText, c);
		
		JLabel altitudeAGLLabel = new JLabel("Altitude AGL (ft)");
		altitudeAGLText = new JTextField(10);
		altitudeAGLText.setEditable(false);
		c.gridx = 0;
		c.gridy = 3;
		add(altitudeAGLLabel, c);
		c.gridx = 1;
		c.gridy = 3;
		add(altitudeAGLText, c);
		
		setVisible(true);
	}
	
	public void updatePosition(Position position) {
		double longitude = position.getLongitude();
		double latitude = position.getLatitude();
		double altitude = position.getAltitude();
		double altitudeAGL = position.getAGL();
		
		longitudeText.setText(String.valueOf(longitude));
		latitudeText.setText(String.valueOf(latitude));
		altitudeText.setText(String.valueOf(altitude));
		altitudeAGLText.setText(String.valueOf(altitudeAGL));		
	}
}
