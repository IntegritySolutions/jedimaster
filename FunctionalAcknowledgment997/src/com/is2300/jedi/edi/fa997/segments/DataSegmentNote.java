/* {DataSegmentNote.java}
 * This class take care of all necessities for the Data Segment Note (AK3)
 * segments in a Functional Acknowledgment (997) document.
 *
 * Copyright (C) 2017 Integrity Solutions
 *
 * This source code is protected by US and International Copyright 
 * Laws and Treaties. All code contained is proprietary information
 * and may not be divulged or disclosed to any third party without
 * the direct, written consent of the officers of Integrity Solutions.
 */

package com.is2300.jedi.edi.fa997.segments;

import com.is2300.jedi.edi.global.enums.SegmentSyntaxErrorCode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <table border="0" summary="">
 *  <tr>
 *      <td align="right"><strong>Segment:</strong></td>
 *      <td>AK3 Data Segment Note</td>
 *  </tr>
 *  <tr>
 *      <td align="right"><strong>Position:</strong></td>
 *      <td>040</td>
 *  </tr>
 *  <tr>
 *      <td align="right"><strong>Loop:</strong></td>
 *      <td>AK3 : Optional</td>
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
 *      <td>To report errors in a data segment and identify the location of the
 *          data segment</td>
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
 *      <td bgcolor="LightGrey">AK3*LIN*000035**1@</td>
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
 *      <td><strong>AK301</strong></td>
 *      <td><strong>721</strong></td>
 *      <td><strong>Segment ID Code</strong></td>
 *      <td><strong>M &nbsp; ID 2/3</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>Code defining the segment ID of the data segment in error (See
 *          Appendix A - Number 77)</td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td bgcolor="LightGrey">SEGMENT CONTAINING THE ERROR</td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td><strong>AK302</strong></td>
 *      <td><strong>719</strong></td>
 *      <td><strong>Segment Position in Transaction Set</strong></td>
 *      <td><strong>M &nbsp; N0 1/6</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>The numerical count position of this data segment from the start of
 *          the transaction set: the transaction set header is count position 1
 *      </td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td bgcolor="LightGrey">NUMERICAL COUNT POSITION OF THIS DATA SEGMENT 
 *          FROM THE START OF THE TRANSACTION SET</td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td><strong>AK303</strong></td>
 *      <td><strong>447</strong></td>
 *      <td><strong>Loop Identifier Code</strong></td>
 *      <td><strong>O &nbsp; AN 1/4</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>Code identifying a loop within the transaction set which is bounded
 *          by the related LS and LE segments (corresponding LS and LE segments
 *          must have the same value for loop identifier). (Note: The loop ID
 *          number given on the transaction set diagram is recommended as the
 *          value for this data element in segments LS and LE.)</td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td bgcolor="LightGrey">LOOP WITHIN THE TRANSACTION SET</td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td><strong>AK304</strong></td>
 *      <td><strong>720</strong></td>
 *      <td><strong>Segment Syntax Error Code</strong></td>
 *      <td><strong>O &nbsp; ID 1/3</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>Code indicating error found based on the syntax editing of a segment
 *          <ol>
 *              <li>Unrecognized segment ID</li>
 *              <li>Unexpected segment</li>
 *              <li>Mandatory segment missing</li>
 *              <li>Loop Occurs Over Maximum Times</li>
 *              <li>Segment Exceeds Maximum Use</li>
 *              <li>Segment Not in Defined Transaction Set</li>
 *              <li>Segment Not in Proper Sequence</li>
 *          </ol></td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td bgcolor="LightGrey">THIS LOOP CAN CONTINUE MULTIPLE TIMES: AK305,
 *          AK306, AK307, AK308, ETC.<br><br>
 *          <strong><em>Note:</em></strong> In the <tt>AK3Segment</tt> class,
 *          field AK303 and AK304 are maintained in List&lt;AK303Segment&gt;
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
public class DataSegmentNote {
    //<editor-fold desc=" Private Member Fields ">
    /**
     * <strong>Segment ID Code</strong> <em>Data Element:</em> 721
     * <p>
     * <em>Required Length:</em> 2 Characters (3 max)<br>
     * <em>Element Style:</em> Identification<br>
     * <em>Usage:</em> <strong>Mandatory</strong>
     * <p>
     * Code defining the segment ID of the data segment in error (See Appendix 
     * A - Number 77).
     * <p>
     * <strong>NOTE:</strong> Segment containing the error.
     */
    private String AK301;       // Segment ID Code
    /**
     * <strong>Segment Position in Transaction Set</strong> <em>Data Element</em>
     * 719
     * <p>
     * <em>Required Length:</em> 1 Character (6 max)<br>
     * <em>Element Style:</em> Numerical, Zero-filled<br>
     * <em>Usage:</em> <strong>Mandatory</strong>
     * <p>
     * The numerical count position of this data element from the start of the
     * transaction set: the transaction set control header is count position 1.
     */
    private Integer AK302;       // Segment Position in Transaction Set
    /**
     * <strong>Loop Identifier Code</strong> <em>Data Element</em> 447
     * <p>
     * <em>Required Length:</em> 1 Character (4 max)<br>
     * <em>Element Style:</em> Alphanumeric<br>
     * <em>Usage:</em> <em>Optional</em>
     * <p>
     * Code identifying a loop within the transaction set which is bounded by
     * the related LS and LE segments (corresponding LS and LE segments must
     * have the same value for loop identifier). (Note: The loop ID number 
     * given on the transaction set diagram is recommended as the value for this
     * data element in segments LS and LE.)
     */
    private String AK303;       // Loop Identifier Code
    /**
     * <strong>Segment Syntax Error Code</strong> <em>Data Element:</em> 720
     * <p>
     * <em>Required Length:</em> 1 Character (3 max)<br>
     * <em>Element Style:</em> Identification<br>
     * <em>Usage:</em> <em>Optional</em>
     * <p>
     * Code indicating error found based on the syntax editing of a segment.
     * <p>
     * See {@link net.integrity.jedi.edi.supl.enums.SegmentSyntaxErrorCode
     * FASegmentSyntaxErrorCode} for more details.
     * 
     * @see net.integrity.jedi.edi.supl.enums.SegmentSyntaxErrorCode
     */
    private List<SegmentSyntaxErrorCode> AK304; // Segment Syntax Error Code
    //</editor-fold>
    
