/*
 * The JTS Topology Suite is a collection of Java classes that
 * implement the fundamental operations required to validate a given
 * geo-spatial data set to a known topological specification.
 *
 * Copyright (C) 2001 Vivid Solutions
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 * For more information, contact:
 *
 *     Vivid Solutions
 *     Suite #1A
 *     2328 Government Street
 *     Victoria BC  V8T 5G5
 *     Canada
 *
 *     (250)385-6040
 *     www.vividsolutions.com
 */
package com.vividsolutions.jts.io.gml2;

import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.vividsolutions.jts.generator.*;
import com.vividsolutions.jts.geom.*;

/**
 * Round trip testing for GML reading and writing. 
 *
 * @author David Zwiers, Vivid Solutions. 
 */
public class StaticLineStringTest extends WritingTestCase {

	/**
	 * @param arg
	 */
	public StaticLineStringTest(String arg) {
		super(arg);
	}

	/**
	 * Round Trip test for a single line string
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public void testSingleLineStringRoundTrip() throws SAXException, IOException, ParserConfigurationException{
		LineStringGenerator pg = new LineStringGenerator();
		pg.setGeometryFactory(geometryFactory);
		pg.setBoundingBox(new Envelope(0,10,0,10));
		pg.setNumberPoints(10);
		
		LineString pt = (LineString) pg.create();
		
		checkRoundTrip(pt);
	}

	/**
	 * Round Trip test for a single line string with lotsa points
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public void testSingleLineStringManyPointRoundTrip() throws SAXException, IOException, ParserConfigurationException{
		LineStringGenerator pg = new LineStringGenerator();
		pg.setGeometryFactory(geometryFactory);
		pg.setBoundingBox(new Envelope(0,10,0,10));
		pg.setGenerationAlgorithm(LineStringGenerator.HORZ);
		pg.setNumberPoints(1000);
		
		LineString pt = (LineString) pg.create();

		checkRoundTrip(pt);
	}
}

