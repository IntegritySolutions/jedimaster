/* {InvalidSegmentException.java}
 * 
 * An Exception for handling invalid EDI Document Segments.
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
package com.is2300.jedi.edi.global.exceptions;

/**
 * The <tt>InvalidSegmentException</tt> is for catching invalid EDI Document
 * Segments that may be passed through EDI transmission files. 
 * 
 * @author Sean Carrick
 * &lt;<a href="mailto:PekinSOFT@outlook.com">PekinSOFT@outlook.com</a>&gt;
 * @version 0.5.0
 * @since 0.5.0
 */
public class InvalidSegmentException extends Exception {

    /**
     * Creates a new instance of <code>InvalidSegmentException</code> without
     * detail message.
     */
    public InvalidSegmentException() {
        super();
    }

    /**
     * Constructs an instance of <code>InvalidSegmentException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidSegmentException(String msg) {
        super(msg);
    }
}
