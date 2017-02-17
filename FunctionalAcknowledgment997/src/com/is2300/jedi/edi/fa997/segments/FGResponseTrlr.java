/* {FGResponseTrlr.java}
 * This class handles everything dealing with the Functional Group Response
 * Trailer (AK9) segment of Functional Acknowledgment (997) documents.
 *
 * Copyright (C) 2017 Integrity Solutions
 *
 * This source code is protected by US and International Copyright 
 * Laws and Treaties. All code contained is proprietary information
 * and may not be divulged or disclosed to any third party without
 * the direct, written consent of the officers of Integrity Solutions.
 */

package com.is2300.jedi.edi.fa997.segments;

import com.is2300.jedi.edi.global.enums.FGAcknowledgmentCode;
import com.is2300.jedi.edi.global.enums.FGSyntaxErrorCode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <table border="0" summary="">
 *  <tr>
 *      <td align="right"><strong>Segment:</strong></td>
 *      <td>AK9 Functional Group Response Trailer</td>
 *  </tr>
 *  <tr>
 *      <td align="right"><strong>Position:</strong></td>
 *      <td>070</td>
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
 *      <td>To acknowledge acceptance or rejection functional group and report
 *          the number of included transaction sets from the original trailer,
 *          the accepted sets, and the received sets in this functional group
 *      </td>
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
 *              <li>If AK901 is 'A' or 'E', then the transmitted functional 
 *                  group is accepted. If AK901 is 'R', then the transmitted
 *                  group is rejected.</li>
 *          </ol></td>
 *  </tr>
 *  <tr>
 *      <td align="right"><strong>Notes:</strong></td>
 *      <td bgcolor="LightGrey">AK9*A@<br>
 *                              AK9*P*2*2*1*1@</td>
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
 *      <td><strong>AK901</strong></td>
 *      <td><strong>715</strong></td>
 *      <td><strong>Functional Group Acknowledgment Code</strong></td>
 *      <td><strong>M &nbsp; ID 1/1</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>Code indicating accept or reject condition based on the syntax
 *          editing of the functional group<br>
 *          <table summary="sub">
 *              <tr>
 *                  <td>A</td>
 *                  <td>Accepted</td>
 *              </tr>
 *              <tr>
 *                  <td>E</td>
 *                  <td>Accepted, but Errors were Noted</td>
 *              </tr>
 *              <tr>
 *                  <td>P</td>
 *                  <td>Partially Accepted, At Least One Transaction Set Was
 *                      Rejected</td>
 *              </tr>
 *              <tr>
 *                  <td>R</td>
 *                  <td>Rejected</td>
 *              </tr>
 *          </table></td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td><strong>AK902</strong></td>
 *      <td><strong>97</strong></td>
 *      <td><strong>Number of Transaction Sets Included</strong></td>
 *      <td><strong>M &nbsp; N0 1/6</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>Total number of transaction sets included in the functional group or
 *          interchange (transmission) group terminated by the trailer 
 *          containing this data element</td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td><strong>AK903</strong></td>
 *      <td><strong>123</strong></td>
 *      <td><strong>Number of Received Transaction Sets</strong></td>
 *      <td><strong>M &nbsp; N0 1/6</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>Number of Transaction Sets received</td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td><strong>AK904</strong></td>
 *      <td><strong>2</strong></td>
 *      <td><strong>Number of Accepted Transaction Sets</strong></td>
 *      <td><strong>M &nbsp; N0 1/6</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>Number of accepted Transaction Sets in a Functional Group</td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td><strong>AK905</strong></td>
 *      <td><strong>716</strong></td>
 *      <td><strong>Functional Group Syntax Error Code</strong></td>
 *      <td><strong>M &nbsp; N0 1/6</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>Code indicating error found based on the syntax editing of the
 *          functional group header and/or trailer</td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td bgcolor="LightGrey"><strong><em>NOTE:</em></strong> This field may
 *          be present numerous times in the document. Therefore, this field
 *          will be maintained as a list in the <tt>AK9Segment</tt> class.</td>
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
public class FGResponseTrlr {
    //<editor-fold desc=" Private Member Fields ">
    /**
     * <strong>Functional Group Acknowledgment Code (AK901)</strong>
     * <em>Data Element:</em> 715
     * <p>
     * <em>Required Length:</em> 1 Character<br>
     * <em>Element Style:</em> Identification<br>
     * <em>Usage:</em> <strong>Mandatory</strong>
     * <p>
     * Code indicating accept or reject condition based on the syntax editing of
     * the Functional Group.
     * 
     * @see net.integrity.jedi.edi.supl.enums.FGAcknowledgmentCode
     */
    private FGAcknowledgmentCode AK901; // Functional Group Acknowledgment Code
    /**
     * <strong>Number of Transaction Sets Included (AK902)</strong>
     * <em>Data Element:</em> 97
     * <p>
     * <em>Required Length:</em> 1 Character (6 max)<br>
     * <em>Element Style:</em> Numerical, Zero-filled<br>
     * <em>Usage:</em> <strong>Mandatory</strong>
     * <p>
     * Total number of Transaction Sets included in the Functional Group or
     * Interchange (transmission) Group terminated by the trailer containing
     * this data element.
     */
    private Integer AK902;   // Number of Transaction Sets Included
    /**
     * <strong>Number of Received Transaction Sets (AK903)</strong>
     * <em>Data Element:</em> 123
     * <p>
     * <em>Required Length:</em> 1 Character (6 max)<br>
     * <em>Element Style:</em> Numerical, Zero-filled<br>
     * <em>Usage:</em> <strong>Mandatory</strong>
     * <p>
     * Number of Transaction Sets received.
     */
    private Integer AK903;   // Number of Received Transaction Sets
    /**
     * <strong>Number of <em>Accepted</em> Transaction Sets</strong>
     * <em>Data Element:</em> 2
     * <p>
     * <em>Required Length:</em> 1 Character (6 max)<br>
     * <em>Element Style:</em> Numerical, Zero-filled<br>
     * <em>Usage:</em> <strong>Mandatory</strong>
     * <p>
     * Number of accepted Transaction Sets in a Functional Group.
     */
    private Integer AK904;   // Number of Accepted Transaction Sets
    /**
     * <strong>Functional Group Syntax Error Code</strong><em>Data Element:</em>
     * 716
     * <p>
     * <em>Required Length:</em> 1 Character (3 max)<br>
     * <em>Element Style:</em> Identification<br>
     * <em>Usage:</em> <em>Optional</em>
     * <p>
     * Code indicating error found based on the syntax editing of the Functional
     * Group header and/or trailer. <em>See 
     * <a href="net.integrity.yandv.edi.doctypes.fa.segments.enums.FGSyntaxErrorCode">
     * <tt>FGSyntaxErrorCode</tt></a> for the list of possible error codes.</em>
     * 
     * @see net.integrity.jedi.edi.supl.enums.FGSyntaxErrorCode
     */
    private List<FGSyntaxErrorCode> AK905; // Functional Group Syntax Error Code
    //</editor-fold>
    
