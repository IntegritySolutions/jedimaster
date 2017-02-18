/* {InterchangeCtl.java}
 * This class maintains all storage and validation of EDI Interchange Control
 * Headers (ISA) and Trailers (IEA) segments.
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
package com.is2300.jedi.edi.global.supl;

/**
 * <table border="0" summary="">
 *  <tr>
 *      <td align="right"><strong>Segment:</strong></td>
 *      <td>ISA Interchange Control Header</td>
 *  </tr>
 *  <tr>
 *      <td align="right"><strong>Position:</strong></td>
 *      <td>005</td>
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
 *      <td>To start and identify an interchange of one or more functional
 *          groups and interchange-related control segments.</td>
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
 *      <td bgcolor="LightGrey"><code>ISA*00*          *00*          *09*005070479ff    *ZZ*X0000X00       *931001*1020*U*00200*000000001*0*P*\@</code></td>
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
 *      <td><strong>ISA01</strong></td>
 *      <td><strong>I01</strong></td>
 *      <td><strong>Authorization Information Qualifier</strong></td>
 *      <td><strong>M &nbsp; ID 2/2</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>Code to identify the type of information in the Authorization 
 *          Information
 *          <table summary="ISA01">
 *              <tr>
 *                  <td>00 &nbsp;&nbsp; </td>
 *                  <td>No Authorization Information Present (No Meaningful
 *                      Information in I02)</td>
 *              </tr>
 *          </table></td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td><strong>ISA02</strong></td>
 *      <td><strong>I02</strong></td>
 *      <td><strong>Authorization Information</strong></td>
 *      <td><strong>M &nbsp; AN 10/10</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>Information used for additional identification or authorization of
 *          the sender or the data in the interchange. The type of information
 *          is set by the Authorization Information Qualifier.</td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td><strong>ISA03</strong></td>
 *      <td><strong>I03</strong></td>
 *      <td><strong>Security Information Qualifier</strong></td>
 *      <td><strong>M &nbsp; ID 2/2</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>Code to identify the type of information in the Security 
 *          Information
 *          <table summary="ISA03">
 *              <tr>
 *                  <td>00 &nbsp;&nbsp; </td>
 *                  <td>No Security Information Present (No Meaningful
 *                      Information in I04)</td>
 *              </tr>
 *          </table></td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td><strong>ISA04</strong></td>
 *      <td><strong>I04</strong></td>
 *      <td><strong>Security Information</strong></td>
 *      <td><strong>M &nbsp; AN 10/10</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>This is used for identifying the security information about the
 *          sender or the data in the interchange. The type of information is
 *          set by the Security Information Qualifier.</td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td><strong>ISA05</strong></td>
 *      <td><strong>I05</strong></td>
 *      <td><strong>Interchange ID Qualifier</strong></td>
 *      <td><strong>M &nbsp; ID 2/2</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>Qualifier to designate the system/method of code structure used to
 *          designate the sender or receiver ID element being qualified.
 *          <table summary="ISA05">
 *              <tr>
 *                  <td>09 &nbsp;&nbsp; </td>
 *                  <td>X.121 (CCITT)</td>
 *              </tr>
 *          </table></td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td><strong>ISA06</strong></td>
 *      <td><strong>I06</strong></td>
 *      <td><strong>Interchange Sender ID</strong></td>
 *      <td><strong>M &nbsp; AN 15/15</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>Identification code published by the sender for other parties to use
 *          as the receiver ID to route data to them. The sender always codes 
 *          this number in the sender ID element.
 *          <table summary="ISA05">
 *              <tr>
 *                  <td>ZZ &nbsp;&nbsp; </td>
 *                  <td>Mutually Defined</td>
 *              </tr>
 *          </table></td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td bgcolor="LightGrey">005070479 = CATERPILLAR DUNS CODE +. ff = 
 *          CATERPILLAR FACILITY CODE. &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
 *          (see APPENDICES)</td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td><strong>ISA07</strong></td>
 *      <td><strong>I05</strong></td>
 *      <td><strong>Interchange Receiver ID</strong></td>
 *      <td><strong>M &nbsp; ID 2/2</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>Qualifier to designate the system/method of code structure used to
 *          designate the sender or receiver ID element being qualified.
 *          <table summary="ISA07">
 *              <tr>
 *                  <td>ZZ &nbsp;&nbsp; </td>
 *                  <td>Mutually Defined</td>
 *              </tr>
 *          </table></td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td><strong>ISA08</strong></td>
 *      <td><strong>I07</strong></td>
 *      <td><strong>Interchange Receiver ID</strong></td>
 *      <td><strong>M &nbsp; AN 15/15</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>Identification code published by the receiver of the data. When
 *          sending, it is used by the sender as their sending ID, thus other
 *          parties sending to them will use this as a receiving ID to route
 *          data to them.</td>
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
 *      <td><strong>ISA09</strong></td>
 *      <td><strong>I08</strong></td>
 *      <td><strong>Interchange Date</strong></td>
 *      <td><strong>M &nbsp; DT 6/6</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>Date of the interchange.</td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td><strong>ISA10</strong></td>
 *      <td><strong>I09</strong></td>
 *      <td><strong>Interchange Time</strong></td>
 *      <td><strong>M &nbsp; TM 4/4</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>Time of the interchange.</td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td><strong>ISA11</strong></td>
 *      <td><strong>I10</strong></td>
 *      <td><strong>Interchange Control Standards Identifier</strong></td>
 *      <td><strong>M &nbsp; ID 1/1</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>Code to identify the agency responsible for the control standard
 *          used by the message that is enclosed by the interchange header and
 *          trailer.
 *          <table summary="ISA07">
 *              <tr>
 *                  <td>U &nbsp;&nbsp; </td>
 *                  <td>U.S. EDI Community of ASC X12, TDCC, and UCS</td>
 *              </tr>
 *          </table></td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td><strong>ISA12</strong></td>
 *      <td><strong>I11</strong></td>
 *      <td><strong>Interchange Control Version Number</strong></td>
 *      <td><strong>M &nbsp; ID 5/5</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>This version number covers the interchange control segments.</td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td bgcolor="LightGrey">INTERCHANGE CONTROL VERSION VARIES DEPENDING ON
 *          THE VERSION OF THE TRANSACTION THE 997 IS ACKNOWLEDGING IN 997
 *          SITUATIONS. OTHERWISE USE 00200, WHICH IS THE STANDARD ISSUED AS
 *          ANSI X12.5-1987.</td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td><strong>ISA13</strong></td>
 *      <td><strong>I12</strong></td>
 *      <td><strong>Interchange Control Number</strong></td>
 *      <td><strong>M &nbsp; N0 9/9</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>This number uniquely identifies the interchange data to the sender.
 *          It is assigned by the sender. Together with the sender ID it
 *          uniquely identifies the interchange data to the receiver. It is
 *          suggested that the sender, receiver, and all third parties be able 
 *          to maintain an audit trail of interchanges using this number.</td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td><strong>ISA14</strong></td>
 *      <td><strong>I13</strong></td>
 *      <td><strong>Acknowledgment Requested</strong></td>
 *      <td><strong>M &nbsp; ID 1/1</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>Code sent by the sender to request an interchange acknowledgment.
 *          <table summary="ISA14">
 *              <tr>
 *                  <td>0 &nbsp; &nbsp; </td>
 *                  <td> No Acknowledgment Requested</td>
 *              </tr>
 *              <tr>
 *                  <td><em>1 &nbsp; &nbsp; </em></td>
 *                  <td><em>Acknowledgment Requested</em></td>
 *              </tr>
 *          </table></td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td><strong>ISA15</strong></td>
 *      <td><strong>I14</strong></td>
 *      <td><strong>Test Indicator</strong></td>
 *      <td><strong>M &nbsp; ID 1/1</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>Code to indicate whether data enclosed by this interchange envelope
 *          is test or production.
 *          <table summary="ISA15">
 *              <tr>
 *                  <td>P &nbsp; &nbsp; </td>
 *                  <td>Production Data</td>
 *              </tr>
 *              <tr>
 *                  <td><em>T &nbsp; &nbsp; </em></td>
 *                  <td><em>Test Data</em></td>
 *              </tr>
 *          </table></td>
 *      <td> &nbsp; </td>
 *  </tr>
 *  <tr>
 *      <td><strong>ISA16</strong></td>
 *      <td><strong>I15</strong></td>
 *      <td><strong>Subelement Separator</strong></td>
 *      <td><strong>M &nbsp; AN 1/1</strong></td>
 *  </tr>
 *  <tr>
 *      <td> &nbsp; </td>
 *      <td> &nbsp; </td>
 *      <td>This is a field reserved for future expansion in separating data 
 *          element subgroups. (In the interest of a migration to international
 *          standards, this must be different from the data element separator).
 *      </td>
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
public class InterchangeCtlHdr {
    //<editor-fold desc=" Private Member Fields ">
    /**
     * <strong>Authorization Information Qualifier</strong> <em>Data Element:</em>
     * I01.
     * <p>
     * <em>Required Length:</em> 2 characters<br>
     * <em>Element Style:</em> Identification value
     * <p>
     * Code to identify the type of information in the Authorization Information
     * (ISA02).
     */
    private String ISA01;   // Authorization Information Qualifier
    /**
     * <strong>Authorization Information</strong> <em>Data Element:</em> I02.
     * <p>
     * <em>Required Length:</em> 10 characters<br>
     * <em>Element Style:</em> Authorization Number
     * <p>
     * Information used for additional identification or authorization of the 
     * sender or the data in the interchange. The type of information is set by
     * the Authorization Information Qualifier (ISA01).
     */
    private String ISA02;   // Authorization Information
    /**
     * <strong>Security Information Qualifier</strong> <em>Data Element:</em>
     * I03.
     * <p>
     * <em>Required Length:</em> 2 characters<br>
     * <em>Element Style:</em> Identification value
     * <p>
     * Code to identify the type of information in the Security Information
     * (ISA04).
     */
    private String ISA03;   // Security Information Qualifier
    /**
     * <strong>Security Information</strong> <em>Data Element:</em> I04.
     * <p>
     * <em>Required Length:</em> 10 characters<br>
     * <em>Element Style:</em>Authorization Number
     * <p>
     * This is used for identifying the security information about the sender or
     * the data in the interchange. The type of information is set by the 
     * Security Information Qualifier (ISA03).
     */
    private String ISA04;   // Security Information
    /**
     * <strong>Interchange ID Qualifier</strong> <em>Data Element:</em> I05.
     * <p>
     * <em>Required Length:</em> 2 characters<br>
     * <em>Element Style:</em> Identification value
     * <p>
     * Qualifier to designate the system/method of code structure used to
     * designate the sender or receiver ID element being qualified.
     */
    private String ISA05;   // Interchange ID Qualifier
    /**
     * <strong>Interchange Sender ID</strong> <em>Data Element:</em> I06.
     * <p>
     * <em>Required Length:</em> 15 characters<br>
     * <em>Element Style:</em> Authorization Number
     * <p>
     * Identification code published by the sender for other parties to use as
     * the receiver ID to route data to them. The sender always codes this 
     * number in the sender ID element.
     */
    private String ISA06;   // Interchange Sender ID
    /**
     * <strong>Interchange ID Qualifier</strong> <em>Data Element:</em> I05.
     * <p>
     * <em>Required Length:</em> 2 characters<br>
     * <em>Element Style:</em> Identification value
     * <p>
     * Qualifier to designate the system/method of code structure used to
     * designate the sender or receiver ID element being qualified.
     */
    private String ISA07;   // Interchange ID Qualifier
    /**
     * <strong>Interchange Receiver ID</strong> <em>Data Element:</em> I07.
     * <p>
     * <em>Required Length:</em> 15 characters<br>
     * <em>Element Style:</em> Authorization Number
     * <p>
     * Identification code published by the receiver of the data. When sending, 
     * it is used by the sender as their sending ID, thus other parties sending
     * to them will use this as a receiving ID to rout data to them.
     */
    private String ISA08;   // Interchange Receiver ID
    /**
     * <strong>Interchange Date</strong> <em>Data Element:</em> I08.
     * <p>
     * <em>Required Length:</em> 6 characters: Formatted YYMMDD<br>
     * <em>Element Style:</em> Date value
     * <p>
     * Date of the interchange.
     */
    private String ISA09;   // Interchange Date
    /**
     * <strong>Interchange Time</strong> <em>Data Element:</em> I09.
     * <p>
     * <em>Required Length:</em> 4 characters: Formatted HHMM<br>
     * <em>Element Style:</em> Time value
     * <p>
     * Time of the interchange.
     */
    private String ISA10;   // Interchange Time
    /**
     * <strong>Interchange Control Standards Identifier</strong>
     * <em>Data Element:</em> I10.
     * <p>
     * <em>Required Length:</em> 1 character<br>
     * <em>Element Style:</em> Identification value
     * <p>
     * Code to identify the agency responsible for the control standard used by
     * the message that is enclosed by the interchange header and trailer.
     */
    private String ISA11;   // Interchange Control Standards Identifier
    /**
     * <strong>Interchange Control Version Number</strong>
     * <em>Data Element:</em> I11.
     * <p>
     * <em>Required Length:</em> 5 characters<br>
     * <em>Element Style:</em> Identification value
     * <p>
     * This version number covers the interchange control segments.
     */
    private String ISA12;   // Interchange Control Version Number
    /**
     * <strong>Interchange Control Number</strong> <em>Data Element:</em> I12.
     * <p>
     * <em>Required Length:</em> 9 characters<br>
     * <em>Element Style:</em> Numerical zero-filled
     * <p>
     * This number uniquely identifies the interchange data to the sender. It is
     * assigned by the sender. Together with the sender ID it uniquely identifies
     * the interchange data to the receiver. It is suggested that the sender,
     * receiver, and all third parties be able to maintain an audit trail of 
     * interchanges using this number.
     */
    private String ISA13;   // Interchange Control Number
    /**
     * <strong>Acknowledgment Requested</strong> <em>Data Element:</em> I13.
     * <p>
     * <em>Required Length:</em> 1 character<br>
     * <em>Element Style:</em> Identification value (either 0 or 1)
     * <p>
     * Code sent by the sender to request an interchange acknowledgment.
     */
    private Boolean ISA14;  // Acknowledgment Requested
    /**
     * <strong>Test Indicator</strong> <em>Data Element:</em> I14.
     * <p>
     * <em>Required Length:</em> 1 character<br>
     * <em>Element Style:</em> Identification value (either P or T)
     * <p>
     * Code to indicate whether the data enclosed by this interchange envelope
     * is test or production.
     */
    private char ISA15;   // Test Indicator
    /**
     * <strong>Subelement Separator</strong> <em>Data Element:</em> I15.
     * <p>
     * <em>Required Length:</em> 1 character<br>
     * <em>Element Style:</em> Authorization Number (typically @)
     * <p>
     * This is a field reserved for future expansion in separating data element
     * subgroups. (In the interest of a migration to international standards, 
     * this must be different from the data element separator).
     */
    private String ISA16;   // Subelement Separator
    //</editor-fold>
    
    //<editor-fold desc=" Property Getters and Setters ">
    /**
     * Retrieves the Authorization Information Qualifier (ISA01) field value for
     * the Interchange Control Header (ISA) segment of an EDI transmission.
     * 
     * @return the Authorization Information Qualifier value
     */
    public String getAuthInfoQualifier() {
        return ISA01;
    }
    /**
     * Stores the Authorization Information Qualifier (ISA01) field value for 
     * the Interchange Control Header (ISA) segment of an EDI transmission from
     * the EDI file for later use.
     * 
     * @param qualCode the Authorization Information Qualifier value
     */
    public void setAuthInfoQualifier(String qualCode) {
        this.ISA01 = qualCode;
    }
    /**
     * Retrieves the Authorization Information (ISA02) field value for the
     * Interchange Control Header (ISA) segment of an EDI transmission.
     * 
     * @return the Authorization Information value
     */
    public String getAuthInfo() {
        return ISA02;
    }
    /**
     * Stores the Authorization Information (ISA02) field value for the
     * Interchange Control Header (ISA) segment of an EDI transmission from the
     * incoming EDI file for later use.
     * 
     * @param authInfo the Authorization Information value
     */
    public void setAuthInfo(String authInfo) {
        this.ISA02 = authInfo;
    }
    /**
     * Retrieves the Security Information Qualifier (ISA03) field value for the
     * Interchange Control Header (ISA) segment of an EDI transmission.
     * 
     * @return the Security Information Qualifier value
     */
    public String getSecInfoQualifier() {
        return ISA03;
    }
    /**
     * Stores the Security Information Qualifier (ISA03) field value for the
     * Interchange Control Header (ISA) segment of an EDI transmission from the
     * incoming EDI file.
     * 
     * @param qualCode the Security Information Qualifier value
     */
    public void setSecInfoQualifier(String qualCode) {
        this.ISA03 = qualCode;
    }
    /**
     * Retrieves the Security Information (ISA04) field value for the 
     * Interchange Control Header (ISA) segment of an EDI transmission.
     * 
     * @return the Security Information value
     */
    public String getSecInfo() {
        return ISA04;
    }
    /**
     * Stores the Security Information (ISA04) field value for the 
     * Interchange Control Header (ISA) segment of an EDI transmission from the
     * incoming EDI file for later use.
     * 
     * @param secInfo the Security Information value
     */
    public void setSecInfo(String secInfo) {
        this.ISA04 = secInfo;
    }
    /**
     * Retrieves the Interchange ID Qualifier (ISA05) field value for the
     * Interchange Control Header (ISA) segment of an EDI transmission.
     * 
     * @return the Interchange ID Qualifier value
     */
    public String getIdQualifier05() {
        return ISA05;
    }
    /**
     * Stores the Interchange ID Qualifier (ISA05) field value for the
     * Interchange Control Header (ISA) segment of an EDI transmission from the
     * incoming EDI file for later use.
     * 
     * @param qualCode the Interchange ID Qualifier value
     */
    public void setIdQualifier05(String qualCode) {
        this.ISA05 = qualCode;
    }
    /**
     * Retrieves the Interchange Sender ID (ISA06) field value for the
     * Interchange Control Header (ISA) segment of an EDI transmission.
     * 
     * @return the Interchange Sender ID value
     */
    public String getSenderId() {
        return ISA06;
    }
    /**
     * Stores the Interchange Sender ID (ISA06) field value for the 
     * Interchange Control Header (ISA) segment of an EDI transmission from the
     * incoming EDI file for later use.
     * 
     * @param sender the Interchange Sender ID value
     */
    public void setSenderId(String sender) {
        this.ISA06 = sender;
    }
    /**
     * Retrieves the Interchange ID Qualifier (ISA07) field value for the 
     * Interchange Control Header (ISA) segment of an EDI transmission.
     * 
     * @return the Interchange ID Qualifier value
     */
    public String getIdQualifer07() {
        return ISA07;
    }
    /**
     * Stores the Interchange ID Qualifier (ISA07) field value for the
     * Interchange Control Header (ISA) segment of an EDI transmission from the
     * incoming EDI file for later use.
     * 
     * @param qualCode the Interchange ID Qualifier value
     */
    public void setIdQualifier07(String qualCode) {
        this.ISA07 = qualCode;
    }
    /**
     * Retrieves the Interchange Receiver ID (ISA08) field value for the
     * Interchange Control Header (ISA) segment of an EDI transmission.
     * 
     * @return the Interchange Receiver ID value
     */
    public String getReceiverId() {
        return ISA08;
    }
    /**
     * Stores the Interchange Receiver ID (ISA08) field value for the
     * Interchange Control Header (ISA) segment of an EDI transmission from the
     * incoming EDI file for later use.
     * 
     * @param receiver the Interchange Receiver ID value
     */
    public void setReceiverId(String receiver) {
        this.ISA08 = receiver;
    }
    /**
     * Retrieves the Interchange Date (ISA09) field value for the Interchange
     * Control Header (ISA) segment of an EDI transmission. This field is a six
     * or eight character field that holds a <tt>
     * <a href="http://docs.oracle.com/javase/8/docs/api/java/lang/String.html">
     * java.lang.String</a></tt> representation of the transmission date in one
     * of the following formats:
     * <p>
     * <ul>
     *  <li>YYMMDD</li>
     *  <li>YYYYMMDD</li>
     * </ul>
     * 
     * @return the <tt>java.lang.String</tt> representation of the transmission
     *          date
     */
    public String getInterDate() {
        return ISA09;
    }
    /**
     * Stores the Interchange Date (ISA09) field value for the Interchange
     * Control Header (ISA) segment of an EDI transmission from the incoming
     * EDI file for later use.
     * 
     * @param date the Interchange Date
     */
    public void setInterDate(String date) {
        this.ISA09 = date;
    }
    /**
     * Retrieves the Interchange Time (ISA10) field value for the Interchange
     * Control Header (ISA) segment of an EDI transmission. This field is a four
     * or six character field that holds a <tt>
     * <a href="http://docs.oracle.com/javase/8/docs/api/java/lang/String.html">
     * java.lang.String</a></tt> representation of the transmission time in one
     * of the following formats:
     * <p>
     * <ul>
     *  <li>HHMM</li>
     *  <li>HHMMSS</li>
     * </ul>
     * 
     * @return the <tt>java.lang.String</tt> representation of the transmission
     *          time
     */
    public String getInterTime() {
        return ISA10;
    }
    /**
     * Stores the Interchange Time (ISA10) field value for the Interchange
     * Control Header (ISA) segment of an EDI transmission from the incoming EDI
     * file for later use.
     * 
     * @param time the Interchange Time
     */
    public void setInterTime(String time) {
        this.ISA10 = time;
    }
    /**
     * Retrieves the Interchange Control Standards Identifier (ISA11) field
     * value for the Interchange Control Header (ISA) segment of an EDI
     * transmission.
     * 
     * @return the Interchange Control Standards Identifier value
     */
    public String getCtlStandards() {
        return ISA11;
    }
    /**
     * Stores the Interchange Control Standards Identifier (ISA11) field value
     * for the Interchange Control Header (ISA) segment of an EDI tranmission
     * from the incoming EDI file.
     * 
     * @param ctlStandards the Interchange Control Standards Identifier value
     */
    public void setCtlStandards(String ctlStandards) {
        this.ISA11 = ctlStandards;
    }
    /**
     * Retrieves the Interchange Control Version Number (ISA12) field value for
     * the Interchange Control Header (ISA) for an EDI transmission.
     * 
     * @return the Interchange Control Version Number value
     */
    public String getCtlVersionNumber() {
        return ISA12;
    }
    /**
     * Stores the Interchange Control Version Number (ISA12) field value for the
     * Interchange Control Header (ISA) for an EDI transmission from the incoming
     * EDI file for later use.
     * 
     * @param ctVersion the Interchange Control Version Number value
     */
    public void setCtlVersionNumber(String ctVersion) {
        this.ISA12 = ctVersion;
    }
    /**
     * Retrieves the Interchange Control Number (ISA13) field value for the
     * Interchange Control Header (ISA) segment of an EDI transmission.
     * 
     * @return the Interchange Control Number value
     */
    public String getInterCtlNumber() {
        return ISA13;
    }
    /**
     * Stores the Interchange Control Number (ISA13) field value for the
     * Interchange Control Header (ISA) segment of an EDI transmission from the
     * incoming EDI file for later use.
     * 
     * @param ctlNumber the Interchange Control Number value
     */
    public void setInterCtlNumber(String ctlNumber) {
        this.ISA13 = ctlNumber;
    }
    /**
     * Checks whether or not an Acknowledgment is Requested by the sender of an
     * EDI transmission.
     * 
     * @return 'true' if a Functional Acknowledgment (997) is requested by the
     *          send to be sent back; 'false' otherwise.
     */
    public Boolean is997Requested() {
        return ISA14;
    }
    /**
     * Sets whether or not an Acknowledgment is Requested by the sender of an
     * EDI transmission.
     * 
     * @param ISA14 'true' the Functional Acknowledgment (997) has been 
     *              requested; 'false' otherwise
     */
    public void set997Request(Boolean ISA14) {
        this.ISA14 = ISA14;
    }
    /**
     * Retrieves the Test Indicator (ISA15) field value for the Interchange
     * Control Header (ISA) segment of an EDI transmission. This indicates 
     * whether the data transmitted is test ('T') or production ('P') data.
     * 
     * @return the Test Indicator value
     */
    public char getTestIndicator() {
        return ISA15;
    }
    /**
     * Stores the Test Indicator (ISA15) field value for the Interchange Control
     * Header (ISA) segment of an EDI transmission from the incoming EDI file.
     * 
     * @param indicator the Test Indicator value
     */
    public void setTestIndicator(char indicator) {
        this.ISA15 = indicator;
    }
    /**
     * Retrieves the Subelement Terminator (ISA16) field value for the 
     * Interchange Control Header (ISA) segment for an EDI transmission. This
     * character is used to delineate the end of a subelement that may stretch
     * across multiple segments in an EDI transaction set.
     * 
     * @return the Subelement Terminator value
     */
    public String getSubelementTerminator() {
        return ISA16;
    }
    /**
     * Stores the Subelement Terminator (ISA16) field value for the Interchange
     * Control Header (ISA) segment for an EDI transmission from the incoming
     * EDI file for later use.
     * 
     * @param terminatorChar the Subelement Terminator used in the transmission.
     */
    public void setSubelementTerminator(String terminatorChar) {
        this.ISA16 = terminatorChar;
    }
    //</editor-fold>
    
    //<editor-fold desc=" Constructor ">
    /**
     * Creates a default instance of the Interchange Control Header object. This
     * constructor initializes all fields to accordingly and to their best 
     * possible default values.
     */
    public InterchangeCtlHdr () {
        // Initialize our fields to their appropriate initial values.
        this.ISA01 = "";
        this.ISA02 = "";
        this.ISA03 = "";
        this.ISA04 = "";
        this.ISA05 = "";
        this.ISA06 = "";
        this.ISA07 = "";
        this.ISA08 = "";
        this.ISA09 = "";
        this.ISA10 = "";
        this.ISA11 = "";
        this.ISA12 = "";
        this.ISA13 = "";
        this.ISA14 = false;
        this.ISA15 = 'P';
        this.ISA16 = "@";
    }
    //</editor-fold>
    
}