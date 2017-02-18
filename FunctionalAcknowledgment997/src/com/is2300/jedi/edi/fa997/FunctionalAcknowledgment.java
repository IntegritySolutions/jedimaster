/* {FunctionalAcknowledgment.java}
 * 
 * Comprises class definitions for all of the segments typically found in a
 * Functional Acknowledgment (997) EDI document.
 * 
 * Copyright (C) 2017 Integrity Solutions
 *
 *    This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, either version 3 of the License, or
 *    (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.is2300.jedi.edi.fa997;

import com.is2300.jedi.edi.fa997.segments.DataElementNote;
import com.is2300.jedi.edi.fa997.segments.DataSegmentNote;
import com.is2300.jedi.edi.fa997.segments.FGResponseHdr;
import com.is2300.jedi.edi.fa997.segments.FGResponseTrlr;
import com.is2300.jedi.edi.fa997.segments.TSResponseHdr;
import com.is2300.jedi.edi.fa997.segments.TSResponseTrlr;
import com.is2300.jedi.edi.fa997.supl.EDIDocTypeValidator;
import com.is2300.jedi.edi.global.enums.DESyntaxErrorCode;
import com.is2300.jedi.edi.global.enums.SegmentSyntaxErrorCode;
import com.is2300.jedi.edi.global.enums.TSSyntaxErrorCode;
import com.is2300.jedi.edi.global.exceptions.InvalidDocTypeException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <h1>997 Functional Acknowledgment</h1>
 * <h2>Functional Group ID=FA</h2>
 * <h3>Introduction:</h3>
 * <p>This standard provides the format and establishes the data contents of a
 * functional acknowledgment transaction set. The purpose of this standard is to
 * define the control structures for a set of acknowledgments to indicate the
 * results of the syntactical analysis of the electronically encoded documents.
 * The encoded documents are the transaction sets, which are grouped in functional
 * groups, used in defining transactions for business data interchange. This
 * standard does not cover the semantic meaning of the information encoded in 
 * the transaction sets.</p>
 * <h3>Notes:</h3>
 * <h4>Sample with No Errors:</h4>
 * <table summary="Sample with No Errors">
 * <tr><td bgcolor="LightGrey"><tt>
 * ISA*00*        *00*         *09*005070479FF    *ZZ*X0000X0      *   
 * 93101*1020*U*00200*000000001*0*P*\@<br>
 * GS*FA*FF*X0000X0*931001*1030*000000004*X*003020@<br>
 * ST*997*0001@<br>
 * AK1*SH*000000001@<br>
 * AK2*856*000011111@<br>
 * AK5*A@<br>
 * AK9*A@<br>
 * SE*6*0001@<br>
 * GE*1*000000004@<br>
 * IEA*1*000000001@</tt></td></tr>
 * </table>
 * <h4>Sample with Errors:</h4>
 * <table summary="Sample with Errors"><tr><td bgcolor="LightGrey"><tt>
 * ISA*00*         *00*         *09*005070479ff    *ZZ*X0000X0     *   931001*1020*U*00200*000000001*0*P*\@<br>
 * GS*FA*ff*X0000X0*931001*1030*000000004*X*003020@<br>
 * ST*997*0001@<br>
 * AK1*SH*000000001@<br>
 * AK2*856*000011111@<br>
 * AK3*LIN*000035**1@<br>
 * AK4*2*0235*7@<br>
 * AK5*E*5@<br>
 * AK9*P*2*2*1*1@<br>
 * SE*8*0001@<br>
 * GE*1*000000004@<br>
 * IEA*1*000000001@</tt></td></tr>
 * </table>
 * <p>
 * <table summary="">
 *  <tr>
 *      <th> &nbsp; </th>
 *      <th>Pos. No.</th>
 *      <th>Seg. ID</th>
 *      <th>Name</th>
 *      <th>Req. Des.</th>
 *      <th>Max. Use</th>
 *      <th>Loop Repeat</th>
 *      <th>Notes and Comments</th>
 *      <th> &nbsp; </th>
 *      <th> &nbsp; </th>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td>005</td>
 *      <td>ISA</td>
 *      <td>Interchange Control Header</td>
 *      <td>O</td>
 *      <td>1</td>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td>008</td>
 *      <td>GS</td>
 *      <td>Functional Group Header</td>
 *      <td>O</td>
 *      <td>1</td>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td>M</td>
 *      <td>010</td>
 *      <td>ST</td>
 *      <td>Transaction Set Header</td>
 *      <td>M</td>
 *      <td>1</td>
 *      <td> &nbsp; </td>
 *      <td>n1</td>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td>M</td>
 *      <td>020</td>
 *      <td>AK1</td>
 *      <td>Functional Group Response Header</td>
 *      <td>M</td>
 *      <td>1</td>
 *      <td> &nbsp; </td>
 *      <td>n2</td>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td bgcolor="LightGrey">LOOP ID - AK2</td>
 *      <td bgcolor="LightGrey"> &nbsp; </td>
 *      <td bgcolor="LightGrey"> &nbsp; </td>
 *      <td bgcolor="LightGrey">999999</td>
 *      <td bgcolor="LightGrey"> &nbsp; </td>
 *      <td bgcolor="LightGrey"> &nbsp; </td>
 *      <td bgcolor="LightGrey"> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td>030</td>
 *      <td>AK2</td>
 *      <td>Transaction Set Response Header</td>
 *      <td>O</td>
 *      <td>1</td>
 *      <td> &nbsp; </td>
 *      <td>n3</td>
 *      <td> &nbsp; </td>
 *      <td bgcolor="LightGrey"> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td> &nbsp;</td>
 *      <td bgcolor="Lavender">LOOP ID - AK3</td>
 *      <td bgcolor="Lavender"> &nbsp;</td>
 *      <td bgcolor="Lavender"> &nbsp;</td>
 *      <td bgcolor="Lavender">999999</td>
 *      <td bgcolor="Lavender"> &nbsp; </td>
 *      <td bgcolor="Lavender"> &nbsp; </td>
 *      <td bgcolor="LightGrey"> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td>040</td>
 *      <td>AK3</td>
 *      <td>Data Segment Note</td>
 *      <td>O</td>
 *      <td>1</td>
 *      <td> &nbsp; </td>
 *      <td>c1</td>
 *      <td bgcolor="Lavender"> &nbsp; </td>
 *      <td bgcolor="LightGrey"> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td>050</td>
 *      <td>AK4</td>
 *      <td>Data Element Note</td>
 *      <td>O</td>
 *      <td>99</td>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td bgcolor="Lavender"> &nbsp; </td>
 *      <td bgcolor="LightGrey"> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td height="25%"> &nbsp; </td>
 *      <td height="25%"> &nbsp; </td>
 *      <td height="25%"> &nbsp; </td>
 *      <td height="25%" bgcolor="Lavender"> &nbsp; </td>
 *      <td height="25%" bgcolor="Lavender"> &nbsp; </td>
 *      <td height="25%" bgcolor="Lavender"> &nbsp; </td>
 *      <td height="25%" bgcolor="Lavender"> &nbsp; </td>
 *      <td height="25%" bgcolor="Lavender"> &nbsp; </td>
 *      <td height="25%" bgcolor="Lavender"> &nbsp; </td>
 *      <td height="25%" bgcolor="LightGrey"> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td>M</td>
 *      <td>060</td>
 *      <td>AK5</td>
 *      <td>Transaction Set Response Trailer</td>
 *      <td>M</td>
 *      <td>1</td>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td bgcolor="LightGrey"> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td height="25%"> &nbsp; </td>
 *      <td height="25%"> &nbsp; </td>
 *      <td height="25%"> &nbsp; </td>
 *      <td height="25%" bgcolor="LightGrey"> &nbsp; </td>
 *      <td height="25%" bgcolor="LightGrey"> &nbsp; </td>
 *      <td height="25%" bgcolor="LightGrey"> &nbsp; </td>
 *      <td height="25%" bgcolor="LightGrey"> &nbsp; </td>
 *      <td height="25%" bgcolor="LightGrey"> &nbsp; </td>
 *      <td height="25%" bgcolor="LightGrey"> &nbsp; </td>
 *      <td height="25%" bgcolor="LightGrey"> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td>M</td>
 *      <td>070</td>
 *      <td>AK9</td>
 *      <td>Functional Group Response Trailer</td>
 *      <td>M</td>
 *      <td>1</td>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td>M</td>
 *      <td>080</td>
 *      <td>SE</td>
 *      <td>Transaction Set Trailer</td>
 *      <td>M</td>
 *      <td>1</td>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td>090</td>
 *      <td>GE</td>
 *      <td>Functional Group Trailer</td>
 *      <td>O</td>
 *      <td>1</td>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td>100</td>
 *      <td>IEA</td>
 *      <td>Interchange Control Trailer</td>
 *      <td>O</td>
 *      <td>1</td>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *  </tr>
 * </table>
 * 
 * <h3>Transaction Set Notes</h3>
 * <ol>
 *  <li><p>These acknowledgments shall not be acknowledged, thereby preventing an
 *      endless cycle of acknowledgments of acknowledgments.</p>
 *      <p>The Functional Group Header Segment (GS) is used to start the 
 *      envelope for the Functional Acknowledgement Transaction Sets. In 
 *      preparing the functional group of acknowledgments, the application
 *      sender's code and the application receiver's code, taken from the
 *      functional group being acknowledged, are exchanged; therefore, on 
 *      acknowledgment functional group responds to only those functional groups
 *      from on application receiver's code to one application sender's code.
 *      </p></li>
 *  <li><p>AK1 is used to respond to the functional group header and to start
 *      the acknowledgment for a functional group. There shall be no AK1 segment
 *      for the functional group that is being acknowledged.</p></li>
 *  <li><p>AK2 is used to start the acknowledgemetn of a transaction set within
 *      the received functional group. The AK2 segments shall appear in the same
 *      order as the transaction sets in the functional group that has been 
 *      received and is being acknowledged.</p></li>
 * </ol>
 * 
 * <h3>Transaction Set Comments</h3>
 *  <ol>
 *      <li><p>The data segments of this standard are used to report the results
 *          of the syntactical analysis of the functional group of transaction
 *          sets; they report the extent to which the syntax complies with the
 *          standards for transaction sets and functional groups. They do not
 *          report on the semantic meaning of the transaction sets (for example,
 *          on the ability of the receiver to comply with the request of the
 *          sender).</p></li>
 * </ol>
 * 
 * @version <strong><em>Reference:</em></strong> CAT997MULTIPLEVERSIONS.TXT 
 *          (003020) Dated: June 29, 2009
 *
 * @author Sean Carrick &lt;<a href="mailto:PekinSOFT@outlook.com">
 * PekinSOFT@outlook.com</a>&gt;
 * @version <strong><em>Program:</em></strong> 0.5.0
 * @since 0.5.0
 */
