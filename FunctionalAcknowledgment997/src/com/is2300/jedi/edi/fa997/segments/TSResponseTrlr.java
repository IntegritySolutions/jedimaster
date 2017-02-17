/* {TSResponseTrlr.java}
 * This class handles all things related to the Functional Acknowledgment (997)
 * Transaction Set Response Trailer (AK5) segment.
 *
 * Copyright (C) 2017 Sean Carrick
 *
 * This source code is protected by US and International Copyright 
 * Laws and Treaties. All code contained is proprietary information
 * and may not be divulged or disclosed to any third party without
 * the direct, written consent of the officers of Integrity Solutions.
 */

package com.is2300.jedi.edi.fa997.segments;

import com.is2300.jedi.edi.global.enums.TSSyntaxErrorCode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <table border="0" summary="">
 *  <tr>
 *      <td align="right"><strong>Segment:</strong></td>
 *      <td>AK5 Transaction Set Response Trailer</td>
 *  </tr>
 *  <tr>
 *      <td align="right"><strong>Position:</strong></td>
 *      <td>060</td>
 *  </tr>
 *  <tr>
 *      <td align="right"><strong>Loop:</strong></td>
 *      <td>AK2 : Optional</td>
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
 *      <td>To acknowledge acceptance or rejection and report errors in a
 *          transaction set</td>
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
 *      <td bgcolor="LightGrey">AK5*A@<br>
 *                              AK5*E*5@</td>
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
 *      <td><strong>AK501</strong></td>
 *      <td><strong>717</strong></td>
 *      <td><strong>Transaction Set Acknowledgment Code</strong></td>
 *      <td><strong>M &nbsp; ID 1/1</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>Code indicating accept or reject condition based on the syntax
 *          editing of the transaction set<br>
 *          <table summary="sub">
 *              <tr>
 *                  <td>A</td>
 *                  <td>Accepted</td>
 *              </tr>
 *              <tr>
 *                  <td>E</td>
 *                  <td>Accepted but Errors were Noted</td>
 *              </tr>
 *              <tr>
 *                  <td>R</td>
 *                  <td>Rejected</td>
 *              </tr>
 *          </table></td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td><strong>AK502</strong></td>
 *      <td><strong>718</strong></td>
 *      <td><strong>Transaction Set Syntax Error Code</strong></td>
 *      <td><strong>O &nbsp; ID 1/3</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>Code indicating error found based on the syntax editing of a 
 *          transaction set
 *      <td> &nbsp; </td>
 *  </tr>
 * <tr>
 *  <td> &nbsp; </td>
 *  <td> &nbsp; </td>
 *  <td bgcolor="LightGrey">See <tt>
 *      {@link net.integrity.jedi.edi.supl.enums.TSSyntaxErrorCode
 *      FATransactionSetSyntaxErrorCodes}</tt> for a listing of the available
 *      Transaction Set Syntax Error Codes.
 * </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td bgcolor="LightGrey">THIS LOOP CAN CONTINUE MULTIPLE TIMES: AK503,
 *          AK504, AK505, AK506, ETC.<br><br>
 *          <strong><em>Note:</em></strong> In the <tt>AK5Segment</tt> class,
 *          field AK503-AK50X are maintained in List&lt;AK503Segment&gt;
 *          objects.</td>
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
public class TSResponseTrlr {
    //<editor-fold desc=" Private Member Fields ">
    /**
     * <strong>Transaction Set Acknowledgment Code</strong> <em>Data Element:
     * </em> 717
     * <p>
     * <em>Required Length:</em> 1 Character<br>
     * <em>Element Style:</em> Identification<br>
     * <em>Usage:</em> <strong>Mandatory</strong>
     * <p>
     * Code indicating accept or reject condition based on the syntax editing of
     * the transaction set.
     * <table summary="AK501">
     *  <tr>
     *      <th>Code</th>
     *      <th>Meaning</th>
     *  </tr>
     *  <tr>
     *      <td>A</td>
     *      <td>Accepted</td>
     *  </tr>
     *  <tr>
     *      <td>E</td>
     *      <td>Accepted, but Errors were Noted</td>
     *  </tr>
     *  <tr> 
     *      <td>R</td>
     *      <td>Rejected</td>
     *  </tr>
     * </table>
     */
    private String AK501;   // Transaction Set Acknowledgment Code
    /**
     * <strong>Transaction Set Syntax Error Code</strong> <em>Data Element</em>
     * 718
     * <p>
     * <em>Required Length:</em> 1 Character (3 max)<br>
     * <em>Element Style:</em> Identification<br>
     * <em>Usage:</em> <em>Optional</em>
     * <p>
     * Code indicating error found based on the syntax editing of a transaction
     * set. This value is a member of the <tt>
     * {@link net.integrity.jedi.edi.supl.enums.TSSyntaxErrorCode
     * TSSyntaxErrorCode} enum</tt>. Also, this element is located within a loop
     * element, so there can be 0-X repetitions of this data, so we encapsulate
     * it in a <tt>
     * <a href="http://docs.oracle.com/javase/8/docs/api/java/util/List.html">
     * java.util.List</a> Interface</tt>.
     * <p>
     * <em><strong>See</strong> class overview for more details.</em>
     */
    private List<TSSyntaxErrorCode> AK502;  // Transaction Set Syntax Error Code
    //</editor-fold>
    
