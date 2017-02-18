/* {SegmentValidator.java}
 * 
 * Allows programs to validate the EDI Document Segment Codes, i.e., BEG, LIN,
 * etc.
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
package com.is2300.jedi.edi.global.utils;

/**
 * A simple API for validating EDI Document Segment Codes. Since each EDI 
 * Document Type has different Segment requirements, this Validator API will 
 * need to be implemented on a document-by-document basis so that the document's
 * segments can be validated.
 * 
 * @author Sean Carrick
 * &lt;<a href="mailto:PekinSOFT@outlook.com">PekinSOFT@outlook.com</a>&gt;
 * @version 0.5.0
 * @since 0.5.0
 */
public interface SegmentValidator {
    boolean validate(String segment);
}
