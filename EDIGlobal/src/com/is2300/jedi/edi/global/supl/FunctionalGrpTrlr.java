/* {FunctionalGrpTrlr.java}
 * This class is responsible for maintaining and managing the data in the
 * Functional Group Trailer (GE) segment of an EDI transmission.
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
 *      <td>GE Functional Group Trailer</td>
 *  </tr>
 *  <tr>
 *      <td align="right"><strong>Position:</strong></td>
 *      <td>090</td>
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
 *      <td>To indicate the end of a functional group and to provide control
 *          information</td>
 *  </tr>
 *  <tr>
 *      <td align="right"><strong>Syntax Notes:</strong></td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td align="right"><strong>Semantic Notes:</strong></td>
 *      <td><ol>
 *              <li>The data interchange control number GE02 in this trailer
 *                  must be identical to the same data element in the
 *                  associated Functional Group Header GS06.</li>
 *          </ol></td>
 *  </tr>
 *  <tr>
 *      <td align="right"><strong>Comments:</strong></td>
 *      <td><ol>
 *              <li>The use of identical data interchange control numbers in the
 *                  associated functional group header and trailer is designed
 *                  to maximize functional group integrity. The control number
 *                  is the same as that used in the corresponding header.</li>
 *          </ol></td>
 *  </tr>
 *  <tr>
 *      <td align="right"><strong>Notes:</strong></td>
 *      <td bgcolor="LightGrey"><code>GE*1*000000004@</code></td>
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
 *      <td><strong>GE01</strong></td>
 *      <td><strong>97</strong></td>
 *      <td><strong>Number of Transaction Sets Included</strong></td>
 *      <td><strong>M &nbsp; N0 1/6</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>Total number of transaction sets included in the functional group or
 *          interchange (transmission) group terminated by the trailer
 *          containing this data element.</td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td><strong>GE02</strong></td>
 *      <td><strong>28</strong></td>
 *      <td><strong>Group Control Number</strong></td>
 *      <td><strong>M &nbsp; N0 1/9</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>Assigned number originated and maintained by the sender.</td>
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
public class FunctionalGrpTrlr {
    //<editor-fold desc=" Private Member Fields ">
    /**
     * <strong>Number of Transaction Sets Included</strong> <em>Data Element:
     * </em> 97
     * <p>
     * <em>Required Length:</em> 1 character (6 max)<br>
     * <em>Element Style:</em> Numerical, Zero-filled
     * <p>
     * Total number of transaction sets included in the functional group or
     * interchange (transmission) group terminated by the trailer containing
     * this data element.
     */
    private int GE01;   // Number of Transaction Sets Included
    /**
     * <strong>Group Control Number</strong> <em>Data Element:</em> 28
     * <p>
     * <em>Required Length:</em> 1 digit (9 max)<br>
     * <em>Element Style:</em> Numerical, Zero-filled
     * <p>
     * Assigned number originated and maintained by the sender.
     */
    private int GE02;   // Group Control Number
    //</editor-fold>
    
    //<editor-fold desc=" Property Getters and Setters ">
    /**
     * Retrieves the total number of transaction sets included in the functional
     * group of an EDI transmission.
     * 
     * @return count of transaction sets included
     */
    public int getNumberOfTSets() {
        return GE01;
    }
    /**
     * Stores the total number of transaction sets included in the functional
     * group of an EDI transmission from the incoming EDI file.
     * 
     * @param count the reported total number of transaction sets from the EDI
     *              file
     */
    public void setNumberOfTSets(int count) {
        this.GE01 = count;
    }
    /**
     * Retrieves the functional group Control Number for the functional group of
     * an EDI transmission.
     * 
     * @return the group Control Number for the EDI transmission
     */
    public int getGrpControlNumber() {
        return GE02;
    }
    /**
     * Stores the group Control Number from the incoming EDI file for later use.
     * 
     * @param ctlNumber the group Control Number from the EDI file
     */
    public void setGrpControlNumber(int ctlNumber) {
        this.GE02 = ctlNumber;
    }
    //</editor-fold>
    
    //<editor-fold desc=" Constructor ">
    /**
     * Default constructor for the <tt>FunctionalGrpTrlr</tt> class. This 
     * constructor initializes the fields to reasonable default values.
     */
    public FunctionalGrpTrlr () {
        // Set our fields to reasonable initial values
        this.GE01 = 0;
        this.GE02 = 0;
    }
    //</editor-fold>
    
}