    //<editor-fold desc=" Constructor ">
    /**
     * Default constructor for the Transaction Set Response Trailer (AK5) 
     * segment of an EDI tranmission. This constructor initializes the member
     * fields to reasonable default values. However, this object will not be
     * useful until after calls to the property setter methods.
     */
    public TSResponseTrlr () {
        // Initialize our fields to reasonable values.
        this.AK501 = "";
        this.AK502 = new ArrayList<>();
    }
    //</editor-fold>
    
    //<editor-fold desc=" Property Getters and Setters ">
    /**
     * Stores the Transaction Set Acknowledgment Code (AK501) value of an EDI
     * transmission from the incoming EDI file being processed for later use.
     * 
     * @param ackCode the Transaction Set Acknowledgment Code value from EDI
     *                  file
     */
    public void setTSetAcknowledgmentCode ( String ackCode ) {
        this.AK501 = ackCode;
    }
    /**
     * Retrieves the Transaction Set Acknowledgment Code (AK501) value for an
     * EDI transmission.
     * 
     * @return the Transaction Set Acknowledgment Code that was saved earlier
     */
    public String getTSetAcknowledgmentCode () {
        return this.AK501;
    }
    /**
     * Adds a <tt>TSSyntaxErrorCode</tt> to the list of errors maintained.
     * 
     * @param code TSSyntaxErrorCode to add
     */
    public void addErrorCode(TSSyntaxErrorCode code) {
        this.AK502.add(code);
    }
    /**
     * Gets an <tt>
     * <a href="http://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html">
     * java.util.Iterator</a></tt> on the <tt>
     * {@link net.integrity.jedi.edi.supl.enums.TSSyntaxErrorCode
     * TSSyntaxErrorCode}</tt> enumeration so that it can be iterated over as:
     * <p>
     * <pre><code>
     * TSSyntaxErrorCode classObj = new TSSyntaxErrorCode();
     * 
     * for ( Iterator a = classObj.iterator(); a.hasNext() ) {
     *      // Get the java.lang.String representation of the Iterator a.
     *      a.next();
     *      String s = a.toString();
     *      
     *      // Check if this is the value you are looking for.
     *      if ( s.equals("Search Value") {
     *          // Do something with this knowledge...
     *      }
     * }
     * </code></pre>
     * @return a <tt>java.util.Iterator&lt;E&gt;</tt> on the 
     *          <tt>java.util.List</tt>
     */
    public Iterator<TSSyntaxErrorCode> getErrorIterator () {
        return this.AK502.iterator();
    }
    /**
     * Gets an array of the Transaction Set Syntax Error Codes in their 
     * <tt><a href="http://docs.oracle.com/javase/8/docs/api/java/lang/String.html">
     * java.lang.String</a></tt> representation form.
     * <p>
     * <strong>The returned array <em>may</em> have only <em>one (1)</em>
     *          element in it.</strong>
     * @return an array of <tt>java.lang.String</tt>s
     */
    public String[] errorToString () {
        // Create a new String array initialized to the size of the List.
        String[] s = new String[this.AK502.size()];
        int x = 0;  // a counter for the elements in the String array.
        
        for ( TSSyntaxErrorCode code : this.AK502 ) {
            // Assign the current code.toString() value to the array.
            s[x] = code.toString();
            x++;    // increment the element counter.
        }
        
        // Return the String array.
        return s;
    }
    /**
     * Gets an array of the Transaction Set Syntax Error Codes in their 
     * <tt><a href="http://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html">
     * java.lang.Integer</a></tt> representation form.
     * <p>
     * <strong>The returned array <em>may</em> have only <em>one (1)</em>
     *          element in it.</strong>
     * 
     * @return an array of <tt>java.lang.Integer</tt>s
     */
    public Integer[] errorToInteger () {
        // Create a new Integer array initialized to the size of the List.
        Integer[] i = new Integer[this.AK502.size()];
        int x = 0;  // a counter for the elements in the Integer array.
        
        for ( TSSyntaxErrorCode code : this.AK502 ) {
            // Assign the current code.toInteger() value to the array.
            i[x] = code.toInteger();
            x++;    // increment the element counter.
        }
        
        // Return the Integer array.
        return i;
    }
    /**
     * Returns the count of all errors that have been discovered and recorded.
     * 
     * @return the count of all recorded syntax errors
     */
    public int getErrorCount () {
        return this.AK502.size();
    }
    //</editor-fold>
    
}