    //<editor-fold desc=" Property Getters and Setters ">
    /**
     * Retrieves the value of the Segment ID Code (AK301) field.
     * @return the Segment ID Code (AK301)
     */
    public String getSegmentID() {
        return AK301;
    }
    /**
     * Stores the value of the Segment ID Code (AK301) from the incoming EDI
     * file for later use.
     * @param segmentID the Segment ID Code (AK301) from the EDI file
     */
    public void setSegmentID(String segmentID) {
        this.AK301 = segmentID;
    }
    /**
     * Retrieves the value of the Segment Position in Transaction Set (AK302) 
     * field.
     * @return the Segment Position in Transaction Set (AK302)
     */
    public Integer getSegmentPosition() {
        return AK302;
    }
    /**
     * Stores the value of the Segment Position in Transaction Set (AK302) from
     * the incoming EDI file for later use.
     * @param segmentPosition The Segment Position in Transaction Set (AK302)
     *                        from the EDI file
     */
    public void setSegmentPosition(Integer segmentPosition) {
        this.AK302 = segmentPosition;
    }
    /**
     * Retrieves the value of the Loop Identifier Code (AK303) field.
     * @return the Loop Identifier Code (AK303)
     */
    public String getLoopIdentifierCode() {
        return AK303;
    }
    /**
     * Store the value of the Loop Identifier Code (AK303) from the incoming EDI
     * file for later use.
     * @param loopID the Loop Identifier Code (AK303)
     */
    public void setLoopIdentifierCode(String loopID) {
        this.AK303 = loopID;
    }
    /**
     * Retrieves a <tt>
     * <a href="http://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html">
     * java.util.Iterator</a></tt> for the <tt>
     * <a href="http://docs.oracle.com/javase/8/docs/api/java/util/List.html">
     * java.util.List</a></tt> on the <tt>AK3Segment.AK304</tt> (Segment Syntax 
     * Error Code) field.
     * <p>
     * This <tt>Iterator</tt> may be used to loop through all of the Segment
     * Syntax Error Codes that are listed for the Functional Acknowledgment
     * (997) document.
     * @return <tt>Iterator</tt> on the <tt>List</tt> for the Segment Syntax
     *         Error Codes
     */
    public Iterator<SegmentSyntaxErrorCode> getSyntaxErrorCodeIterator() {
        return AK304.iterator();
    }
    /**
     * Adds an <tt>
     * {@link net.integrity.jedi.edi.supl.enums.SegmentSyntaxErrorCode
     * FASegmentSyntaxErrorCode}</tt> to the <tt>
     * <a href="http://docs.oracle.com/javase/8/docs/api/java/util/List.html">
     * java.util.List</a></tt> of Segment Syntax Error Codes.
     * @param errorCode <tt>FASegmentSyntaxErrorCode</tt> to add to the <tt>
     *                  java.util.List</tt>
     */
    public void addSyntaxErrorCode(SegmentSyntaxErrorCode errorCode) {
        this.AK304.add(errorCode);
    }
    /**
     * Gets an array of the Segment Syntax Error Codes in their <tt>
     * <a href="http://docs.oracle.com/javase/8/docs/api/java/lang/String.html">
     * java.lang.String</a></tt> representation form.
     * <p>
     * <strong>The returned array <em>may</em> have only <em>one (1)</em>
     *          element in it.</strong>
     * @return an array of <tt>java.lang.String</tt>s
     */
    public String[] getErrorCodeString () {
        // Create a new String array initialized to the size of the List.
        String[] s = new String[this.AK304.size()];
        int x = 0;  // a counter for the elements in the String array.
        
        for ( SegmentSyntaxErrorCode code : this.AK304 ) {
            // Assign the current code.toString() value to the array.
            s[x] = code.toString();
            x++;    // increment the element counter.
        }
        
        // Return the String array.
        return s;
    }
    /**
     * Gets an array of the Segment Syntax Error Codes in their <tt>
     * <a href="http://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html">
     * java.lang.Integer</a></tt> representation form.
     * <p>
     * <strong>The returned array <em>may</em> have only <em>one (1)</em>
     *          element in it.</strong>
     * 
     * @return an array of <tt>java.lang.Integer</tt>s
     */
    public Integer[] errorToInteger () {
        // Create a new Integer array initialized to the size of the List.
        Integer[] i = new Integer[this.AK304.size()];
        int x = 0;  // a counter for the elements in the Integer array.
        
        for ( SegmentSyntaxErrorCode code : this.AK304 ) {
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
        return this.AK304.size();
    }
    //</editor-fold>
    
    //<editor-fold desc=" Constructors ">
    /**
     * Creates a default instance of the <tt>AK3Segment</tt> class.
     * <p>
     * With this constructor, all fields <tt>AK301</tt> through <tt>AK303</tt>
     * are instantiated as <tt>null</tt> and the <tt>AK304</tt> is initialized
     * as a new <tt><a href="http://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html">
     * ArrayList</a>&lt;{@link 
     * net.integrity.jedi.edi.supl.enums.SegmentSyntaxErrorCode
     * FASegmentSyntaxErrorCode}&gt;</tt> object.
     * <p>
     * Once the <tt>AK3Segment</tt> object is created, the property setters will
     * need to be called to populate the data.
     * 
     * @see <a href="http://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html">
     * ArrayList&lt;E&gt;</a>
     * @see net.integrity.jedi.edi.supl.enums.SegmentSyntaxErrorCode
     */
    public DataSegmentNote () {
        this.AK301 = null;  // Nullified instantiation
        this.AK302 = null;  // Nullified instantiation
        this.AK303 = null;  // Nullified instantiation
        this.AK304 = new ArrayList<>(); // New object.
    }
    //</editor-fold>
}
