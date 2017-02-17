/* {FGResponseHdr.java}
 * This class handles all responsibilities for storing, writing and validating
 * all AK1 data segments for and from Functional Acknowledgment (997) documents.
 *
 * Copyright (C) 2017 Integrity Solutions
 *
 * This source code is protected by US and International Copyright 
 * Laws and Treaties. All code contained is proprietary information
 * and may not be divulged or disclosed to any third party without
 * the direct, written consent of the officers of Integrity Solutions.
 */

package com.is2300.jedi.edi.fa997.segments;

/**
 * <table border="0" summary="">
 *  <tr>
 *      <td align="right"><strong>Segment:</strong></td>
 *      <td>AK1 Functional Group Response Header</td>
 *  </tr>
 *  <tr>
 *      <td align="right"><strong>Position:</strong></td>
 *      <td>020</td>
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
 *      <td>Mandatory</td>
 *  </tr>
 *  <tr>
 *      <td align="right"><strong>Max Use:</strong></td>
 *      <td>1</td>
 *  </tr>
 *  <tr>
 *      <td align="right"><strong>Purpose:</strong></td>
 *      <td>To start acknowledgment of a functional group</td>
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
 *      <td><ol><li>AK101 is the functional ID found in the GS segment (GS01) in
 *                  the functional group being acknowledged.</li>
 *              <li>AK102 is the data interchange control number found in the GS
 *                  segment in the functional group being acknowledged.</li>
 *          </ol></td>
 *  </tr>
 *  <tr>
 *      <td align="right"><strong>Notes:</strong></td>
 *      <td bgcolor="LightGrey">AK1*SH*000000001@</td>
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
 *      <td><strong>AK101</strong></td>
 *      <td><strong>479</strong></td>
 *      <td><strong>Functional Identifier Code</strong></td>
 *      <td><strong>M &nbsp; ID 2/2</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>Code identifying a group of application related transaction sets</td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td bgcolor="LightGrey">FUNCTIONAL IDENTIFIER CODE VARIES DEPENDING ON THE
 *                         TRANSACTION TYPE THE 997 IS ACKNOWLEDGING</td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td><strong>AK102</strong></td>
 *      <td><strong>28</strong></td>
 *      <td><strong>Group Control Number</strong></td>
 *      <td><strong>M &nbsp; N0 1/9</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>Assigned number originated and maintained by the sender</td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td bgcolor="LightGrey">CONTROL NUMBER FROM THE 'GS' SEGMENT OF THE
 *                         TRANSACTION BEING ACKNOWLEDGED</td>
 *      <td> &nbsp; </td>
 *  </tr>
 * </table>
 * @version <strong><em>Reference:</em></strong> CAT997MULTIPLEVERSIONS.TXT 
 *          (003020) Dated: June 29, 2009
 * 
 * @author Sean Carrick
 * @version <strong><em>0.5.0</em></strong>
 * @since 0.5.0
 */
public class FGResponseHdr {
    //<editor-fold desc=" Private Member Fields ">
    /**
     * <strong>Functional Identifier Code</strong> <em>Data Element:</em> 479
     * <p>
     * <em>Required Length:</em> 2 characters<br>
     * <em>Element Style:</em> Identification<br>
     * <em>Usage:</em> <strong>Mandatory</strong>
     * <p>
     * Code identifying a group of application related transaction sets.
     * <p>
     * <strong>NOTE:</strong> <em>Functional identifier code varies depending on
     * the Transaction Type the 997 is acknowledging.</em>
     * 
     */
    private String AK101;
    /**
     * <strong>Group Control Number</strong> <em>Data Element:</em> 28
     * <p>
     * <em>Required Length:</em> 1 character (9 max)<br>
     * <em>Element Style:</em> Numerical, Zero-filled<br>
     * <em>Usage:</em> <strong>Mandatory</strong>
     * <p>
     * Assigned number originated and maintained by the sender.
     * <p>
     * <strong>NOTE:</strong> <em>Control Number from the 'GS' Segment of the 
     * Transaction being acknowledged.</em>
     */
    private Integer AK102;
    //</editor-fold>
    
    //<editor-fold desc=" Property Setters and Getters ">
    /**
     * Retrieves the Functional Identifier Code for this Functional Group
     * Response Header.
     * @return the Functional Identifier Code.
     */
    public String getFunctionalIdentifierCode() {
        return AK101;
    }

    /**
     * Sets the Functional Identifier Code for this Functional Group Response
     * Header.
     * @param AK101 the Functional Identifier Code to store.
     */
    public void setFunctionalIdentifierCode(String AK101) {
        this.AK101 = AK101;
    }

    /**
     * Retrieves the Group Control Number for this Functional Group Response
     * Header.
     * @return the Group Control Number.
     */
    public Integer getGroupControlNumber() {
        return AK102;
    }
    
    /**
     * Sets the Group Control Number for this Functional Group Response Header.
     * @param AK102 the Group Control Number to store.
     */
    public void setGroupControlNumber(Integer AK102) {
        this.AK102 = AK102;
    }
    //</editor-fold>
    
    //<editor-fold desc=" Constructors ">
    /**
     * Creates a new default instance of the AK1Segment class.
     */
    public FGResponseHdr() {
        // Just nullify our member fields for right now.
        this.AK101 = null;
        this.AK102 = null;
    }
    
    /**
     * Creates a new instance of the AK1Segment class with the member fields
     * set to the values sent.
     * 
     * @param AK101 the Functional Identifier Code to initialize this AK1 class.
     * @param AK102 the Group Control Number to initialize this AK1 class.
     */
    public FGResponseHdr(String AK101, Integer AK102) {
        this.AK101 = AK101;
        this.AK102 = AK102;
    }
    //</editor-fold>
}