public class FunctionalAcknowledgment {
    //<editor-fold desc=" Private Member Fields ">
    /**
     * An instance of the <tt>
     * {@link com.is2300.jedi.edi.fa997.segments.AK1Segment
     * AK1Segment}</tt> for storing the Functional Group Response Header
     * information from the incoming EDI file.
     */
    private FGResponseHdr ak1;
    /**
     * An instance of the <tt>
     * {@link com.is2300.jedi.edi.fa997.segments.AK2Segment
     * AK2Segment}</tt> for storing the Transaction Set Response Header 
     * information from the incoming EDI file.
     */
    private TSResponseHdr ak2;
    /**
     * A <tt><a href="http://docs.oracle.com/javase/8/docs/api/java/util/List.html">
     * java.util.List&lt;E&gt;</a></tt> of <tt>
     * {@link com.is2300.jedi.edi.fa997.segments.AK3Segment
     * AK3Segment}</tt> objects for storing the Data Segment Note information
     * from the incoming EDI file.
     * <p>
     * <table summary="note">
     *  <tr>
     *      <td bgcolor="LightGrey">There may be multiple instance of this
     *          segment in an EDI file, so this object is stored internally as
     *          a list of this object type.</td>
     *  </tr>
     * </table>
     */
    private List<DataSegmentNote> ak3;
    /**
     * A <tt><a href="http://docs.oracle.com/javase/8/docs/api/java/util/List.html">
     * java.util.List&lt;E&gt;</a></tt> of <tt>
     * {@link com.is2300.jedi.edi.fa997.segments.AK4Segment
     * AK4Segment}</tt> objects for storing the Data Element Note information
     * from the incoming EDI file.
     * <p>
     * <table summary="note">
     *  <tr>
     *      <td bgcolor="LightGrey">There may be multiple instance of this
     *          segment in an EDI file, so this object is stored internally as
     *          a list of this object type.</td>
     *  </tr>
     * </table>
     */
    private List<DataElementNote> ak4;
    /**
     * A <tt><a href="http://docs.oracle.com/javase/8/docs/api/java/util/List.html">
     * java.util.List&lt;E&gt;</a></tt> of <tt>
     * {@link com.is2300.jedi.edi.fa997.segments.AK5Segment
     * AK5Segment}</tt> objects for storing the Transaction Set Response Trailer
     * information from the incoming EDI file.
     * <p>
     * <table summary="note">
     *  <tr>
     *      <td bgcolor="LightGrey">There may be multiple instance of this
     *          segment in an EDI file, so this object is stored internally as
     *          a list of this object type.</td>
     *  </tr>
     * </table>
     */
    private List<TSResponseTrlr> ak5;
    /**
     * An instance of the <tt>
     * {@link com.is2300.jedi.edi.fa997.segments.AK9Segment
     * AK9Segment}</tt> for storing Functional Group Response Trailer 
     * information from the incoming EDI file.
     */
    private FGResponseTrlr ak9;
    //</editor-fold>
    
