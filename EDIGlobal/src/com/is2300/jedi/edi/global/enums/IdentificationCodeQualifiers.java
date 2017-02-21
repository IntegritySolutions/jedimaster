/* {IdentificationCodeQualifiers.java}
 * This enumeration provides access to all of the possible identification code
 * qualifiers that describe the identification code being used within an EDI
 * transmission document. This enumeration will need to be updated as new
 * identification code qualifiers are discovered.
 *
 * Copyright (c) 2017 Integrity Solutions
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
package com.is2300.jedi.edi.global.enums;

/**
 *
 * @author Sean Carrick
 * &lt;<a href="mailto:PekinSOFT@outlook.com">PekinSOFT@outlook.com</a>&gt;
 */
public enum IdentificationCodeQualifiers {
    DUNS_NUMBER(1),
    SCAC(2),
    IATA(4),
    ASSIGNED_BY_SELLER(91),
    ASSIGNED_BY_BUYER(92);
    
    private int value;
    
    private IdentificationCodeQualifiers(int val) {
        this.value = val;
    }
    
    
    public Integer toInteger() {
        return this.value;
    }
    
    
    @Override
    public String toString() {
        String retVal = null;
        
        switch(this.value) {
            case 1:
                retVal = "D-U-N-S Number, Dun & Bradstreet";
                break;
            case 2:
                retVal = "Standard Carrier Alpha Code (SCAC)";
                break;
            case 4:
                retVal = "International Air Transport Association (IATA)";
                break;
            case 91:
                retVal = "Assigned by Seller or Seller's Agent";
                break;
            case 92:
                retVal = "Assigned by Buyer or Buyer's Agent";
                break;
            default:
                retVal = "Undefined Identification Code Qualifier";
                break;
        }
        
        return retVal;
    }
}
