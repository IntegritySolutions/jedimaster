/* {FunctionalGrpHdr.java}
 * This class maintains all data for the management of Functional Group Headers
 * contained within EDI transmissions.
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
 *      <td>GS Functional Group Header</td>
 *  </tr>
 *  <tr>
 *      <td align="right"><strong>Position:</strong></td>
 *      <td>008</td>
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
 *      <td>To indicate the beginning of a functional group and to provide
 *          control information</td>
 *  </tr>
 *  <tr>
 *      <td align="right"><strong>Syntax Notes:</strong></td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td align="right"><strong>Semantic Notes:</strong></td>
 *      <td><ol>
 *              <li>The data interchange control number GS06 in this header must
 *                  be identical to the same data element in the associated
 *                  Functional Group Trailer GE02.</li>
 *          </ol></td>
 *  </tr>
 *  <tr>
 *      <td align="right"><strong>Comments:</strong></td>
 *      <td><ol>
 *              <li>A functional group of related transaction sets, within the
 *                  scope of X12 standards, consists of a collection of similar
 *                  transaction sets enclosed by a functional group header and a 
 *                  functional group trailer.</li>
 *              <li>GS04 is the Group Date</li>
 *              <li>GS05 is the Group Time</li>
 *          </ol></td>
 *  </tr>
 *  <tr>
 *      <td align="right"><strong>Notes:</strong></td>
 *      <td bgcolor="LightGrey"><code>GS*FA*ff*X0000X0*931001*1030*000000004*X*003020@</code></td>
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
 *      <td><strong>GS01</strong></td>
 *      <td><strong>479</strong></td>
 *      <td><strong>Functional Identifier Code</strong></td>
 *      <td><strong>M &nbsp; ID 2/2</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>Code Identifying a group of application related transaction sets.
 *          <table summary="GS01">
 *              <tr>
 *                  <th>Code</th>
 *                  <th>Document Type Referenced</th>
 *                  <th>Doc Type</th>
 *              </tr>
 *              <tr>
 *                  <td>IN</td>
 *                  <td>Invoice (with or without VAT)</td>
 *                  <td>810</td>
 *              </tr>
 *              <tr>
 *                  <td>CD</td>
 *                  <td>Credit Memo</td>
 *                  <td>812</td>
 *              </tr>
 *              <tr>
 *                  <td>RA</td>
 *                  <td>Approved Invoice and Adjustment</td>
 *                  <td>820</td>
 *              <tr>
 *                  <td>AG</td>
 *                  <td>Application Advice</td>
 *                  <td>824</td>
 *              </tr>
 *              <tr>
 *                  <td>PS</td>
 *                  <td>Production Schedule/Planning Release</td>
 *                  <td>830</td>
 *              </tr>
 *              <tr>
 *                  <td>SC</td>
 *                  <td>Price Sales Catalog</td>
 *                  <td>832</td>
 *              </tr>
 *              <tr>
 *                  <td>RQ</td>
 *                  <td>Request for Quotation</td>
 *                  <td>840</td>
 *              </tr>
 *              <tr>
 *                  <td>NC</td>
 *                  <td>Nonconformance Report</td>
 *                  <td>842</td>
 *              </tr>
 *              <tr>
 *                  <td>RR</td>
 *                  <td>Response to Request for Quotation</td>
 *                  <td>843</td>
 *              </tr>
 *              <tr>
 *                  <td>IB</td>
 *                  <td>Inventory Inquiry/Advice</td>
 *                  <td>846</td>
 *              </tr>
 *              <tr>
 *                  <td>IA</td>
 *                  <td>Inventory Advice sent by CAT</td>
 *                  <td>846</td>
 *              </tr>
 *              <tr>
 *                  <td>PO</td>
 *                  <td>Purchase Order</td>
 *                  <td>850</td>
 *              </tr>
 *              <tr>
 *                  <td>SH</td>
 *                  <td>Advanced Ship Notice (ASN)</td>
 *                  <td>856</td>
 *              </tr>
 *              <tr>
 *                  <td>PC</td>
 *                  <td>Purchase Order Change Request</td>
 *                  <td>860</td>
 *              </tr>
 *              <tr>
 *                  <td>RC</td>
 *                  <td>Receiving Advice/Acceptance Certificate</td>
 *                  <td>861</td>
 *              </tr>
 *              <tr>
 *                  <td>SS</td>
 *                  <td>Shipping Schedule</td>
 *                  <td>862</td>
 *              </tr>
 *              <tr>
 *                  <td>RT</td>
 *                  <td>Mill Heat Data Test Results</td>
 *                  <td>863</td>
 *              </tr>
 *              <tr>
 *                  <td>FA</td>
 *                  <td>Functional Acknowledgment</td>
 *                  <td>997</td>
 *              </tr>
 *          </table></td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td><strong>GS02</strong></td>
 *      <td><strong>142</strong></td>
 *      <td><strong>Application Sender's Code</strong></td>
 *      <td><strong>M &nbsp; AN 2/15</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>Code identifying party sending transmission; codes agreed to by
 *          trading partners</td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td bgcolor="LightGrey">ff = CATERPILLAR SENDING FACILITY CODE. (SEE
 *          APPENDIX).</td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td><strong>GS03</strong></td>
 *      <td><strong>124</strong></td>
 *      <td><strong>Application Receiver's Code</strong></td>
 *      <td><strong>M &nbsp; AN 2/15</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>Code identifying party receiving transmission; codes agreed to by
 *          trading partners</td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td bgcolor="LightGrey">CATERPILLAR ASSIGNED SUPPLIER CODE OR TRADING
 *          PARTNER ID</td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td><strong>GS04</strong></td>
 *      <td><strong>373</strong></td>
 *      <td><strong>Date</strong></td>
 *      <td><strong>M &nbsp; DT 6/6</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>Date (YYMMDD)</td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td><strong>GS05</strong></td>
 *      <td><strong>337</strong></td>
 *      <td><strong>Time</strong></td>
 *      <td><strong>M &nbsp; TM 4/6</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>Time expressed in 24-hour clock time in one of two formats:
 *          <ul>
 *              <li>HHMMSS</li>
 *              <li>HHMM</li>
 *          </ul>
 *          <em>Time Range:</em>000000 through 235959</td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td><strong>GS06</strong></td>
 *      <td><strong>28</strong></td>
 *      <td><strong>Group Control Number</strong></td>
 *      <td><strong>M &nbsp; N0 1/9</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>Assigned number originated and maintained by the sender
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td><strong>GS07</strong></td>
 *      <td><strong>455</strong></td>
 *      <td><strong>Responsible Agency Code</strong></td>
 *      <td><strong>M &nbsp; ID 1/2</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>Code used in conjunction with Data Element 480 (GS08) to identify 
 *          the issuer of the standard
 *          <table summary="ISA07">
 *              <tr>
 *                  <td>X &nbsp;&nbsp; </td>
 *                  <td>Accredited Standards Committee X12</td>
 *              </tr>
 *          </table></td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td><strong>GS08</strong></td>
 *      <td><strong>480</strong></td>
 *      <td><strong>Version / Release / Industry Identifier Code</strong></td>
 *      <td><strong>M &nbsp; AN 1/12</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>Code indicating the version, release, subrelease and industry of the
 *          EDI standard being used, including the GS and GE segments. Positions
 *          1-3, version number; positions 4-6, release and subrelease level of
 *          version; positions7-12, industry or trade association identifier
 *          (optionally assigned by user).</td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td bgcolor="LightGrey">VERSION RELEASE NUMBER VARIES DEPENDING ON THE 
 *          VERSION OF THE TRANSACTION THE 997 IS ACKNOWLEDGING, WHEN USING THIS
 *          CLASS FOR 997 ACKNOWLEDGMENTS</td>
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
public class FunctionalGrpHdr {
    //<editor-fold desc=" Private Member Fields ">
    /**
     * <strong>Functional Identifier Code</strong> <em>Data Element:</em> 479.
     * <p>
     * <em>Required Length:</em> 2 characters<br>
     * <em>Element Style:</em> Identification Value
     * <p>
     * Code identifying a group of application related transaction sets.
     */
    private String GS01;    // Functional Identifier Code
    /**
     * <strong>Application Sender's Code</strong> <em>Data Element:</em> 142.
     * <p>
     * <em>Required Length:</em> 2 characters (15 max)<br>
     * <em>Element Style:</em> Authorization Number
     * <p>
     * Code identifying party sending transmission; codes agreed to by trading
     * partners
     */
    private String GS02;    // Application Sender's Code
    /**
     * <strong>Application Receiver's Code</strong> <em>Data Element:</em> 124.
     * <p>
     * <em>Required Length:</em> 2 characters (15 max)<br>
     * <em>Element Style:</em> Authorization Number
     * <p>
     * Code identifying party receiving transmission; codes agreed to by trading
     * partners
     */
    private String GS03;    // Application Receiver's Code
    /**
     * <strong>Date</strong> <em>Data Element:</em> 373.
     * <p>
     * <em>Required Length:</em> 6 characters<br>
     * <em>Element Style:</em> Date
     * <p>
     * Date (YYMMDD)
     */
    private String GS04;    // Date
    /**
     * <strong>Time</strong> <em>Data Element:</em> 337
     * <p>
     * <em>Required Length:</em> 4 characters (6 max)<br>
     * <em>Element Style:</em> Time
     * <p>
     * Time expressed in 24-hour clock time (HHMMSS or HHMM) (Time Range:
     * 000000 through 235959).
     */
    private String GS05;    // Time
    /**
     * <strong>Group Control Number</strong> <em>Data Element:</em> 28
     * <p>
     * <em>Required Length:</em> 1 character (9 max)<br>
     * <em>Element Style:</em> Number, Zero-Filled
     * <p>
     * Assigned number originated and maintained by the sender
     */
    private String GS06;    // Group Control Number
    /**
     * <strong>Responsible Agency Code</strong> <em>Data Element:</em> 455
     * <p>
     * <em>Required Length:</em> 1 character (2 max)<br>
     * <em>Element Style:</em> Identification Value
     * <p>
     * Code used in conjunction with Data Element 480 (GS08) to identify the
     * issuer of the standard
     */
    private String GS07;    // Responsible Agency Code
    /**
     * <strong>Version / Release / Industry Identifier Code</strong> <em> Data
     * Element:</em> 480
     * <p>
     * <em>Required Length:</em> 1 character (12 max)<br>
     * <em>Element Style:</em> Authorization Number
     * <p>
     * Code indicating the version, release, subrelease and industry identifier
     * of the EDI standard being used, including the GS and GE segments. 
     * Positions 1-3, version number; positions 4-6, release and subrelease level
     * of version; positions 7-12, industry or trade association identifier 
     * (optionally assigned by user).
     */
    private String GS08;    // Version/Release/Industry Identifier Code
    //</editor-fold>
    
    //<editor-fold desc=" Property Getters and Setters ">
    /**
     * Retrieves the Functional Identifier Code (GS01) field value of the EDI
     * transmission.
     * 
     * @return the Functional Identifier Code value stored
     */
    public String getIdentifierCode() {
        return GS01;
    }
    /**
     * Stores the Functional Identifier Code (GS01) field value of the EDI
     * transmission from the incoming EDI file for later use.
     * 
     * @param idCode incoming Functional Identifier Code value
     */
    public void setIdentifierCode(String idCode) {
        this.GS01 = idCode;
    }
    /**
     * Retrieves the Application Sender's Code (GS02) field value of the EDI
     * transmission.
     * 
     * @return the Application Sender's Code value
     */
    public String getSenderCode() {
        return GS02;
    }
    /**
     * Stores the Application Sender's Code (GS02) field value of the EDI
     * transmission from the incoming EDI file for later use.
     * 
     * @param senderCode the Application Sender's Code value
     */
    public void setSenderCode(String senderCode) {
        this.GS02 = senderCode;
    }
    /**
     * Retrieves the Application Receiver's Code (GS03) field value of the EDI
     * transmission.
     * 
     * @return the Application Receiver's Code value
     */
    public String getReceiverCode() {
        return GS03;
    }
    /**
     * Stores the Application Receiver's Code (GS03) field value of the EDI
     * transmission from the incoming EDI file for later use.
     * 
     * @param receiverCode the Application Receiver's Code value
     */
    public void setReceiverCode(String receiverCode) {
        this.GS03 = receiverCode;
    }
    /**
     * Retrieves the Date (GS04) field value of the EDI transmission.
     * 
     * @return the Date value
     */
    public String getDate() {
        return GS04;
    }
    /**
     * Stores the Date (GS04) field value of the EDI transmission from the 
     * incoming EDI file.
     * 
     * @param date the Date value
     */
    public void setDate(String date) {
        this.GS04 = date;
    }
    /**
     * Retrieves the Time (GS05) field value of the EDI transmission.
     * 
     * @return the Time value
     */
    public String getTime() {
        return GS05;
    }
    /**
     * Stores the Time (GS05) field value of the EDI transmission from the
     * incoming EDI file for later use.
     * 
     * @param time the Time value
     */
    public void setTime(String time) {
        this.GS05 = time;
    }
    /**
     * Retrieves the Group Control Number (GS06) field value of the EDI
     * transmission.
     * 
     * @return the Group Control Number value
     */
    public String getGrpCtlNumber() {
        return GS06;
    }
    /**
     * Stores the Group Control Number (GS06) field value of the EDI transmission
     * from the incoming EDI file for later use.
     * 
     * @param ctlNumber the Group Control Number value
     */
    public void setGrpCtlNumber(String ctlNumber) {
        this.GS06 = ctlNumber;
    }
    /**
     * Retrieves the Responsible Agency Code (GS07) field value of the EDI
     * transmission.
     * 
     * @return the Responsible Agency Code value
     */
    public String getAgencyCode() {
        return GS07;
    }
    /**
     * Stores the Responsible Agency Code (GS07) field value of the EDI
     * transmission from the incoming EDI file for later use.
     * 
     * @param agencyCode the Responsible Agency Code value
     */
    public void setAgencyCode(String agencyCode) {
        this.GS07 = agencyCode;
    }
    /**
     * Retrieves the Version / Release / Industry Identifier Code (GS08) field
     * value of the EDI transmission.
     * 
     * @return the Version / Release / Industry Identifier Code value
     */
    public String getVersion() {
        return GS08;
    }
    /**
     * Stores the Version / Release / Industry Identifier Code (GS08) field 
     * value of the EDI transmission from the incoming EDI file for later use.
     * 
     * @param version the Version / Release / Industry Identifier Code value
     */
    public void setVersion(String version) {
        this.GS08 = version;
    }
    //</editor-fold>
    
    //<editor-fold desc=" Constructor ">
    /**
     * Default constructor for the <tt>FunctionalGrpHdr</tt> class. This
     * constructor initializes the member fields to reasonable values.
     */
    public FunctionalGrpHdr () {
        // Set the private fields to reasonable defaults.
        this.GS01 = "";
        this.GS02 = "";
        this.GS03 = "";
        this.GS04 = "";
        this.GS05 = "";
        this.GS06 = "";
        this.GS07 = "";
        this.GS08 = "";
    }
    //</editor-fold>
    
}