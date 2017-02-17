/* {TransactionSetHdr.java}
 * This class handles all data encompassed by the Transaction Set (ST) data
 * segment in EDI transmissions.
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
 *      <td>ST Transaction Set Header</td>
 *  </tr>
 *  <tr>
 *      <td align="right"><strong>Position:</strong></td>
 *      <td>010</td>
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
 *      <td>To indicate the start of a transaction set and to assign a control
 *          number</td>
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
 *              <li>The transaction set identifier (ST01) is intended for use by
 *                  the translation routines of the interchange partners to 
 *                  select the appropriate transaction set definition (e.g. 810
 *                  selects the invoice transaction set).</li>
 *          </ol></td>
 *  </tr>
 *  <tr>
 *      <td align="right"><strong>Notes:</strong></td>
 *      <td bgcolor="LightGrey"><code>ST*997*0001@</code></td>
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
 *      <td><strong>ST01</strong></td>
 *      <td><strong>143</strong></td>
 *      <td><strong>Transaction Set Identifier Code</strong></td>
 *      <td><strong>M &nbsp; ID 3/3</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>Code uniquely identifying a Transaction Set
 *          <table summary="GS01">
 *              <tr>
 *                  <th>Code</th>
 *                  <th>Document Type Referenced</th>
 *              </tr>
 *              <tr>
 *                  <td>810</td>
 *                  <td>Invoice (with or without VAT)</td>
 *              </tr>
 *              <tr>
 *                  <td>812</td>
 *                  <td>Credit Memo</td>
 *              </tr>
 *              <tr>
 *                  <td>820</td>
 *                  <td>Approved Invoice and Adjustment</td>
 *              <tr>
 *                  <td>824</td>
 *                  <td>Application Advice</td>
 *              </tr>
 *              <tr>
 *                  <td>830</td>
 *                  <td>Production Schedule/Planning Release</td>
 *              </tr>
 *              <tr>
 *                  <td>832</td>
 *                  <td>Price Sales Catalog</td>
 *              </tr>
 *              <tr>
 *                  <td>840</td>
 *                  <td>Request for Quotation</td>
 *              </tr>
 *              <tr>
 *                  <td>842</td>
 *                  <td>Nonconformance Report</td>
 *              </tr>
 *              <tr>
 *                  <td>843</td>
 *                  <td>Response to Request for Quotation</td>
 *              </tr>
 *              <tr>
 *                  <td>846</td>
 *                  <td>Inventory Inquiry/Advice</td>
 *              </tr>
 *              <tr>
 *                  <td>846</td>
 *                  <td>Inventory Advice sent by CAT</td>
 *              </tr>
 *              <tr>
 *                  <td>850</td>
 *                  <td>Purchase Order</td>
 *              </tr>
 *              <tr>
 *                  <td>856</td>
 *                  <td>Advanced Ship Notice (ASN)</td>
 *              </tr>
 *              <tr>
 *                  <td>860</td>
 *                  <td>Purchase Order Change Request</td>
 *              </tr>
 *              <tr>
 *                  <td>861</td>
 *                  <td>Receiving Advice/Acceptance Certificate</td>
 *              </tr>
 *              <tr>
 *                  <td>862</td>
 *                  <td>Shipping Schedule</td>
 *              </tr>
 *              <tr>
 *                  <td>863</td>
 *                  <td>Mill Heat Data Test Results</td>
 *              </tr>
 *              <tr>
 *                  <td>997</td>
 *                  <td>Functional Acknowledgment</td>
 *              </tr>
 *          </table></td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td><strong>ST02</strong></td>
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
public class TransactionSetHdr {
    //<editor-fold desc=" Private Member Fields ">
    /**
     * <strong>Transaction Set Identifier Code</strong> <em>Data Element:</em>
     * 143
     * <p>
     * <em>Required Length:</em> 3 characters (<tt>int</tt> value)<br>
     * <em>Element Style:</em> Identification value
     * <p>
     * Code uniquely identifying a Transaction Set.
     */
    private int ST01;       // Transaction Set Identifier Code
    /**
     * <strong>Transaction Set Control Number</strong> <em>Data Element:</em>
     * 329
     * <p>
     * <em>Required Length:</em> 4 characters (9 max)<br>
     * <em>Element Style:</em> Authorization Number value
     * <p>
     * Identifying control number assigned by the originator for a transaction
     * set.
     * <p>
     * <em><strong>NOTE:</strong> This field and the Transaction Set Control
     * Number in the Transaction Set Trailer SE02 field <strong>must</strong>
     * match for this to be considered a valid transaction set.</em>
     */
    private String ST02;    // Transaction Set Control Number
    //</editor-fold>
    
    //<editor-fold desc=" Property Getters and Setters ">
    /**
     * Retrieves the Transaction Set Identifier Code value for an EDI
     * transmission.
     * 
     * @return the Transaction Set Identifier Code
     */
    public int getTsIdentifierCode() {
        return ST01;
    }
    /**
     * Stores the Transaction Set Identifier Code value for an EDI transmission
     * from the incoming EDI file for later use.
     * 
     * @param idCode the Transaction Set Identifier Code value from EDI file
     */
    public void setTsIdentifierCode(int idCode) {
        this.ST01 = idCode;
    }
    /**
     * Retrieves the Transaction Set Control Number value for an EDI 
     * transmission.
     * 
     * @return the Transaction Set Control Number value
     */
    public String getTsControlNumber() {
        return ST02;
    }
    /**
     * Stores the Transaction Set Control Number value for an EDI transmission
     * from the incoming EDI file for later use.
     * 
     * @param ctlNumber the Transaction Set Control Number value from EDI file
     */
    public void setTsControlNumber(String ctlNumber) {
        this.ST02 = ctlNumber;
    }
    //</editor-fold>
    
    //<editor-fold desc=" Constructor ">
    /**
     * Default constructor for the <tt>TransactionSetHdr</tt> class. This
     * constructor initializes each member field to a reasonable default value.
     * The object created will not be useful until data is stored in it by 
     * calling its property setters.
     */
    public TransactionSetHdr () {
        // Initialize our fields to reasonable defaults.
        this.ST01 = 0;
        this.ST02 = "";
    }
    //</editor-fold>
    
}