    //<editor-fold desc=" Constructor ">
    /**
     * Default constructor for the Functional Acknowledgment (997) EDI Document
     * Type.
     */
    public FunctionalAcknowledgment () {
        // Initiate our objects in the appropriate manner.
        this.ak1 = new FGResponseHdr();
        this.ak2 = new TSResponseHdr();
        this.ak3 = new ArrayList<>();
        this.ak4 = new ArrayList<>();
        this.ak5 = new ArrayList<>();
        this.ak9 = new FGResponseTrlr();
    }
    //</editor-fold>

    //<editor-fold desc=" Property Getters and Setters ">
    //<editor-fold desc="   AK1 Segment   ">
    /**
     * Stores the Functional Identifier Code (AK101) field value. This method
     * validates the data passed into it to enforce the data integrity.
     * 
     * @param id the Identification Code from the incoming EDI file. This field
     *           is mandatory and must be two (2) characters in length to be
     *           considered valid
     * 
     * @throws IllegalArgumentException if the data does not meet the validation
     *                                  rules listed above
     */
    public void setFunctionalID ( String id ) throws IllegalArgumentException {
        // First, we need to validate the data by the following rules:
        //+     * There _MUST_ be a value supplied because this field is
        //+       mandatory
        //+     * The length of the parameter _MUST_ be two (2) characters long
        //+
        //+ If the parameter does not meet these two requirements, we will throw
        //+ a new IllegalArgumentException explaining these problems.
        
        // Before checking our data, let's build our message that explains the
        //+ above rules.
        String msg = "The parameter id: " + id + ", is not valid.\n";
        msg += "The data must meet the following criteria:\n\n\t";
        msg += "* Mandatory element\n\t";
        msg += "* Must be two (2) characters in length\n\n";
        msg += "Please correct these errors and resubmit the data.";

        if ( id == null || id.length() == 0 ) {
            // The parameter contains no data, so throw the exception.
            throw new IllegalArgumentException(msg);
        } else {
            // We now know the data is valid, so we can store it.
            this.ak1.setFunctionalIdentifierCode(id);
        }
    }
    /**
     * Retrieves the previously set Functional Identification Code (AK101) field
     * value.
     * 
     * @return the Functional Identification Code for this Functional
     *         Acknowledgment
     */
    public String getFunctionalID () {
        return this.ak1.getFunctionalIdentifierCode();
    }
    /**
     * Stores the Group Control Number (AK102) field value. This method
     * validates the data passed into it to enforce the data integrity.
     * 
     * @param ctlNumber the Group Control Number from the incoming EDI file. 
     *                  This field is mandatory and must be greater than zero (0) 
     *                  to be considered valid
     * 
     * @throws IllegalArgumentException if the data does not meet the validation
     *                                  rules listed above
     */
    public void setGrpCtlNumber ( Integer ctlNumber ) 
            throws IllegalArgumentException {
        // This field needs to be validated by the following rules:
        //+     * This value is _MANDATORY_
        //+     * It _MUST_BE_GREATER_THAN zero (0)
        //+
        //+ If the parameter does not meet these two requirements, we will throw
        //+ a new IllegalArgumentException explaining these problems.
        
        // Before checking our data, let's build our message that explains the
        //+ above rules.
        String msg = "The parameter ctlNumber: " + ctlNumber;
        msg += ", is not valid.\n";
        msg += "The data must meet the following criteria:\n\n\t";
        msg += "* Mandatory element\n\t";
        msg += "* Must be two (2) characters in length\n\n";
        msg += "Please correct these errors and resubmit the data.";
        
        // Now, validate the provided data.
        if ( ctlNumber == null || ctlNumber <= 0 ) {
            // Throw our exception.
            throw new IllegalArgumentException(msg);
        } else {
            // Now that we know the data is valid, we can store it.
            this.ak1.setGroupControlNumber(ctlNumber);
        }
    }
    /**
     * Retrieves the previously stored Group Control Number (AK102) field value.
     * @return the Group Control Number for this Functional Acknowledgment
     */
    public Integer getGrpCtlNumber () {
        return this.ak1.getGroupControlNumber();
    }
    //</editor-fold>
    
