/* {InterchangeCtlTrlr.java}
 * This class maintains and manages all data related to the Interchange Control 
 * Trailer segment of EDI transmissions.
 *
 * Copyright (C) 2017 Integrity Solutions
 *
 * This source code is protected by US and International Copyright 
 * Laws and Treaties. All code contained is proprietary information
 * and may not be divulged or disclosed to any third party without
 * the direct, written consent of the officers of Integrity Solutions.
 */
package com.is2300.jedi.edi.global.supl;

/**
 * <table border="0" summary="">
 *  <tr>
 *      <td align="right"><strong>Segment:</strong></td>
 *      <td>IEA Interchange Control Trailer</td>
 *  </tr>
 *  <tr>
 *      <td align="right"><strong>Position:</strong></td>
 *      <td>100</td>
 *  </tr>
 *  <tr>
 *      <td align="right"><strong>Loop:</strong></td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td align="right"><strong>Level:</strong></td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td align="right"><strong>Usage:</strong></td>
 *      <td>Optional</td>
 *  </tr>
 *  <tr>
 *      <td align="right"><strong>Max Use:</strong></td>
 *      <td>1</td>
 *  </tr>
 *  <tr>
 *      <td align="right"><strong>Purpose:</strong></td>
 *      <td>To define the end of an interchange of one or more functional groups
 *          and interchange-related control segments</td>
 *  </tr>
 *  <tr>
 *      <td align="right"><strong>Syntax Notes:</strong></td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td align="right"><strong>Semantic Notes:</strong></td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td align="right"><strong>Comments:</strong></td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td align="right"><strong>Notes:</strong></td>
 *      <td bgcolor="LightGrey"><code>IEA*1*000000001@</code></td>
 *  </tr>
 * </table>
 * <p align="center"><strong><em>Data Element Summary</em></strong></p>
 * <table summary="Data Element Summary" border="0">
 *  <tr>
 *      <th>Ref. Des.</th>
 *      <th>Data Element</th>
 *      <th>Name</th>
 *      <th>Attributes</th>
 *  </tr>
 *  <tr>
 *      <td><strong>IEA01</strong></td>
 *      <td><strong>I16</strong></td>
 *      <td><strong>Number of Included Functional Groups</strong></td>
 *      <td><strong>M &nbsp; N0 1/5</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>A count of the number of functional groups included in a
 *          transmission.</td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td><strong>IEA02</strong></td>
 *      <td><strong>I12</strong></td>
 *      <td><strong>Interchange Control Number</strong></td>
 *      <td><strong>M &nbsp; N0 9/9</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>This number uniquely identifies the interchange data to the sender.
 *          It is assigned by the sender. Together with the sender ID it uniquely
 *          identifies the interchange data to the receiver. It is suggested that
 *          the sender, receiver, and all third parties be able to maintain an
 *          audit trail of interchanges using this number.</td>
 *      <td> &nbsp; </td>
 *  </tr>

 * </table>
 * @version <strong><em>Reference:</em></strong> CAT997MULTIPLEVERSIONS.TXT 
 *          (003020) Dated: June 29, 2009
 *
 * @author Sean Carrick
 * @version <strong><em>Program:</em></strong> 0.5.0
 * @since 0.5.0
 */
public class InterchangeCtlTrlr {
    //<editor-fold desc=" Private Member Fields ">
    /**
     * <strong>Number of Included Functional Groups</strong> <em>Data Element:
     * </em> I16
     * <p>
     * <em>Required Length:</em> 1 digit (5 max)<br>
     * <em>Element Style:</em> Numerical, Zero-filled
     * <p>
     * A count of the number of functional groups included in a transmission.
     */
    private int IEA01;  // Number of Included Functional Groups
    /**
     * <strong>Interchange Control Number</strong> <em>Data Element:</em> I12
     * <p>
     * <em>Required Length:</em> 9 digits<br>
     * <em>Element Style:</em> Numerical, Zero-filled
     * <p>
     * This number uniquely identifies the interchange data to the sender. It is
     * assigned by the sender. Together with the sender ID it uniquely identifies
     * the interchange data to the receiver. It is suggested that the sender,
     * receiver, and all third parties be able to maintain an audit trail of
     * interchanges using this number.
     */
    private int IEA02;  // Interchange Control Number
    //</editor-fold>
    
    //<editor-fold desc=" Property Getters and Setters ">
    /**
     * Retrieves the stated count of functional groups in order to verify the
     * validity and integrity of the EDI transmission.
     * 
     * @return functional group count
     */
    public int getFunctionalGrpCount() {
        return IEA01;
    }
    /**
     * Stores the stated functional group count from the EDI transmission of the
     * incoming EDI file.
     * 
     * @param grpCount the functional group count from the EDI file
     */
    public void setFunctionalGrpCount(int grpCount) {
        this.IEA01 = grpCount;
    }
    /**
     * Retrieves the Interchange Control Number of an EDI transmission.
     * 
     * @return the Interchange Control Number
     */
    public int getInterchangeCtlNumber() {
        return IEA02;
    }
    /**
     * Stores the Interchange Control Number from the incoming EDI transmission
     * file to compare to the header for validity and integrity of the EDI data.
     * 
     * @param ctlNumber the Interchange Control Number from the EDI file
     */
    public void setInterchangeCtlNumber(int ctlNumber) {
        this.IEA02 = ctlNumber;
    }
    //</editor-fold>
    
    //<editor-fold desc=" Constructor ">
    /**
     * Default constructor for the <tt>InterchangeCtlTrlr</tt> class. This 
     * constructor initializes the fields to reasonable initial values.
     */
    public InterchangeCtlTrlr () {
        // Set our fields to reasonable initial values.
        this.IEA01 = 0;
        this.IEA02 = 0;
    }
    //</editor-fold>
}