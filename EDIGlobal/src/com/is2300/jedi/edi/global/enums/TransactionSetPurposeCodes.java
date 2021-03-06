/* {TransactionSetPurposeCodes.java}
 * This enumeration provides access to all of the codes for the purposes of the
 * transaction sets in an EDI transmission document. This enumeration will need
 * to be updated as new transaction set purpose codes are discovered.
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
public enum TransactionSetPurposeCodes {
    ORIGINAL("01"),
    DELETE("03");
    
    private String value;
    
    private TransactionSetPurposeCodes(String val) {
        this.value = val;
    }
    
    
    @Override
    public String toString() {
        String retVal = null;
        
        switch (this.value) {
            case "01":
                retVal = "Original";
                break;
            case "03":
                retVal = "Delete";
                break;
            default:
                retVal = "Undefined Transaction Set Purpose Code";
                break;
        }
        
        return retVal;
    }
}
