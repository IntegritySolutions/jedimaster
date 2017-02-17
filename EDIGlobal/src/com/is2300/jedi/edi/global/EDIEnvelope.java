/* {EDIEnvelope.java}
 * This class maintains and manages all data related to EDI Interchange Envelopes
 * including, but not limited to, storing the data, validating the interchange,
 * functional group and transaction set, as well as providing methods for
 * comparing key information between header and trailers.
 *
 * Copyright (C) 2017 Integrity Solutions
 *
 * This source code is protected by US and International Copyright 
 * Laws and Treaties. All code contained is proprietary information
 * and may not be divulged or disclosed to any third party without
 * the direct, written consent of the officers of Integrity Solutions.
 */
package com.is2300.jedi.edi.global;

import com.is2300.jedi.edi.global.supl.FunctionalGrpHdr;
import com.is2300.jedi.edi.global.supl.FunctionalGrpTrlr;
import com.is2300.jedi.edi.global.supl.InterchangeCtlHdr;
import com.is2300.jedi.edi.global.supl.InterchangeCtlTrlr;
import com.is2300.jedi.edi.global.supl.TransactionSetHdr;
import com.is2300.jedi.edi.global.supl.TransactionSetTrlr;

/**
 * Wrapper class which includes the following classes:
 * <ul>
 *  <li>{@link net.integrity.jedi.edi.supl.InterchangeCtlHdr InterchangeCtlHdr}
 *      <p>The responsible class for Interchange Control Header data.</p></li>
 *  <li>{@link net.integrity.jedi.edi.supl.FunctionalGrpHdr FunctionalGrpHdr}
 *      <p>The responsible class for Functional Group Control Header data.</p></li>
 *  <li>{@link net.integrity.jedi.edi.supl.TransactionSetHdr TransactionSetHdr}
 *      <p>The responsible class for Transaction Set Control Header data.</p></li>
 *  <li>{@link net.integrity.jedi.edi.supl.TransactionSetTrlr TransactionSetTrlr}
 *      <p>The responsible class for Transaction Set Control Trailer data.</p></li>
 *  <li>{@link net.integrity.jedi.edi.supl.FunctionalGrpTrlr FunctionalGrpTrlr}
 *      <p>The responsible class for Functional Group Control Trailer data.</p></li>
 *  <li>{@link net.integrity.jedi.edi.supl.InterchangeCtlTrlr InterchangeCtlTrlr}
 *      <p>The responsible class for Interchange Control Trailer data.</p></li>
 * </ul>
 * <p>
 * This class provides methods for validating the trailers to the headers of the
 * various sections of an EDI document listed above. By performing this data
 * validation, the program can be certain that the data received is the same as
 * the data that was sent by the trading partner.
 * <p>
 * Furthermore, this class provides the methods required to set up and maintain
 * an audit trail of all EDI transmissions received and sent between the two
 * trading partners, based upon the trading partner identification numbers 
 * contained within the EDI transmissions.
 *
 * @author Sean Carrick
 * @version 0.5.0
 * @since 0.5.0
 */