    //<editor-fold desc=" Property Getters and Setters ">
    /**
     * Retrieves the <tt>
     * {@link net.integrity.jedi.edi.supl.enums.FGAcknowledgmentCode
     * FGAcknowledgmentCode}</tt> field value.
     * @return <tt>
     * {@link net.integrity.jedi.edi.supl.enums.FGAcknowledgmentCode
     * FGAcknowledgmentCode}</tt> value
     */
    public FGAcknowledgmentCode getAcknowledgmentCode() {
        return AK901;
    }
    /**
     * Stores the <tt>
     * {@link net.integrity.jedi.edi.supl.enums.FGAcknowledgmentCode
     * FGAcknowledgmentCode}</tt> value from the incoming EDI file for later use.
     * @param code <tt>
     * {@link net.integrity.jedi.edi.supl.enums.FGAcknowledgmentCode
     * FGAcknowledgmentCode}</tt> value from the incoming EDI file
     */
    public void setAcknowledgmentCode(FGAcknowledgmentCode code) {
        this.AK901 = code;
    }
    /**
     * Retrieves the total number of transaction sets included in the functional
     * group or interchange group terminated by the trailer containing the data
     * element.
     * @return the total number of transaction sets included
     */
    public Integer getNumberOfTSIncluded() {
        return AK902;
    }
    /**
     * Stores the total number of transaction sets included in the functional
     * group or interchange group terminated by the trailer containing the data
     * element from the incoming EDI file.
     * @param total the total number of transaction sets included in the EDI 
     *              file
     */
    public void setNumberOfTSIncluded(Integer total) {
        this.AK902 = total;
    }
    /**
     * Retrieves the total number of transaction sets actually received.
     * @return total number of transaction sets actually received
     */
    public Integer getReceivedTSets() {
        return AK903;
    }
    /**
     * Stores the total number of transaction sets actually received from the
     * incoming EDI file.
     * @param rcvd total number of transaction sets actually received from the
     *             EDI file
     */
    public void setReceivedTSets(Integer rcvd) {
        this.AK903 = rcvd;
    }
    /**
     * Retrieves the total number of transaction sets that have been accepted.
     * @return total number of accepted transaction sets
     */
    public Integer getNumberAccepted() {
        return AK904;
    }
    /**
     * Stores the total number of accepted transaction sets from the incoming
     * EDI file.
     * @param accepted total number of accepted 
     */
    public void setNumberAccepted(Integer accepted) {
        this.AK904 = accepted;
    }
    /**
     * Retrieves a <tt><a href="http://docs.oracle.com/javase/8/docs/api/java/util/List.html">
     * java.util.List&lt;E&gt;</a></tt> of <tt>
     * {@link net.integrity.jedi.edi.supl.enums.FGSyntaxErrorCode
     * FGSyntaxErrorCode}</tt> (AK905) field values.
     * @return java.util.List&lt;FGSyntaxErrorCode&gt; values
     */
    public List<FGSyntaxErrorCode> getErrorCodes() {
        return AK905;
    }
    /**
     * Returns a <tt>
     * <a href="http://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html">
     * java.lang.Integer</a></tt> representation of the <tt>
     * {@link net.integrity.jedi.edi.supl.enums.FGSyntaxErrorCode
     * FGSyntaxErrorCode}</tt> at the element specified by the provided index.
     * 
     * @param idx the element to retrieve the <tt>java.lang.Integer</tt> 
     *              representation of
     * @return the <tt>java.lang.Integer</tt> representation of the
     *              FGSyntaxErrorCode
     */
    public Integer getIntAtIdx(int idx) {
        return this.AK905.get(idx).toInteger();
    }
    /**
     * Returns an array of <tt>
     * <a href="http://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html">
     * java.lang.Integer</a></tt> representations of the <tt>
     * {@link net.integrity.jedi.edi.supl.enums.FGSyntaxErrorCode
     * FGSyntaxErrorCode}</tt>s contained in the <tt>
     * <a href="http://docs.oracle.com/javase/8/docs/api/java/util/List.html">
     * java.util.List&lt;E&gt;</a></tt>.
     * <p>
     * <strong><em>Note:</em></strong> This array may contain one or more 
     * elements. It could conceivably contain no elements. One should verify the
     * array has data by checking its <tt>.length</tt> property.
     * 
     * @return an array of <tt>java.lang.Integer</tt>s
     */
    public Integer[] getIntegers() {
        // Create a new Integer array initialized to the size of the List.
        Integer[] i = new Integer[this.AK905.size()];
        int x = 0;  // a counter for the elements in the Integer array.
        for (Iterator<FGSyntaxErrorCode> it = this.AK905.iterator(); it.hasNext();) {
            FGSyntaxErrorCode code = it.next();
            // Assign the current code.toInteger() value to the array.
            i[x] = code.toInteger();
            x++;    // increment the element counter.
        }
        
        // Return the Integer array.
        return i;
    }
    /**
     * Returns a <tt>
     * <a href="http://docs.oracle.com/javase/8/docs/api/java/lang/String.html">
     * java.lang.String</a></tt> representation of the <tt>
     * {@link net.integrity.jedi.edi.supl.enums.FGSyntaxErrorCode
     * FGSyntaxErrorCode}</tt> at the specified index.
     * 
     * @param idx the index of the element of which a <tt>java.lang.String</tt>
     *              representation should be returned
     * @return the <tt>java.lang.String</tt> representation of the element
     */
    public String getStrAtIdx(int idx) {
        return this.AK905.get(idx).toString();
    }
    /**
     * Returns an array of <tt>
     * <a href="http://docs.oracle.com/javase/8/docs/api/java/lang/String.html">
     * java.lang.String</a></tt> representations of the <tt>
     * {@link net.integrity.jedi.edi.supl.enums.FGSyntaxErrorCode
     * FGSyntaxErrorCode}</tt>s contained in the <tt>
     * <a href="http://docs.oracle.com/javase/8/docs/api/java/util/List.html">
     * java.util.List&lt;E&gt;</a></tt>.
     * <p>
     * <strong><em>Note:</em></strong> This array may contain one or more 
     * elements. It could conceivably contain no elements. One should verify the
     * array has data by checking its <tt>.length</tt> property.
     * 
     * @return an array of <tt>java.lang.String</tt>s
     */
    public String[] getStrings () {
        // Create a new String array initialized to the size of the List.
        String[] s = new String[this.AK905.size()];
        int x = 0;  // a counter for the elements in the String array.
        for (Iterator<FGSyntaxErrorCode> it = this.AK905.iterator(); it.hasNext();) {
            FGSyntaxErrorCode code = it.next();
            // Assign the current code.toString() value to the array.
            s[x] = code.toString();
            x++;    // increment the element counter.
        }
        
        // Return the String array.
        return s;
    }
    /**
     * Stores a <tt>{@link net.integrity.jedi.edi.supl.enums.FGSyntaxErrorCode 
     * FGSyntaxErrorCode}</tt> 
     * value into the <tt>
     * <a href="http://docs.oracle.com/javase/8/docs/api/java/util/List.html">
     * java.util.List</a></tt>.
     * @param code <tt>FGSyntaxErrorCode</tt> constant to store
     */
    public void addErrorCode(FGSyntaxErrorCode code) {
        this.AK905.add(code);
    }
    /**
     * Returns the count of all errors that have been discovered and recorded.
     * 
     * @return the total number of syntax errors
     */
    public Integer getErrorCount () {
        // Return the total number of errors recorded.
        return this.AK905.size();
    }
    //</editor-fold>
    
