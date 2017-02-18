/* {TSResponseHdr.java}
 * This class handles all details of the Transaction Set Response Header (AK2)
 * segments in a Functional Acknowledgment (997) transaction.
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

package com.is2300.jedi.edi.fa997.segments;

/**
 * <table border="0" summary="">
 *  <tr>
 *      <td align="right"><strong>Segment:</strong></td>
 *      <td>AK2 Transaction Set Response Header</td>
 *  </tr>
 *  <tr>
 *      <td align="right"><strong>Position:</strong></td>
 *      <td>030</td>
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
 *      <td>Optional</td>
 *  </tr>
 *  <tr>
 *      <td align="right"><strong>Max Use:</strong></td>
 *      <td>1</td>
 *  </tr>
 *  <tr>
 *      <td align="right"><strong>Purpose:</strong></td>
 *      <td>To start acknowledgment of a single transaction set</td>
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
 *      <td><ol><li>AK201 is the transaction set ID found in the ST segment 
 *                  (ST01) in the transaction set being acknowledged.</li>
 *              <li>AK202 is the transaction set control number found in the ST
 *                  segment in the transaction set being acknowledged.</li>
 *          </ol></td>
 *  </tr>
 *  <tr>
 *      <td align="right"><strong>Notes:</strong></td>
 *      <td bgcolor="LightGrey">AK2*856*000011111@</td>
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
 *      <td><strong>AK201</strong></td>
 *      <td><strong>143</strong></td>
 *      <td><strong>Transaction Set Identifier Code</strong></td>
 *      <td><strong>M &nbsp; ID 3/3</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>Code uniquely identifying a transaction set</td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td bgcolor="LightGrey">TRANSACTION SET IDENTIFIER CODE VARIES DEPENDING
 *                              ON THE TRANSACTION TYPE THE 997 IS ACKNOWLEDGING
 *      </td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td><strong>AK202</strong></td>
 *      <td><strong>329</strong></td>
 *      <td><strong>Transaction Set Control Number</strong></td>
 *      <td><strong>M &nbsp; AN 4/9</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>Identifying control number assigned by the originator for a 
 *          transaction set</td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td bgcolor="LightGrey">TRANSACTION SET CONTROL NUMBER FROM THE 'ST' 
 *                          SEGMENT OF THE TRANSACTION BEING ACKNOWLEDGED</td>
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
public class TSResponseHdr {
    //<editor-fold desc=" Private Member Fields ">
    /**
     * <strong>Transaction Set Identifier Code</strong> <em>Data Element: 143</em>
     * <p>
     * <em>Required Length:</em> 3 Characters<br>
     * <em>Element Style:</em> Identification<br>
     * <em>Usage:</em> <strong>Mandatory</strong>
     * <p>
     * Code uniquely identifying a Transaction Set.
     */
    private String AK201;   // Transaction Set Identifier Code
    /**
     * <strong>Transaction Set Control Number</strong> <em>Data Element: 329</em>
     * <p>
     * <em>Required Length:</em> 4 Characters (9 max)<br>
     * <em>Element Style:</em> Alphanumeric<br>
     * <em>Usage:</em> <strong>Mandatory</strong>
     * <p>
     * IDentifying control number assigned by the originator for a transaction 
     * set.
     */
    private String AK202;   // Transaction Set Control Number
    //</editor-fold>
    
    //<editor-fold desc=" Property Getters and Setters ">
    /**
     * Retrieves the Transaction Set Identifier Code for reporting purposes.
     * @return the Transaction Set Identifier Code (AK201) field
     */
    public String getTransactionSetIdentifierCode() {
        return AK201;
    }
    
    /**
     * Stores the Transaction Set Identifier Code for future use.
     * @param AK201 the Transaction Set Identifier Code from the EDI document
     */
    public void setTransactionSetIdentifierCode(String AK201) {
        this.AK201 = AK201;
    }

    /**
     * Retrieves the Transaction Set Control Number for reporting purposes.
     * @return the Transaction Set Control Number (AK202) field
     */
    public String getTransactionSetControlNumber() {
        return AK202;
    }

    /**
     * Stores the Transaction Set Control Number for future use.
     * @param AK202 the Transaction Set Control Number from the EDI document
     */
    public void setTransactionSetControlNumber(String AK202) {
        this.AK202 = AK202;
    }
    //</editor-fold>
    
    //<editor-fold desc=" Constructors ">
    /**
     * Creates a default <tt>AK2Segment</tt> class with its properties set to
     * <tt>null</tt>.
     */
    public TSResponseHdr() {
        this.AK201 = null;  // Nullified instantiation
        this.AK202 = null;  // Nullified instantiation
    }   // End default constructor.
    
    /**
     * Creates an <tt>AK2Segment</tt> class with its properties set to the
     * values supplied.
     * @param AK201Field Transaction Set Identifier Code from the EDI document
     * @param AK202Field Transaction Set Control Number from the EDI document
     */
    public TSResponseHdr(String AK201Field, String AK202Field) {
        this.AK201 = AK201Field;    // Supplied initialization
        this.AK202 = AK202Field;    // Supplied initialization
    }
    //</editor-fold>
}
