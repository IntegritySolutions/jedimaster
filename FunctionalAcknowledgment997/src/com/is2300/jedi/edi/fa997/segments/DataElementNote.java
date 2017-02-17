/* {DataElementNote.java}
 * This class handles all work revolving around the Functional Acknowledgment
 * (997) Data Element Note.
 *
 * Copyright (C) 2017 Integrity Solutions
 *
 * This source code is protected by US and International Copyright 
 * Laws and Treaties. All code contained is proprietary information
 * and may not be divulged or disclosed to any third party without
 * the direct, written consent of the officers of Integrity Solutions.
 */

package com.is2300.jedi.edi.fa997.segments;

import com.is2300.jedi.edi.global.enums.DESyntaxErrorCode;



/**
 * <table border="0" summary="">
 *  <tr>
 *      <td align="right"><strong>Segment:</strong></td>
 *      <td>AK4 Data Element Note</td>
 *  </tr>
 *  <tr>
 *      <td align="right"><strong>Position:</strong></td>
 *      <td>050</td>
 *  </tr>
 *  <tr>
 *      <td align="right"><strong>Loop:</strong></td>
 *      <td>AK4 : Optional</td>
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
 *      <td>99</td>
 *  </tr>
 *  <tr>
 *      <td align="right"><strong>Purpose:</strong></td>
 *      <td>To report errors in a data element and identify the location of the
 *          data element</td>
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
 *      <td bgcolor="LightGrey">AK4*2*0235*7@</td>
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
 *      <td><strong>AK401</strong></td>
 *      <td><strong>722</strong></td>
 *      <td><strong>Element Position in Segment</strong></td>
 *      <td><strong>M &nbsp; N0 1/2</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>This is used to indicate the relative position of the data element 
 *          in error in this data segment. The count start with 1 for the data
 *          element immediately following the segment ID. This value is 0 for an
 *          error in the segment ID.</td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td><strong>AK402</strong></td>
 *      <td><strong>725</strong></td>
 *      <td><strong>Data Element Reference Number</strong></td>
 *      <td><strong>O &nbsp; N0 1/4</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>Reference number used to locate the Data Element Dictionary.</td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td><strong>AK403</strong></td>
 *      <td><strong>723</strong></td>
 *      <td><strong>Data Element Sytax Error Code</strong></td>
 *      <td><strong>M &nbsp; ID 1/3</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>Code indicating the error found after syntax edits of a data element
 *          <ol>
 *              <li> Mandatory data element missing</li>
 *              <li> Conditional required data element missing</li>
 *              <li> Too many data elements</li>
 *              <li> Data element too short</li>
 *              <li> Data element too long</li>
 *              <li> Invalid character in data element</li>
 *              <li> Invalid code value</li>
 *              <li> Invalid Date</li>
 *              <li> Invalid Time</li>
 *              <li>Exclusion Condition Violated</li>
 *          </ol></td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td><strong>AK404</strong></td>
 *      <td><strong>724</strong></td>
 *      <td><strong>Copy of Bad Data Element</strong></td>
 *      <td><strong>O &nbsp; AN 1/99</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>This is a copy of the data element in error</td>
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
public class DataElementNote {
    //<editor-fold desc=" Private Member Fields ">
    /**
     * <strong>Element Position in Segment</strong> <em>Data Element:</em> 722
     * <p>
     * <em>Required Length:</em> 1 Character (2 max)<br>
     * <em>Element Style:</em> Numerical, Zero-filled<br>
     * <em>Usage:</em> <strong>Mandatory</strong>
     * <p>
     * This is used to indicate the <em>relative</em> position of the data 
     * element in error in this data segment. The count starts with 1 for the 
     * data element <strong>immediately following</strong> the segment ID. This 
     * value is 0 for an error in the segment ID.
     */
    private Integer AK401;   // Element Position in Segment
    /**
     * <strong>Data Element Reference Number</strong> <em>Data Element:</em> 725
     * <p>
     * <em>Required Length:</em> 1 Character (4 max)<br>
     * <em>Element Style:</em> Numerical, Zero-filled<br>
     * <em>Usage:</em> <em>Optional</em>
     * <p>
     * Reference number used to locate the Data Element Dictionary.
     */
    private Integer AK402;   // Data Element Reference Number
    /**
     * <strong>Data Element Syntax Error Code</strong> <em>Data Element:</em> 723
     * <p>
     * <em>Required Length:</em> 1 Character (3 max)<br>
     * <em>Element Style:</em> Identification<br>
     * <em>Usage:</em> <strong>Mandatory</strong>
     * <p>
     * Code indicating the error found after syntax edits of a data element.
     */
    private DESyntaxErrorCode AK403;// Data Element Syntax Error Code
    /**
     * <strong>Copy of Bad Data Element</strong> <em>Data Element:</em> 724
     * <p>
     * <em>Required Length:</em> 1 Character (99 max)<br>
     * <em>Element Style:</em> Alphanumeric<br>
     * <em>Usage:</em> <em>Optional</em>
     * <p>
     * This is a copy of the data element in error.
     */
    private String AK404;   // Copy of Bad Data Element
    //</editor-fold>
    
    //<editor-fold desc=" Property Getters and Setters ">
    /**
     * Retrieves the Element Position in Segment (AK401) field value.
     * @return the Element Position in Segment (AK401) value
     */
    public Integer getElementPosition() {
        return AK401;
    }
    /**
     * Stores the Element Position in Segment (AK401) field value from the 
     * incoming EDI file for later use.
     * @param position the Element Position in Segment (AK401) value from the
     *                 EDI file
     */
    public void setElementPosition(Integer position) {
        this.AK401 = position;
    }
    /**
     * Retrieves the Data Element Reference Number (AK402) field value.
     * @return the Data Element Reference Number (AK402) value
     */
    public Integer getElementReference() {
        return AK402;
    }
    /**
     * Stores the Data Element Reference Number (AK402) field value from the 
     * incoming EDI file for later use.
     * @param refNumber the Data Element Reference Number (AK402) value from the
     *                  EDI file
     */
    public void setElementReference(Integer refNumber) {
        this.AK402 = refNumber;
    }
    /**
     * Retrieves the Data Element Syntax Error Code (AK403) field value.
     * @return the Data Element Syntax Error Code (AK403) value
     */
    public DESyntaxErrorCode getSyntaxErrorCode() {
        return AK403;
    }
    /**
     * Stores the Data Element Syntax Error Code (AK403) field value from the
     * incoming EDI file for later use. This field uses the <tt>
     * {@link net.integrity.jedi.edi.supl.enums.DESyntaxErrorCode
     * FADataElementSyntaxErrorCode} 
     * <a href="http://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html">
     * java.lang.Enum</a></tt>.
     * @param code <tt>FADataElementSyntaxErrorCode</tt> representation of the
     *             code from the incoming EDI file
     */
    public void setSyntaxErrorCode(DESyntaxErrorCode code) {
        this.AK403 = code;
    }
    /**
     * Retrieves the Copy of Bad Data Element (AK404) field value.
     * @return the Copy of Bad Data Element (AK404) value
     */
    public String getCopyOfBadData() {
        return AK404;
    }
    /**
     * Stores the Copy of Bad Data Element (AK404) field value from the incoming
     * EDI file.
     * @param badData the Copy of Bad Data Element (AK404) value
     */
    public void setCopyOfBadData(String badData) {
        this.AK404 = badData;
    }
    //</editor-fold>
    
    //<editor-fold desc=" Constructors ">
    /**
     * Default constructor to create an instance of the <tt>AK4Segment</tt> 
     * class.
     * <p>
     * All properties are initialized to null when using this constructor. Each
     * property's setter will need to be called before using the data in this
     * class instance.
     */
    public DataElementNote () {
        this.AK401 = 0;  // Nullified intitialization
        this.AK402 = 0;  // Nullified intitialization
        this.AK403 = null;  // Nullified intitialization
        this.AK404 = null;  // Nullified intitialization
    } // End of default constructor.
    /**
     * This constructor allows the <tt>AK4Segment</tt> instance object to be 
     * created with useful default values for its properties.
     * @param position  the Element Position in Segment (AK401) value
     * @param elementRef the Data Element Reference Number (AK402) value
     * @param errorCode the 
     * {@link net.integrity.jedi.edi.supl.enums.DESyntaxErrorCode
     * FADataElementSyntaxErrorCode} representation of the Data Element Syntax
     * Error Code value
     * @param badData the Copy of the Bad Data Element value
     */
    public DataElementNote ( Integer position, Integer elementRef, 
                        DESyntaxErrorCode errorCode,
                        String badData) {
        this.AK401 = position;  // The Element Position
        this.AK402 = elementRef;    // The Element Reference Number
        this.AK403 = errorCode; // The FADataElementSyntaxErrorCode value
        this.AK404 = badData;   // Copy of the bad data
    } // End of secondary constructor.
    //</editor-fold>
}