    //<editor-fold desc="   AK2 Segment   ">
    /**
     * Stores the Group Control Number (AK102) field value. This method
     * validates the data passed into it to enforce the data integrity.
     * 
     * @param id the Transaction Set Identifier Code from the incoming EDI file. 
     *           This field is mandatory and must be greater than zero (0) to be
     *           considered valid
     * 
     * @throws IllegalArgumentException if the data does not meet the validation
     *                                  rules listed above
     * @throws InvalidDocTypeException if the provided document type is <strong>
     *                                 not</strong> a valid EDI Document Type
     */
    public void setTsIdentifier ( String id ) 
            throws IllegalArgumentException, InvalidDocTypeException {
        // This field needs to be validated by the following rules:
        //+     * The field is _MANDATORY_
        //+     * The value _MUST_BE_ three (3) characters in length
        //+     * The value _MUST_BE_ a valid EDI document type.
        //+
        //+ If the parameter does not meet these two requirements, we will throw
        //+ a new IllegalArgumentException explaining these problems.
        //+
        //+ Let's create a Validator so that we can be sure the document type is
        //+ a supported EDI Document type.
        EDIDocTypeValidator validDocType = new EDIDocTypeValidator();
        
        // Before checking our data, let's build our message that explains the
        //+ above rules.
        String msg = "The parameter id: " + id;
        msg += ", is not valid.\n";
        msg += "The data must meet the following criteria:\n\n\t";
        msg += "* Mandatory element\n\t";
        msg += "* Must be three (3) characters in length\n\n";
        msg += "Please correct these errors and resubmit the data.";
        
        // Now, validate the provided data.
        if ( id == null || id.length() != 3 ) {
            // Throw our exception.
            throw new IllegalArgumentException(msg);
        } else if ( !validDocType.validate(id) ) {
            // Throw our exception because this is not a valid document type.
            msg = "Document Type " + id + " is not a valid EDI document type.";
            throw new InvalidDocTypeException(msg);
        } else {
            // Now that we know the data is valid, we can store it.
            this.ak2.setTransactionSetIdentifierCode(id);
        }
    }
    /**
     * Retrieves the previously stored Transaction Set Identifier Code (AK201) 
     * field value.
     * 
     * @return the Transaction Set Identifier Code for this Functional 
     *         Acknowledgment
     */
    public String getTsIdentifier () {
        return this.ak2.getTransactionSetIdentifierCode();
    }
    /**
     * Stores the Transaction Set Control Number (AK202) field value. This 
     * method validates the data passed into it to enforce the data integrity.
     * 
     * @param ctlNumber the Transaction Set Control Number from the incoming EDI 
     *                  file. This field is mandatory and must be greater than 
     *                  or equal to four (4) characters in length to be 
     *                  considered valid
     * 
     * @throws IllegalArgumentException if the data does not meet the validation
     *                                  rules listed above
     */
    public void setTsControlNumber ( String ctlNumber ) 
            throws IllegalArgumentException {
        // This field needs to be validated by the following rules:
        //+     * This value is _MANDATORY_
        //+     * It _MUST_BE_GREATER_THAN zero (0)
        //+
        //+ If the parameter does not meet these two requirements, we will throw
        //+ a new IllegalArgumentException explaining these problems.
        
        // Before checking our data, let's build our message that explains the
        //+ above rules.
        String msg = "The parameter ctlNumber: " + ctlNumber;
        msg += ", is not valid.\n";
        msg += "The data must meet the following criteria:\n\n\t";
        msg += "* Mandatory element\n\t";
        msg += "* Must be four (4) characters in length\n\n";
        msg += "Please correct these errors and resubmit the data.";
        
        // Now, validate the provided data.
        if ( ctlNumber == null || ctlNumber.length() < 4 ) {
            // Throw our exception.
            throw new IllegalArgumentException(msg);
        } else {
            // Now that we know the data is valid, we can store it.
            this.ak2.setTransactionSetControlNumber(ctlNumber);
        }
    }
    /**
     * Retrieves the previously stored Transaction Set Control Number (AK202)
     * field value.
     * 
     * @return Transaction Set Control Number for this Functional Acknowledgment
     */
    public String getTsControlNumber () {
        return this.ak2.getTransactionSetControlNumber();
    }
    //</editor-fold>
    
