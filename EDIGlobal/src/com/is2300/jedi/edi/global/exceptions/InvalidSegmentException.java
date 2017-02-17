/* {InvalidSegmentException.java}
 * 
 * An Exception for handling invalid EDI Document Segments.
 * 
 * Copyright (C) 2017 Integrity Solutions
 *
 * This source code is protected by US and International Copyright 
 * Laws and Treaties. All code contained is proprietary information
 * and may not be divulged or disclosed to any third party without
 * the direct, written consent of the officers of Integrity Solutions.
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