public class EDIEnvelope {
    //<editor-fold desc=" Private Member Fields ">
    /**
     * An Interchange Control Header (ISA) segment which contains the required
     * data for identifying a specific envelope within the EDI transmission.
     * <p>
     * Per EDI reference materials on
     * {@link net.integrity.jedi.edi.supl.InterchangeCtlHdr InterchangeCtlHdr}, 
     * the Interchange Control Header is an <em>Optional</em> segment and may 
     * not be present in an EDI transmission. Alternatively, there may be 
     * <em>more than</em> one (1) Interchange Control Header segment within a 
     * single EDI transmission file, though there will need to be an Interchange 
     * Control Trailer segment <strong><em>prior to</em></strong> an additional 
     * Interchange Control Header being present.
     */
    private InterchangeCtlHdr isa;
    /**
     * A Functional Group Header (GS) segment which contains the required data
     * for identifying a specific sub-envelope of similar document types within
     * the EDI transmission.
     * <p>
     * Per EDI reference materials on
     * {@link net.integrity.jedi.edi.supl.FunctionalGrpHdr FunctionalGrpHdr},
     * the Functional Group Header is an <em>Optional</em> segment and may not
     * be present in an EDI transmission. Alternatively, there may be <em>more
     * than</em> one (1) Functional Group Header segment within a single EDI
     * transmission file, though there will need to be a Functional Group
     * Trailer segment <strong><em>prior to</em></strong> an additional 
     * Functional Group Header being present.
     */
    private FunctionalGrpHdr gs;
    /**
     * A Transaction Set Header (ST) segment which contains the required data
     * for identifying a specific document type transaction within the EDI
     * transmission.
     * <p>
     * Per EDI reference materials on
     * {@link net.integrity.jedi.edi.supl.TransactionSetHdr TransactionSetHdr},
     * the Transaction Set Header is a <em>Required</em> segment and will always
     * be present within an EDI transmission. The Transaction Set provides for
     * the type of document being transmitted between the ST and SE segments, as
     * well as all the required data for that document type. There will be <em>
     * at least</em> one (1) Transaction Set included within an EDI transmission
     * and could be <em>multiple</em> Transaction Sets in a single EDI
     * transmission.
     */
    private TransactionSetHdr st;
    /**
     * A Transaction Set Trailer (SE) segment which closes out the required data
     * for identifying a specific document type transaction within the EDI
     * transmission, and provides for validating that a Transaction Set is 
     * complete.
     * <p>
     * Per EDI reference materials on
     * {@link net.integrity.jedi.edi.supl.TransactionSetTrlr TansactionSetTrlr},
     * the Transaction Set Trailer is a <em>Required</em> segment and there will
     * need to be one (1) Transaction Set Trailer (SE) segment for each
     * Transaction Set Header (ST) segment, with no intervening SE or ST segments
     * between them. In other words, after an ST segment is discovered, there
     * <em>may not</em> be any other ST segments <em>prior to</em> an SE segment.
     */
    private TransactionSetTrlr se;
    /**
     * A Functional Group Trailer (GE) segment which closes out the required 
     * data identifying a specific sub-envelope of document types within the EDI
     * transmission, and provides for validating that a Functional Group is
     * complete.
     * <p>
     * Per EDI reference materials on
     * {@link net.integrity.jedi.edi.supl.FunctionalGrpTrlr FunctionalGrpTrlr},
     * the Functional Group Trailer is an <em>Optional</em> segment, but <em>
     * must be</em> present if there is a Functional Group Header (GS) segment
     * within the EDI transmission. Furthermore, for each Functional Group
     * Header segment, there <em>must be</em> a Functional Group Trailer segment
     * present, with no intervening Functional Group Header segments.
     */
    private FunctionalGrpTrlr ge;
    /**
     * An Interchange Control Trailer (IEA) segment which closes out the required
     * data identifying a specific envelope of functional groups within the EDI
     * transmission, and provides for validating that an Interchange is complete.
     * <p>
     * Per EDI reference materials on
     * {@link net.integrity.jedi.edi.supl.InterchangeCtlTrlr InterchangeCtlTrlr},
     * the Interchange Control Trailer is an <em>Optional</em> segment, but
     * <em>must be</em> present if there is an Interchange Control Header (ISA)
     * segment within the EDI transmission. Furthermore, for each Interchange
     * Control Header segment, there <em>must be</em> an Interchange Control
     * Trailer segment present, with no intervening Intechange Control Header
     * segments.
     */
    private InterchangeCtlTrlr iea;
    //</editor-fold>
    