    //<editor-fold desc="   AK3 Segment   ">
    /**
     * This method creates a new <tt>
     * {@link com.is2300.jedi.edi.fa997.segments.DataSegmentNote
     * DataSegmentNote}</tt> object, instantiates it with the provided data and
     * then adds it to the list of <tt>DataSegmentNote</tt> objects that this
     * class maintains.
     * 
     * @param segID the Segment ID Code (AK301) field value
     * @param pos the Segment Position in Transaction Set (AK302) field value
     * @param loopID the Loop Identifier Code (AK303) field value
     * @param err an <tt>
     * <a href="http://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Array.html">
     * Array</a></tt> of <tt>
     * {@link com.is2300.jedi.edi.global.enums.SegmentSyntaxErrorCode
     * SegmentSyntaxErrorCode}</tt> enumerations as pulled from the EDI file
     */
    public void setDataSegmentNote(String segID, Integer pos, String loopID, 
                                   SegmentSyntaxErrorCode[] err) {
        // First, we'll create a DataSegmentNote object for later use.
        DataSegmentNote seg = new DataSegmentNote();
        
        // Next, we need to add each of the parameters to the DataSegmentNote.
        seg.setLoopIdentifierCode(loopID);
        seg.setSegmentID(segID);
        
        // To add each of the SegmentSyntaxErrorCode enumerations into our
        //+ DataSegmentNote Syntax Error Code fields, we'll nee to run a loop.
        for (SegmentSyntaxErrorCode err1 : err) {
            seg.addSyntaxErrorCode(err1);
        }
        
        // Last thing to do is to add our local DataSegmentNote to our class-
        //+ level DataSegmentNote.
        this.ak3.add(seg);
    }
    /**
     * Retrieves the <tt>
     * {@link com.is2300.jedi.edi.fa997.segments.DataSegmentNote DataSegmentNote}
     * </tt> at the provided index.
     * 
     * @param idx the index of the <tt>DataSegmentNote</tt> to retrieve
     * @return com.is2300.jedi.edi.fa997.segments.DataSegmentNote
     */
    public DataSegmentNote getDataSegmentNote( int idx ) {
        return this.ak3.get(idx);
    }
    /**
     * Retrieves the <tt>
     * <a href="http://docs.oracle.com/javase/8/docs/api/java/util/List.html">
     * java.util.List</a></tt> of all of the <tt>
     * {@link com.is2300.jedi.edi.fa997.segments.DataSegmentNote DataSegmentNote}
     * </tt> objects in the list.
     * 
     * @return java.util.List&lt;DataSegmentNote&gt; list
     */
    public List<DataSegmentNote> getDataSegmentNotes() {
        return this.ak3;
    }
    /**
     * Retrieves the Segment ID Code (AK301) field value from the <tt>
     * {@link com.is2300.jedi.edi.fa997.segments.DataSegmentNote DataSegmentNote}
     * </tt> object in the <tt>java.util.List</tt> element identified by the
     * supplied index.
     * 
     * @param idx the index for which the desired Segment ID Code is to be pulled
     * @return java.lang.String
     */
    public String getSegmentID(int idx) {
        return this.ak3.get(idx).getSegmentID();
    }
    /**
     * Retrieves the Segment Position in Transaction Set (AK302) field value 
     * from the <tt>
     * {@link com.is2300.jedi.edi.fa997.segments.DataSegmentNote DataSegmentNote}
     * </tt> object in the <tt>java.util.List</tt> element identified by the
     * supplied index.
     * 
     * @param idx the index for which the desired Segment Position in Transaction
     *            Set is to be pulled
     * @return java.lang.Integer
     */
    public Integer getSegmentPosition(int idx) {
        return this.ak3.get(idx).getSegmentPosition();
    }
    /**
     * Retrieves the Loop Identifier Code (AK303) field value from the <tt>
     * {@link com.is2300.jedi.edi.fa997.segments.DataSegmentNote DataSegmentNote}
     * </tt> object in the <tt>java.util.List</tt> element identified by the
     * supplied index.
     * 
     * @param idx the index for which the desired Loop Identifier Code is to be 
     *            pulled
     * @return java.lang.String
     */
    public String getLoopID(int idx) {
        return this.ak3.get(idx).getLoopIdentifierCode();
    }
    /**
     * Retrieves the Segment Syntax Error Code (AK304) field value, as a
     * <tt>java.lang.String</tt> from the <tt>
     * {@link com.is2300.jedi.edi.fa997.segments.DataSegmentNote DataSegmentNote}
     * </tt> object in the <tt>java.util.List</tt> element identified by the
     * supplied index.
     * 
     * @param idx the index for which the desired Segment Syntax Error Code is 
     *            to be pulled
     * @param idc the index of the <tt>DataSegmentNote</tt> array to be returned
     *            as a <tt>java.lang.String</tt>
     * @return java.lang.String
     */
    public String getErrorAsString ( int idx, int idc ) {
        return this.ak3.get(idx).getErrorCodeString()[idc];
    }
    /**
     * Retrieves the count of Segment Syntax Error Code (AK304) field values
     * from the <tt>
     * {@link com.is2300.jedi.edi.fa997.segments.DataSegmentNote DataSegmentNote}
     * </tt> object in the <tt>java.util.List</tt> element identified by the
     * supplied index.
     * 
     * @param idx the index for which the desired Segment Syntax Error Code is 
     *            to be pulled
     * @return java.lang.String
     */
    public Integer getSegmentErrorCount( int idx) {
        return this.ak3.get(idx).getErrorCount();
    }
    //</editor-fold>
    