    //<editor-fold desc=" Constructor ">
    /**
     * Default constructor for the <tt>AK9Segment</tt> class. This constructor
     * initializes the fields as follows:
     * <p>
     * <table summary="Initialization Values">
     *  <tr>
     *      <th>Field</th>
     *      <th>Value</th>
     *  </tr>
     *  <tr>
     *      <td>Functional Group Acknowledgment Code</td>
     *      <td><tt>FGAcknowledgmentCode.ACCEPTED</tt></td>
     *  </tr>
     *  <tr>
     *      <td>Number of Transaction Sets Included</td>
     *      <td>0</td>
     *  </tr>
     *  <tr>
     *      <td>Number of Transaction Sets Received</td>
     *      <td>0</td>
     *  </tr>
     *  <tr>
     *      <td>Number of Accepted Transaction Sets</td>
     *      <td>0</td>
     *  </tr>
     *  <tr>
     *      <td>Functional Group Syntax Error Code</td>
     *      <td><code>new ArrayList&lt;&gt;();</code></td>
     *  </tr>
     * </table>
     */
    public FGResponseTrlr() {
        // Initialize our FGAcknowledgmentCode to "Accepted".
        this.AK901 = FGAcknowledgmentCode.ACCEPTED;
        
        // Initialize our Integer fields to 0.
        this.AK902 = 0;
        this.AK903 = 0;
        this.AK904 = 0;
        
        // Initialize our FGSyntaxErrorCode field to a new ArrayList.
        this.AK905 = new ArrayList<>();
    }
    //</editor-fold>
    
}