    //<editor-fold desc=" ISA Interchange Getters and Setters ">
    /**
     * Stores the Authorization Information Qualifier (ISA01) segment field
     * value for later use. This field is <strong> mandatory</strong> and 
     * <strong>must be</strong> a total of <em>two (2) characters</em> in 
     * length.
     * 
     * @param qualifier the Authorization Information Qualifier from the 
     *                  incoming EDI file
     * @throws IllegalArgumentException if the data provided does not meet the
     *                  requirements listed above
     */
    public void setAuthorizationQual(String qualifier) 
            throws IllegalArgumentException {
        // First, we need to validate the data by the following rules:
        //+     * There _MUST_ be a value supplied because this field is
        //+       mandatory
        //+     * The length of the parameter _MUST_ be two (2) characters long
        //+
        //+ If the parameter does not meet these two requirements, we will throw
        //+ a new IllegalArgumentException explaining these problems.
        
        // Before checking our data, let's build our message that explains the
        //+ above rules.
        String msg = "The parameter qualifier: " + qualifier + ", is not valid.\n";
        msg += "The data must meet the following criteria:\n\n\t";
        msg += "* Mandatory element\n\t";
        msg += "* Must be two (2) characters in length\n\n";
        msg += "Please correct these errors and resubmit the data.";

        if ( qualifier == null || qualifier.length() != 2 ) {
            // The parameter contains no data, so throw the exception.
            throw new IllegalArgumentException(msg);
        } else {
            // We now know the data is valid, so we can store it.
            this.isa.setAuthInfoQualifier(qualifier);
        }
    }
    /**
     * Retrieves the Authorization Information Qualifier (ISA01) data that was
     * previously stored.
     * 
     * @return the Authorization Information Qualifier value
     */
    public String getAuthorizationQual() {
        return this.isa.getAuthInfoQualifier();
    }
    /**
     * Stores the Authorization Information (ISA02) field data from the incoming
     * EDI file. This field is <strong> mandatory</strong> and <strong>must be
     * </strong> a total of <em>ten 10) characters</em> in length. 
     * @param info the Authorization Information (ISA04) from the EDI file
     * @throws IllegalArgumentException if the data provided does not meet the 
     *              requirements listed above
     */
    public void setAuthorizationInfo(String info) 
            throws IllegalArgumentException {
        // First, we need to validate the data by the following rules:
        //+     * There _MUST_ be a value supplied because this field is
        //+       mandatory
        //+     * The length of the parameter _MUST_ be ten (10) characters long
        //+
        //+ If the parameter does not meet these two requirements, we will throw
        //+ a new IllegalArgumentException explaining these problems.
        
        // Before checking our data, let's build our message that explains the
        //+ above rules.
        String msg = "The parameter auth: " + info + ", is not valid.\n";
        msg += "The data must meet the following criteria:\n\n\t";
        msg += "* Mandatory element\n\t";
        msg += "* Must be two (2) characters in length\n\n";
        msg += "Please correct these errors and resubmit the data.";

        if ( info == null || info.length() != 10 ) {
            // The parameter contains no data, so throw the exception.
            throw new IllegalArgumentException(msg);
        } else {
            // We now know the data is valid, so we can store it.
            this.isa.setAuthInfo(info);
        }
    }
    /**
     * Retrieves the previously stored Authorization Information (ISA02) field
     * data.
     * 
     * @return the Authorization Information value
     */
    public String getAuthorizationInfo() {
        return this.isa.getAuthInfo();
    }
    /**
     * Stores the Security Information Qualifier (ISA03) segment field
     * value for later use. This field is <strong> mandatory</strong> and 
     * <strong>must be</strong> a total of <em>two (2) characters</em> in 
     * length.
     * 
     * @param qualifier the Security Information Qualifier from the 
     *                  incoming EDI file
     * @throws IllegalArgumentException if the data provided does not mee the
     *                  requirements listed above
     */
    public void setSecurityQual(String qualifier) throws IllegalArgumentException {
        // First, we need to validate the data by the following rules:
        //+     * There _MUST_ be a value supplied because this field is
        //+       mandatory
        //+     * The length of the parameter _MUST_ be two (2) characters long
        //+
        //+ If the parameter does not meet these two requirements, we will throw
        //+ a new IllegalArgumentException explaining these problems.
        
        // Before checking our data, let's build our message that explains the
        //+ above rules.
        String msg = "The parameter qualifier: " + qualifier + ", is not valid.\n";
        msg += "The data must meet the following criteria:\n\n\t";
        msg += "* Mandatory element\n\t";
        msg += "* Must be two (2) characters in length\n\n";
        msg += "Please correct these errors and resubmit the data.";

        if ( qualifier == null || qualifier.length() != 2 ) {
            // The parameter contains no data, so throw the exception.
            throw new IllegalArgumentException(msg);
        } else {
            // We now know the data is valid, so we can store it.
            this.isa.setSecInfoQualifier(qualifier);
        }
    }
    /**
     * Retrieves the previously stored Security Information Qualifier (ISA03)
     * field value.
     * 
     * @return the Security Information Qualifier value
     */
    public String getSecurityQual() {
        return this.isa.getSecInfoQualifier();
    }
    /**
     * Stores the Security Information (ISA04) field data from the incoming EDI
     * file for later use. This field is <strong>mandatory</strong> and <strong>
     * must be</strong> <em>ten (10) characters</em> in length.
     * 
     * @param info the Security Information value
     * @throws IllegalArgumentException if the data provided does not meet the
     *              requirements listed above
     */
    public void setSecurityInfo(String info) throws IllegalArgumentException {
        // First, we need to validate the data by the following rules:
        //+     * There _MUST_ be a value supplied because this field is
        //+       mandatory
        //+     * The length of the parameter _MUST_ be two (2) characters long
        //+
        //+ If the parameter does not meet these two requirements, we will throw
        //+ a new IllegalArgumentException explaining these problems.
        
        // Before checking our data, let's build our message that explains the
        //+ above rules.
        String msg = "The parameter info: " + info + ", is not valid.\n";
        msg += "The data must meet the following criteria:\n\n\t";
        msg += "* Mandatory element\n\t";
        msg += "* Must be ten (10) characters in length\n\n";
        msg += "Please correct these errors and resubmit the data.";

        if ( info == null || info.length() != 10 ) {
            // The parameter contains no data, so throw the exception.
            throw new IllegalArgumentException(msg);
        } else {
            // We now know the data is valid, so we can store it.
            this.isa.setSecInfo(info);
        }
    }
    /**
     * Retrieves the Security Information (ISA04) field data that was previously
     * stored.
     * 
     * @return the Security Information value
     */
    public String getSecurityInfo() {
        return this.isa.getSecInfo();
    }
    /**
     * Stores the Interchange ID Qualifier (ISA05) segment field
     * value for later use. This field is <strong> mandatory</strong> and 
     * <strong>must be</strong> a total of <em>two (2) characters</em> in 
     * length.
     * 
     * @param qualifier the Interchange ID Qualifier from the  incoming EDI file
     * @param field one of either 5 or 7 for which field this data is assigned
     *              (ISA05 or ISA07 respectively)
     * @throws IllegalArgumentException if the data provided does not meet the
     *                  requirements listed above for either of the two (2)
     *                  parameters required
     */
    public void setInterchangeIDQual(String qualifier, int field) 
            throws IllegalArgumentException {
        // First, we need to validate the data by the following rules:
        //+     * There _MUST_ be a value supplied because this field is
        //+       mandatory
        //+     * The length of the parameter _MUST_ be two (2) characters long
        //+
        //+ If the parameter does not meet these two requirements, we will throw
        //+ a new IllegalArgumentException explaining these problems.
        
        // Before checking our data, let's build our message that explains the
        //+ above rules.
        String msg = "The parameter qualifier: " + qualifier + ", is not valid.\n";
        msg += "The data must meet the following criteria:\n\n\t";
        msg += "* Mandatory element\n\t";
        msg += "* Must be two (2) characters in length\n\n";
        msg += "Please correct these errors and resubmit the data.";

        if ( qualifier == null || qualifier.length() != 2 ) {
            // The parameter contains no data, so throw the exception.
            throw new IllegalArgumentException(msg);
        } else {
            // We now know the data is valid, so we can store it, after we 
            //+ determine which field to store it in.
            switch (field) {
                case 5:
                    this.isa.setIdQualifier05(qualifier);
                    break;
                case 7:
                    this.isa.setIdQualifier07(qualifier);
                    break;
                default:
                    // An invalid field value was passed in, so throw our 
                    //+ Exception.
                    msg = "The parameter field (value: " + field + ") is not "
                            + "valid.";
                    msg += "\nThe value for field needs to be either 5 or 7 "
                            + "only.\n";
                    msg += "\nUnable to use the supplied field value.";
                    throw new IllegalArgumentException(msg);
            }
        }
    }
    /**
     * Retrieves the value of the Interchange ID Qualifier (ISA05 and ISA07)
     * field value, determined by the field provided.
     * 
     * @param field which field, ISA05 or ISA07, is of interest
     * @return the Interchange ID Qualifier from the appropriate field or <tt>
     *         null</tt> if the parameter <tt>field</tt> does not specify either
     *         5 nor 7
     */
    public String getInterchangeIDQual(int field) {
        // Create a return value holder and set it to the default of null.
        String retVal = null;
        
        // Check to see which field's information the user is after.
        if ( field == 5 ) {
            retVal = this.isa.getIdQualifier05();
        } else if ( field == 7 ) {
            retVal = this.isa.getIdQualifer07();
        }
        
        // Return our return value.
        return retVal;
    }
    /**
     * Stores the Interchange Sender ID (ISA06) field value from the incoming 
     * EDI file for later use. This field is <strong>mandatory</strong> and
     * <strong>must be</strong> <em>fifteen (15) characters</em> in length.
     * 
     * @param id the Interchange Sender ID value from the EDI file
     * @throws IllegalArgumentException if the data does not meet the 
     *           requirements listed above
     */
    public void setSenderID(String id) throws IllegalArgumentException {
        // First, we need to validate the data by the following rules:
        //+     * There _MUST_ be a value supplied because this field is
        //+       mandatory
        //+     * The length of the parameter _MUST_ be fifteen (15) characters 
        //+       long
        //+
        //+ If the parameter does not meet these two requirements, we will throw
        //+ a new IllegalArgumentException explaining these problems.
        
        // Before checking our data, let's build our message that explains the
        //+ above rules.
        String msg = "The parameter id: " + id + ", is not valid.\n";
        msg += "The data must meet the following criteria:\n\n\t";
        msg += "* Mandatory element\n\t";
        msg += "* Must be ten (10) characters in length\n\n";
        msg += "Please correct these errors and resubmit the data.";

        if ( id == null || id.length() != 10 ) {
            // The parameter contains no data, so throw the exception.
            throw new IllegalArgumentException(msg);
        } else {
            // We now know the data is valid, so we can store it.
            this.isa.setSenderId(id);
        }
    }
    /**
     * Retrieves the Interchange Sender ID (ISA06) field value that was 
     * previously stored.
     * 
     * @return the Interchange Sender ID value
     */
    public String getSenderID() {
        return this.isa.getSenderId();
    }
    /**
     * Stores the Interchange Receiver ID (ISA08) field value from the incoming 
     * EDI file for later use. This field is <strong>mandatory</strong> and
     * <strong>must be</strong> <em>fifteen (15) characters</em> in length.
     * 
     * @param id the Interchange Receiver ID value from the EDI file
     * @throws IllegalArgumentException if the data does not meet the 
     *           requirements listed above
     */
    public void setReceiverID(String id) throws IllegalArgumentException {
        // First, we need to validate the data by the following rules:
        //+     * There _MUST_ be a value supplied because this field is
        //+       mandatory
        //+     * The length of the parameter _MUST_ be fifteen (15) characters 
        //+       long
        //+
        //+ If the parameter does not meet these two requirements, we will throw
        //+ a new IllegalArgumentException explaining these problems.
        
        // Before checking our data, let's build our message that explains the
        //+ above rules.
        String msg = "The parameter id: " + id + ", is not valid.\n";
        msg += "The data must meet the following criteria:\n\n\t";
        msg += "* Mandatory element\n\t";
        msg += "* Must be ten (10) characters in length\n\n";
        msg += "Please correct these errors and resubmit the data.";

        if ( id == null || id.length() != 10 ) {
            // The parameter contains no data, so throw the exception.
            throw new IllegalArgumentException(msg);
        } else {
            // We now know the data is valid, so we can store it.
            this.isa.setReceiverId(id);
        }
    }
    /**
     * Retrieves the Interchange Receiver ID (ISA08) field value that was 
     * previously stored.
     * 
     * @return the Interchange Receiver ID value
     */
    public String getReceiverID() {
        return this.isa.getReceiverId();
    }
    
    
    //</editor-fold>
    
    //<editor-fold desc=" Constructor ">
    
    //</editor-fold>
    
}