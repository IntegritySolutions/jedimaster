/* {FGAcknowledgmentCode.java}
 * This enumeration provides the valid acknowledgment codes for the Functional
 * Groups in a Functional Acknowledgment (997) EDI document.
 *
 * Copyright (C) 2017 Integrity Solutions
 *
 * This source code is protected by US and International Copyright 
 * Laws and Treaties. All code contained is proprietary information
 * and may not be divulged or disclosed to any third party without
 * the direct, written consent of the officers of Integrity Solutions.
 */
package com.is2300.jedi.edi.global.enums;

/**
 * This <a href="http://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html">
 * enum</a>eration provides the valid acknowledgment codes for the Functional
 * Groups in a Functional Acknowledgment (997) EDI document.
 * <p>
 * <strong><em>Functional Group Acknowledgment Codes</em></strong>
 * <table summary="Functional Group Acknowledgment Codes">
 *  <tr>
 *      <th>Code</th>
 *      <th>Description</th>
 *  </tr>
 *  <tr>
 *      <td>A</td>
 *      <td>Accepted</td>
 *  <tr>
 *      <td>E</td>
 *      <td>Accepted, But Errors Were Noted</td>
 *  </tr>
 *  <tr>
 *      <td>P</td>
 *      <td>Partially Accepted, At Least One Transaction Set Was Rejected</td>
 *  </tr>
 *  <tr>
 *      <td>R</td>
 *      <td>Rejected</td>
 *  </tr>
 * </table>
 *
 * @author Sean Carrick
 * @version 0.5.0
 * @since 0.5.0
 */
public enum FGAcknowledgmentCode {
    ACCEPTED('A'),
    ACCEPTED_WITH_ERRORS('E'),
    PARTIALLY_ACCEPTED('P'),
    REJECTED('R');
    
    private char value;
    
    private FGAcknowledgmentCode ( char val ) {
        this.value = val;
    }
    
    /**
     * Converts the <tt>
     * <a href="http://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html">
     * java.lang.Enum</a></tt> value to an <tt>char</tt> value.
     * @return converted value to <tt>char</tt>
     */
    public char toChar() {
        return this.value;
    }
    /**
     * Retrieves the <tt>
     * <a href="http://docs.oracle.com/javase/8/docs/api/java/lang/String.html">
     * java.lang.String</a></tt> representation of this <tt>
     * <a href="http://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html">
     * java.lang.Enum</a></tt> object.
     * @return <tt>String</tt> representation of this <tt>Enum</tt> value
     */
    
    @Override
    public String toString() {
        String retVal = "";
        
        switch ( this.value ) {
            case ('A'):
                retVal = "Accepted";
                break;
            case ('E'):
                retVal = "Accepted with Errors";
                break;
            case ('P'):
                retVal = "Partially Accepted, at least one Transaction Set "
                        + "Rejected";
                break;
            case ('R'):
                retVal = "Rejected";
                break;
            default:
                retVal = "Undefined Value";
                break;
        }
        
        return retVal;
    }
}