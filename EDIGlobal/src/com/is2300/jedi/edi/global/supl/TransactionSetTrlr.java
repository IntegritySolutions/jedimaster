/* {TransactionSetTrlr.java}
 * This class is responsible for storing and managing all data related to the
 * Transaction Set Trailer (SE) segment of an EDI transmission.
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
 *      <td>SE Transaction Set Trailer</td>
 *  </tr>
 *  <tr>
 *      <td align="right"><strong>Position:</strong></td>
 *      <td>080</td>
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
 *      <td>To indicate the end of a transaction set and provide the count of 
 *          the transmitted segments (including the beginning segment (ST) and
 *          ending segment (SE) segments).</td>
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
 *      <td><ol>
 *              <li>SE is the last segment of each transaction set.</li>
 *          </ol></td>
 *  </tr>
 *  <tr>
 *      <td align="right"><strong>Notes:</strong></td>
 *      <td bgcolor="LightGrey"><code>SE*6*0001@</code></td>
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
 *      <td><strong>SE01</strong></td>
 *      <td><strong>96</strong></td>
 *      <td><strong>Number of Included Segments</strong></td>
 *      <td><strong>M &nbsp; N0 1/6</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>Total number of segments included in a transaction set including ST
 *          and SE segments.</td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td><strong>SE02</strong></td>
 *      <td><strong>329</strong></td>
 *      <td><strong>Transaction Set Control Number</strong></td>
 *      <td><strong>M &nbsp; AN 4/9</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>Identifying control number assigned by the originator for a 
 *          transaction set.</td>
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
public class TransactionSetTrlr {
    //<editor-fold desc=" Private Memeber Fields ">
    /**
     * <strong>Number of Included Segments</strong> <em>Data Element:</em> 96
     * <p>
     * <em>Required Length:</em> 1 character (6 max)<br>
     * <em>Element Style:</em> Numerical, Zero-filled
     * <p>
     * Total number of segments included in a transaction set including ST and 
     * SE segments.
     */
    private int SE01;       // Number of Included Segments
    /**
     * <strong>Transaction Set Control Number</strong> <em>Data Element:</em>
     * 329
     * <p>
     * <em>Required Length:</em> 4 characters (9 max)
     * <em>Element Style:</em> Authorization Number value
     * <p>
     * Identifying control number assigned by the originator for a transaction
     * set.
     * <p>
     * <em><strong>NOTE:</strong> This field and the Transaction Set Control
     * Number in the Transaction Set Header ST02 field <strong>must</strong>
     * match for this to be considered a valid transaction set.</em>
     */
    private String SE02;    // Transaction Set Control Number
    //</editor-fold>
    
    //<editor-fold desc=" Property Getters and Setters ">
    /**
     * Retrieves the Number of Included Segments value for the EDI transmission.
     * 
     * @return the Total number of included segments, including the ST and SE
     *          segments
     */
    public int getNumberIncludedSegments() {
        return SE01;
    }
    /**
     * Stores the Number of Included Segments value for the EDI transmission
     * from the inbound EDI file.
     * <p>
     * This field is used, along with the actual count of segments to validate 
     * that the EDI file was received in completion.
     * 
     * @param count the Number of Included Segments value from the EDI file
     */
    public void setNumberIncludedSegments(int count) {
        this.SE01 = count;
    }
    /**
     * Retrieves the Transaction Set Control Number for the EDI transmission.
     * <p>
     * This field should be compared to the Transaction Set Header ST02 field to
     * validate that the transaction set is complete and of the same control.
     * 
     * @return the Transaction Set Control Number value from the EDI file
     */
    public String getTsControlNumber() {
        return SE02;
    }
    /**
     * Stores the Transaction Set Control Number for the EDI transmission from
     * the incoming EDI file.
     * <p>
     * This field's value should be compared to the Transaction Set Header ST02
     * field to validate that the transaction set is complete and of the same
     * control.
     * 
     * @param ctlNumber the Transaction Set Control Number from the EDI file
     */
    public void setTsControlNumber(String ctlNumber) {
        this.SE02 = ctlNumber;
    }
    //</editor-fold>
    
    //<editor-fold desc=" Constructor ">
    /**
     * Default constructor for the <tt>TransactionSetTrlr</tt> class. This 
     * constructor initializes the fields to reasonable default values, but will
     * not be useful until EDI data is written to the properties via the 
     * <tt>setXXXXXX()</tt> property setters.
     */
    public TransactionSetTrlr () {
        // Set our fields to reasonable default values.
        this.SE01 = 0;
        this.SE02 = "";
    }
    //</editor-fold>
    
}