    //<editor-fold desc="   AK4 Segment   ">
    /**
     * Stores a new <tt>{@link com.is2300.jedi.edi.fa997.segments.DataElementNote
     * DataElementNote}</tt> into the <tt>java.util.List</tt>.
     * 
     * @param pos Element Position in Segment (AK401) field value
     * @param ref Data Element Reference Number (AK402) field value
     * @param err Data Element Syntax Error Code (AK403) DESyntaxErrorCode enum
     * @param copy Copy of Bad Data (AK404) field data
     */
    public void setDataElementNote(Integer pos, Integer ref, 
                                   DESyntaxErrorCode err, String copy) {
        // Add a new DataElementNote to our list.
        this.ak4.add(new DataElementNote(pos, ref, err, copy));        
    }
    /**
     * Retrieves the {@link com.is2300.jedi.edi.fa997.segments.DataElementNote
     * DataElementNote} object stored at the specified index in the list.
     * 
     * @param idx list index to retrieve
     * @return com.is2300.jedi.edi.fa997.segments.DataElementNote
     */
    public DataElementNote getDataElementNote(int idx) {
        return this.ak4.get(idx);
    }
    /**
     * Retrieves a list of all <tt>DataElementNote</tt>s.
     * 
     * @return 
     * <a href="http://docs.oracle.com/javase/8/docs/api/java/util/List.html">
     * java.util.List</a>&lt;DataElementNote&gt;
     */
    public List<DataElementNote> getDataElementNotes() {
        return this.ak4;
    }
    /**
     * Retrieves a <tt>java.util.Iterator</tt> on the <tt>java.util.List</tt>
     * of the <tt>DataElementNote</tt> object.
     * 
     * @return 
     * <a href="http://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html">
     * java.util.Iterator</a> on the <tt>java.util.List</tt> object
     */
    public Iterator getDataElementNotesIterator() {
        return this.ak4.iterator();
    }
    /**
     * Retrieves the Element Position in Segment (AK401) field value.
     * 
     * @param idx the index of the list item to return
     * @return java.lang.Integer
     */
    public Integer getElementPosition(int idx) {
        return this.ak4.get(idx).getElementPosition();
    }
    /**
     * Retrieves the Data Element Reference Number (AK402) field value from the
     * list.
     * 
     * @param idx the index of the list item to return
     * @return java.lang.Integer
     */
    public Integer getElementRefNumber(int idx) {
        return this.ak4.get(idx).getElementReference();
    }
    /**
     * Retrieves the Data Element Syntax Error Code (AK403) field value as a
     * {@link com.is2300.jedi.edi.global.enums.DESyntaxErrorCode 
     * DESyntaxErrorCode} enumeration object.
     * 
     * @param idx the index of the list item to return
     * @return DESyntaxErrorCode
     */
    public DESyntaxErrorCode getElementErrorCode(int idx) {
        return this.ak4.get(idx).getSyntaxErrorCode();
    }
    /**
     * Retrieves the Data Element Syntax Error Code (AK403) field value as a
     * <tt>java.lang.String</tt>.
     * 
     * @param idx the index of the list item to return
     * @return java.lang.String
     */
    public String getElementErrorAsString(int idx) {
        return this.ak4.get(idx).getSyntaxErrorCode().toString();
    }
    /**
     * Retrieves the Data Element Syntax Error Code (AK403) field value as a
     * <tt>java.lang.Integer</tt>.
     * 
     * @param idx the index of the list item to return
     * @return java.lang.Integer
     */
    public Integer getElementErrorAsInteger(int idx) {
        return this.ak4.get(idx).getSyntaxErrorCode().toInteger();
    }
    /**
     * Retrieves the Copy of Bad Data Element (AK404) field value.
     * 
     * @param idx the index of the list item to return
     * @return java.lang.String
     */
    public String getCopyOfBadData(int idx) {
        return this.ak4.get(idx).getCopyOfBadData();
    }
    //</editor-fold>
    
    //<editor-fold desc="   AK5 Segment   ">
    /**
     * Stores a new 
     * {@link com.is2300.jedi.edi.fa997.segments.TSResponseTrlr TSResponseTrlr}
     * into the list of the same.
     * 
     * @param code Transaction Set Acknowledgment Code (AK501) field value
     * @param err the corresponding TSSyntaxErrorCode to the Transaction Set
     *            Error Code (AK502) field value from the EDI transmission
     */
    public void setTsResponseTrlr(String code, TSSyntaxErrorCode[] err) {
        // Create a new TSResponseTrlr object
        TSResponseTrlr resp = new TSResponseTrlr();
        
        // Add our data to the trailer.
        resp.setTSetAcknowledgmentCode(code);
        
        // Loop through all of the errors passed in and store them to our
        //+ TSResponseTrlr object.
        for (TSSyntaxErrorCode error : err) {
            resp.addErrorCode(error);
        }
        
        // Lastly, add our local TSResponseTrailer to the list.
        this.ak5.add(resp);
    }
    /**
     * Retrieves the Transaction Set Acknowledgment Code for the Response Trailer
     * object indicated by the index value provided.
     * 
     * @param idx the index of the List item to return
     * @return <tt>java.lang.String</tt>
     */
    public String getAcknowledgmentCode(int idx) {
        // Return the Transaction Set Acknowledgment Code from the List element
        //+ the user requested.
        return this.ak5.get(idx).getTSetAcknowledgmentCode();
    }
    /**
     * Retrieves the <tt>Transaction Set Error Code</tt>s in <tt>String</tt> 
     * form from the List as an array.
     * 
     * @param idx the List element for which to retrieve the errors as Strings
     * @return an Array of java.lang.String objects
     */
    public String[] getTSetErrorAsString(int idx) {
       return this.ak5.get(idx).errorToString();
    }
    /**
     * Retrieves the <tt>Transaction Set Error Code</tt>s in <tt>Integer</tt>
     * form from the List as an array.
     * 
     * @param idx the List element for which to retrieve the errors as Integers
     * @return an Array of java.lang.Integer objects
     */
    public Integer[] getTSetErrorAsInteger(int idx) {
        return this.ak5.get(idx).errorToInteger();
    }
    /**
     * Retrieves an <tt>Iterator</tt> on the <tt>Transaction Set Error Code</tt>
     * object identified by the supplied index into the List.
     * 
     * @param idx the List element for which to retrieve the Iterator
     * @return a java.util.Iterator into the List of Error Codes
     */
    public Iterator getTSetErrorCodesIterator(int idx) {
        return this.ak5.get(idx).getErrorIterator();
    }
    //</editor-fold>
    
    //<editor-fold desc="   AK9 Segment   ">
    // TODO: Setters and Getters for AK9 segment
    //</editor-fold>
    //</editor-fold>
}
